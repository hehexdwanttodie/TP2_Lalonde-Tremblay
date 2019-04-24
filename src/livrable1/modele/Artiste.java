package livrable1.modele;

public class Artiste {

	

		String nom;
		boolean membre;
		int id_artiste;
		String image;
		
	
	
	public Artiste(int id_artiste, String nom, boolean membre, String image) {
		this.nom = nom;
		this.membre = membre;
		this.id_artiste = id_artiste;
		this.image = image;
	}
	public Artiste(int id_artiste) {
		this.id_artiste = id_artiste;
		this.nom = "";
		this.membre = false;
		this.image = "parDefault.png";
	}
	
	public int getId() {
		return this.id_artiste;
	}
	
	public String getNom() {
		return this.nom;
	}
	public boolean getMembre() {
		return this.membre;
	}
	public String getImage() {
		return this.image;
	}
}
