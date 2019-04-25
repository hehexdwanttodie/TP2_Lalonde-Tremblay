package livrable1.modele;

public class Album {

		String titre;
		String genre;
		int id_album;
		String image;
		int annee;
		int id_artiste;
	
	public Album(int id_album, String titre, String genre, String image, int annee, int id_artiste) {
		
		this.titre = titre;
		this.genre = genre;
		this.id_album = id_album;
		this.annee = annee;
		this.image = image;
		this.id_artiste = id_artiste;
	}
	
	public Album(int id_album) {
		this.id_album = id_album;
		this.titre = "";
		this.genre = "";
		this.annee = 0;
		this.image = "parDefault.png";
	}
	
	public int getId() {
		return id_album;
	}
	
	public String getTitre() {
		return titre;
	}
	public String getGenre() {
		return genre;
	}
	
	public int getAnnee() {
		return annee;
	}
	public String getImage() {
		return image;
	}
}