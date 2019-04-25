package livrable1.modele;

public class Artiste {
	
		String nom;
		boolean membre;
		int id_artiste;
		String photo;
		
	public Artiste() {
		
	}
	
	public Artiste(int id_artiste, String nom, boolean membre, String photo) {
		
		this.nom = nom;
		this.membre = membre;
		this.id_artiste = id_artiste;
		this.photo = photo;
		
	}
	public Artiste(int id_artiste) {
		
		this.id_artiste = id_artiste;
		this.nom = "";
		this.membre = false;
		this.photo = "parDefault.png";
		
	}
	
	public String getNum() {
		int id = this.id_artiste;
		
		String num = Integer.toString(id);
		
		return num;
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
	public String getPhoto() {
		return this.photo;
	}
}