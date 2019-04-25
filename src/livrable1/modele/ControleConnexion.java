package livrable1.modele;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ControleConnexion {
	Connection conn = null;
	
	public ControleConnexion() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Pilote Chargé");
			conn = DriverManager.getConnection("jdbc:sqlite:SQLite/BD.db");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erreur: Driver manquant");
			System.out.println( cnfe.getMessage());
			
		} catch (SQLException se) {
			System.out.println("Erreur: La base de donn\u00E9es manquante.");
		}
	}
	
	public Connection getConnexion() {
		return conn;
	}
	
	Connection deconnexion() {
		
		try {
			if (conn != null ) {
				conn.close();
			}
		} catch (SQLException se) {
			System.out.println("Erreur: impossible de fermer la connexion");
		}
		
		return conn;
		
	}
}
