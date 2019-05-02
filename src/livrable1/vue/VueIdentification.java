package livrable1.vue;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import livrable1.controleur.ControleurIdentification;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class VueIdentification extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton valider, quitter;
	private JTextField username;
	JScrollPane pane;
	private JPasswordField password;
	Frame f = new Frame();
	
	public VueIdentification() {

		setSize( 500, 300 );

		ControleurIdentification traitement;
		getContentPane().setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 512, 323 );
		getContentPane().add( panel );
		panel.setLayout( null );

		valider = new JButton( "Valider" );
		valider.setBounds( 120, 220, 99, 31 );
		panel.add( valider );

		quitter = new JButton( "Quitter" );
		quitter.setBounds( 267, 220, 106, 31 );
		panel.add( quitter );



		JLabel lblconnexion = new JLabel( "Connexion à l'application" );
		lblconnexion.setFont( new Font( "Tahoma", Font.PLAIN, 22 ) );
		lblconnexion.setBounds( 36, 49, 275, 27 );
		panel.add( lblconnexion );


		
		username = new JTextField();
		username.setFont( new Font( "Tahoma", Font.PLAIN, 12 ) );
		username.setBounds( 235, 103, 234, 31 );
		panel.add( username );
		username.setColumns( 10 );
		password = new JPasswordField();
		password.setBounds( 235, 163, 234, 31 );
		panel.add( password );
		
		JLabel lblMotDePasse = new JLabel( "Mot de passe" );
		lblMotDePasse.setFont( new Font( "Tahoma", Font.PLAIN, 15 ) );
		lblMotDePasse.setBounds( 136, 163, 143, 14 );
		panel.add( lblMotDePasse );

		JLabel lblNomUtilisateur = new JLabel( "Nom" );
		lblNomUtilisateur.setFont( new Font( "Tahoma", Font.PLAIN, 15 ) );
		lblNomUtilisateur.setBounds( 136, 110, 143, 14 );
		panel.add( lblNomUtilisateur );

		traitement = new ControleurIdentification( this );
		valider.addActionListener( traitement );
		quitter.addActionListener( traitement );
	}



	// Constructeur de la classe
	public void multiLayout() {

		f.setLayout( new BorderLayout() );

	}

	public JButton getValider() {
		return valider;
	}

	public JButton getQuitter() {
		return quitter;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public JTextField getUsername() {
		return username;
	}

	public static void main( String[] args ) {
		VueIdentification f = new VueIdentification();
		f.multiLayout();
		f.setTitle( "Gestion des Albums" );
		
		f.setResizable( false );
		f.setVisible( true );
	}
}