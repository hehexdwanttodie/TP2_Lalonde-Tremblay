package livrable1.modele;

public class Artiste {

	

		String nom;
		boolean membre;
		int id_artiste;
		String image;
		
	
	
	public Artiste(String nom, boolean membre,int id_artiste, String image) {
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
	
	public int getNumero() {
		return id_artiste;
	}
	
	public String getNom() {
		return nom;
	}
	public boolean getMembre() {
		return membre;
	}
	public String getImage() {
		return image;
	}
}
