package livrable1.controleur;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import livrable1.modele.Artiste;
import livrable1.modele.GestionArtistes;
import livrable1.vue.VueArtiste;

public class ControleurArtiste implements ActionListener, MouseListener, ListSelectionListener {
	
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
			gArtiste.afficherImageAlbum();
		} else if ( e.getClickCount() ==  2) {
			gArtiste.activerModification();
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
			gArtiste.rechercher();
		} else if ( e.getSource() == vArtiste.getBtnQuitter() ) {
			vArtiste.getFrame().dispose();
			
		} else if ( e.getSource() == vArtiste.getBtnNouveau() ) {
			gArtiste.nouvelArtiste();
			
		} else if ( e.getSource() == vArtiste.getBtnAjouter( ) ) {
			if ( gArtiste.ajouterArtisteBD(artiste) ) {
				gArtiste.ajouterArtiste(artiste);
			}
			
		} else if ( e.getSource() == vArtiste.getBtnModifier() ) {
			gArtiste.modifierArtiste(vArtiste.getTable().getSelectedRow() , artiste);
			
		} else if ( e.getSource() == vArtiste.getBtnSupprimer() ) {
			if ( gArtiste.supprimerArtisteBD(artiste) ) {
				gArtiste.supprimerArtiste(vArtiste.getTable().getSelectedRow() );
			}
			
		} else if ( e.getSource() == vArtiste.getBtnRemplacer() ) {
			
		} else if ( e.getSource() == vArtiste.getBtnAide() ) {
			try {
				File fileFichier = new File("c:definitions.chm");
				Desktop.getDesktop().open(fileFichier);
			} catch (IOException msg) {
				System.out.println(msg.getMessage());
			}
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if ( !e.getValueIsAdjusting() ) {
			int numLigne;
			
			numLigne = vArtiste.getTable().getSelectedRow();
			
			Artiste artiste = gArtiste.getElement(numLigne);
			vArtiste.textNumero.setText( artiste.getNum() );
			vArtiste.textNom.setText(artiste.getNom());
			vArtiste.lblNewLabel_1.setText(artiste.getPhoto());
			
			if (artiste.getMembre() ) {
				vArtiste.checkBoxMembre.setSelected(true);
			} else {
				vArtiste.checkBoxMembre.setSelected(false);
			}
			
		}
		
	}

}
