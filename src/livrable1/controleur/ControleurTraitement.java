package livrable1.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import livrable1.modele.ModeleTraitement;
import livrable1.vue.VueTraitements;

public class ControleurTraitement implements ActionListener {
	
	VueTraitements vue;
	ModeleTraitement modele;
	
	public ControleurTraitement(VueTraitements vue) {
		this.vue = vue;
		modele = new ModeleTraitement(vue);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
			if ( e.getSource() == vue.getBtnArtiste() ) {
				modele.ouvrirArtiste();
			} else if ( e.getSource() == vue.getBtnAlbum() ) {
				modele.ouvrirAlbum();
				
			} else if ( e.getSource() == vue.getBtnQuitter() ) {
				
			}
		
	}

}
