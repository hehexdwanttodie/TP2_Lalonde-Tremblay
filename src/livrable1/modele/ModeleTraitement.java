package livrable1.modele;

import livrable1.vue.VueTraitements;
import livrable1.vue.VueAlbum;
import livrable1.vue.VueArtiste;

public class ModeleTraitement {
	
	VueTraitements vue;
	
	public ModeleTraitement(VueTraitements pVue) {
		this.vue = pVue;
	}
	
	public void ouvrirArtiste() {
		VueArtiste artiste = new VueArtiste();
		vue.getFrame().setVisible(false);
		artiste.getFrame().setVisible(true);
	}
	
	public void ouvrirAlbum() {
		VueAlbum album = new VueAlbum();
		vue.getFrame().setVisible(false);
		album.getFrame().setVisible(true);
	}

}
