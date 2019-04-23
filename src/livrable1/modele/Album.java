package livrable1.modele;

public class Album {

		String nom;
		boolean membre;
		int id_album;
		String image;
		
	
	
	public Album(String nom, boolean membre,int numero, String image) {
		this.nom = nom;
		this.membre = membre;
		this.numero = numero;
		this.image = image;
	}
	public Album(int numero) {
		this.numero = numero;
		this.nom = "";
		this.membre = false;
		this.image = "parDefault.png";
	}
	
	public int getNumero() {
		return numero;
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
