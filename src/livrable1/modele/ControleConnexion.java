package livrable1.modele;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ControleConnexion {
	Connection conn = null;
	
	private Connection connexion() {
		String url ="jdbc:sqlite:sqlite/db/BD.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:sqlite/SQLite/BD.db");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erreur: Driver manquant");
			
		} catch (SQLException se) {
			System.out.println("Erreur: La base de donn\u00E9es manquante.");
		}
		
		return conn;
	}
	
	private Connection deconnexion() {
		
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
