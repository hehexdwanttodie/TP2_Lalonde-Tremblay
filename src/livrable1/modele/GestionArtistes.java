package livrable1.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class GestionArtistes extends AbstractTableModel{

	ControleConnexion conn;
	String requete = "Select * from Artiste";
	public ArrayList<Artiste> listeArtiste;
	public ArrayList<Album> listeAlbum;
	private final String[] lesTitres = {"Id", "Nom", "Membre", "Image"};
	
	
	public GestionArtistes(){
		
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
		switch(columnIndex){
		case 0:
			return listeArtiste.get(rowIndex).getId();
		case 1:
			return listeArtiste.get(rowIndex).getNom();
		case 2:
			return listeArtiste.get(rowIndex).getMembre();
		case 3:
			return listeArtiste.get(rowIndex).getImage();
		
		default:
			return null;
		}
	}	
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
	
		  switch (columnIndex) {
	        case 0: return int.class;
	        case 1: return String.class;
	        case 2: return Boolean.class;
	        case 3: return String.class;
	        default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
		  }
	}
	
	public 	ArrayList<Artiste> afficherArtiste(){
		listeArtiste = 	new ArrayList<Artiste>();
		
		
		try {
		String requete = "Select * from Artiste";
		conn = new ControleConnexion();
		
	       Statement statement = conn.connexion().createStatement();
	       ResultSet jeuResultats = statement.executeQuery(requete);
	       
	       while (jeuResultats.next()) {
	    	   Artiste artiste = new Artiste(jeuResultats.getInt( "artiste_id"), jeuResultats.getString( "nom" ), jeuResultats.getBoolean( "membre" ),jeuResultats.getString( "image" ));
	    	   listeArtiste.add( artiste );
	       }
		
		} catch (Exception e) {
			
		}
		return listeArtiste;
	}
	
	public ArrayList<Album> afficherAlbum(){
		listeAlbum = new ArrayList<Album>();
		return null;
		
	}
}

	