package livrable1.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import livrable1.modele.Artiste;
import livrable1.modele.GestionArtistes;
import livrable1.vue.VueArtiste;

public class ControleurArtiste implements ActionListener, MouseListener {
	
	VueArtiste vArtiste;
	Artiste artiste;
	GestionArtistes gArtiste;
	
	public ControleurArtiste(VueArtiste vue) {
		this.vArtiste = vue;
		artiste = new Artiste();
	}
	
	public JTable initialiserTableau(JTable table) {
		
		ArrayList<Artiste> liste = gArtiste.obtenirListeArtiste();
		gArtiste = new GestionArtistes(liste);
		table = new JTable(gArtiste);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		return table;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if ( e.getClickCount() == 1) {
			gArtiste.afficherInfoArtiste();
			//vArtiste.afficherAlbums();
		}
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == vArtiste.getBtnRecherche()) {
			//vArtiste.rechercher();
		}
		
	}

}
