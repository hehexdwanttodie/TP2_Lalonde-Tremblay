package livrable1.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import livrable1.modele.ModeleTraitement;
import livrable1.vue.VueIdentification;
import livrable1.vue.VueTraitements;

public class ControleurIdentification implements ActionListener {
	private VueIdentification vue;
	private JButton valider, quitter;
	private JTextField username;
	private JPasswordField password;

	ModeleTraitement modele;

	public ControleurIdentification( VueIdentification vue ) {
		this.vue = vue;
		valider = vue.getValider();
		quitter = vue.getQuitter();
		username = vue.getUsername();
		password = vue.getPassword();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed( ActionEvent traitement ) {

		if ( traitement.getSource() == valider ) {
			if ( username.getText().equals( "123" ) && password.getText().equals( "123" ) ) {
				VueTraitements vueTraitements = new VueTraitements();
				vueTraitements.getFrame().setVisible( true );
				vue.dispose();
			}

			else {
				JOptionPane.showMessageDialog( null, "Nom d'utilisateur: 123\nMot de Passe: 123",
						"Mot de passe incorrect", JOptionPane.ERROR_MESSAGE );
			}
		}

		if ( traitement.getSource() == quitter ) {

			vue.dispose();
		}

	}
}
