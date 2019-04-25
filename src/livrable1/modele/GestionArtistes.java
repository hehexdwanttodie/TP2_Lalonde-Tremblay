package livrable1.modele;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import livrable1.vue.VueArtiste;

public class GestionArtistes extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControleConnexion conn;
	String requete = "Select * from Artiste";
	public ArrayList<Artiste> listeArtiste = new ArrayList<Artiste>();
	public ArrayList<Album> listeAlbum = new ArrayList<Album>();
	private final String[] lesTitres = { "Id", "Nom", "Membre" };
	
	private String chemin = System.getProperty("user.dir");

	VueArtiste vue;

	public GestionArtistes() {
		this.listeArtiste = obtenirListeArtiste();
	}

	public GestionArtistes(ArrayList<Artiste> liste) {
		vue = new VueArtiste();

	}

	@Override
	public int getRowCount() {

		return listeArtiste.size();
	}

	@Override
	public int getColumnCount() {
		return lesTitres.length;
	}

	// pour accéder à un objet du modèle
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listeArtiste.get(rowIndex).getId();
		case 1:
			return listeArtiste.get(rowIndex).getNom();
		case 2:
			return listeArtiste.get(rowIndex).getMembre();

		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return int.class;
		case 1:
			return String.class;
		case 2:
			return Boolean.class;
		case 3:
			return String.class;
		default:
			throw new IllegalArgumentException(" index de colonne invalide: " + columnIndex);
		}
	}

	public ArrayList<Artiste> obtenirListeArtiste() {
		listeArtiste = new ArrayList<Artiste>();

		try {
			conn = new ControleConnexion();

			Statement statement = conn.getConnexion().createStatement();
			String requete = "Select * from Artiste";
			ResultSet jeuResultats = statement.executeQuery(requete);

			while (jeuResultats.next()) {
				Artiste artiste = new Artiste(jeuResultats.getInt("id_artiste"), jeuResultats.getString("nom"),
						jeuResultats.getBoolean("membre"), jeuResultats.getString("photo"));
				listeArtiste.add(artiste);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		conn.deconnexion();

		return listeArtiste;
	}

	public void afficherInfoArtiste() {

		int numLigne = vue.getTable().getSelectedRow();

		Artiste artiste = obtenirListeArtiste().get(numLigne);
		vue.textNumero.setText(artiste.getNum());
		vue.textNom.setText(artiste.getNom());

		ImageIcon imageIcon;
		Image image;
		Image icone;

		try {
			imageIcon = new ImageIcon( chemin + artiste.getPhoto() );
			image = imageIcon.getImage();

			icone = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(icone);
			vue.lblNewLabel_1.setIcon(imageIcon);
		} catch (Exception e) {
			imageIcon = new ImageIcon( chemin + "\\defaut.png");
			image = imageIcon.getImage();

			icone = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(icone);
			vue.lblNewLabel_1.setIcon(imageIcon);

		}
	}

	public ArrayList<Album> obtenirAlbum(int id_artiste) {

		listeAlbum = new ArrayList<Album>();

		if (conn != null) {

			try {
				Statement statement = conn.getConnexion().createStatement();

				ResultSet jeuResultats = statement
						.executeQuery("SELECT * FROM albums Where id_artiste = '" + id_artiste + "';");

				while (jeuResultats.next()) {

					listeAlbum.add(new Album(jeuResultats.getInt("id_album"), jeuResultats.getString("titre"),
							jeuResultats.getString("genre"), jeuResultats.getString("image"),
							jeuResultats.getInt("annee"), jeuResultats.getInt("id_artiste")));

				}

			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}

		return listeAlbum;

	}

	public void afficherImageAlbum() {
		
		if ( !vue.listAlbum.isSelectionEmpty() ) {
			//Album albumTemp = 
			
			ImageIcon imageIcon;
			Image image, icone;
			
			try {
				imageIcon = new ImageIcon( chemin + albumTemp.getImage() );
				image = imageIcon.getImage();
				icone = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon( icone );
				vue.lblNewLabel_2.setIcon( imageIcon );
				
			} catch ( Exception e ) {
				imageIcon = new ImageIcon( chemin + "\\default.png" );
				image = imageIcon.getImage();
				icone = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon( icone );
				vue.lblNewLabel_2.setIcon( imageIcon );
			}
			
		} else {
			vue.lblNewLabel_2.setIcon( null );
		}
	}
}
