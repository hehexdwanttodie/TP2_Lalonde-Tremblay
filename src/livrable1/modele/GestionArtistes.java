package livrable1.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionArtistes {

	ControleConnexion conn= new ControleConnexion();
	String requete = "Select * from Artiste";
	ArrayList<Artiste> listeArtiste = new ArrayList<Artiste>();
	public void afficherArtiste(){
		conn.connexion();
		conn.deconnexion();
		
		
	}
}

