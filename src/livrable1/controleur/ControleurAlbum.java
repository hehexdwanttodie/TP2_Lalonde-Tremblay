package livrable1.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import livrable1.modele.Artiste;
import livrable1.vue.VueAlbum;
import livrable1.vue.VueArtiste;

public class ControleurAlbum implements ActionListener, MouseListener {
	
	VueArtiste vArtiste;
	VueAlbum vAlbum;
	Artiste artiste;
	
	public ControleurAlbum(VueAlbum album) {
		this.vAlbum = album;
		album = new VueAlbum();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
