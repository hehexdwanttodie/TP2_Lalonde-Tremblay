package livrable1.modele;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
			Album albumTemp = ;
			
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
	
	public boolean ajouterArtisteBD(Artiste artiste) {
		boolean ajout = false;

		String requete = "INSERT INTO Artiste(id_artiste, nom, membre, photo) VALUES ('" + artiste.getId() + "','"
				+ artiste.getNom() + "','" + artiste.getMembre() + "'.'" + artiste.getPhoto() + ")";

		try {
			Statement statement = conn.getConnexion().createStatement();
			statement.executeUpdate(requete);
			ajout = true;

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontré lors de l'ajout de l'artiste:" + sqle.getMessage(),
					"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return ajout;
	}

	public boolean supprimerArtisteBD(Artiste artiste) {
		boolean suppression = false;

		String requete = "DELETE FROM Artiste WHERE id_artiste =" + artiste.getId();

		try {
			Statement statement = conn.getConnexion().createStatement();
			statement.executeUpdate(requete);
			suppression = true;

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,
					"Problème rencontré lors de la suppression de l'artiste:" + sqle.getMessage(), "Résultat",
					JOptionPane.ERROR_MESSAGE);
		}

		return suppression;
	}

	public void ajouterArtiste(Artiste artiste) {
		listeArtiste.add(artiste);
		fireTableRowsInserted(listeArtiste.size() - 1, listeArtiste.size() - 1);
	}

	public void supprimerArtiste(int rowIndex) {
		listeArtiste.remove(rowIndex);
		// notification de la suppression de la ligne rowIndex à la ligne rowIndex
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void modifierArtiste(int firstRow, Artiste artiste) {
		listeArtiste.set(firstRow, artiste);
		fireTableRowsUpdated(firstRow, firstRow);
	}

	// ==========================================================================
	// permet de mettre à jour le modèle avec une nouvelle ArrayListe
	// et d'informer les vues affichant ce modèle
	public void setDonnees(ArrayList<Artiste> nouvellesDonnees) {
		listeArtiste = nouvellesDonnees;
		fireTableDataChanged();
	}

	public Artiste getElement(int row) {
		return listeArtiste.get(row);
	}
	
	public void rechercher() {
		
		String requete = "SELECT * FROM Artiste WHERE nom LIKE ?";
		
		try {
			PreparedStatement statement = conn.getConnexion().prepareStatement( requete );
			
			statement.setString(1, "%" + vue.textRecherche.getText() + "%");
			
			ResultSet jeuResult = statement.executeQuery();
			
			listeArtiste = new ArrayList<Artiste>();
			
			while ( jeuResult.next() ) {

				Artiste artiste = new Artiste(jeuResult.getInt("id_artiste"), jeuResult.getString("nom"), jeuResult.getBoolean("membre"), jeuResult.getString("photo"));
				
				listeArtiste.add(artiste);
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int nouvelArtiste() {
		
		String requete = "SELECT * FROM Artiste ORDER BY id_artiste desc";
		int id = 0;
		
		
		try {
			PreparedStatement statement = conn.getConnexion().prepareStatement( requete );
			
			ResultSet jeuResul = statement.executeQuery();
			
			id = jeuResul.getInt("id_artiste");
			
			vue.textNom.setText("");
			vue.checkBoxMembre.setSelected(false);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return id;
	}
	
	public int activerModification() {
		
		int id = 0;
		
		int artisteCourant = vue.getTable().getSelectedRow();
		
		Artiste a = listeArtiste.get(artisteCourant);
		
		id = a.getId();
		
		vue.textNom.setEnabled(true);
		vue.checkBoxMembre.setEnabled(true);
		
		return id;
	}
	
	public void modifierArtiste() {
		
		String requete = "UPDATE Artiste SET nom = ?, membre = ? WHERE id_artiste = ?";
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
