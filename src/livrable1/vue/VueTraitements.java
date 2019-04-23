package livrable1.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import livrable1.controleur.ControleurTraitement;

import javax.swing.JButton;

public class VueTraitements {

	private JFrame frame;
	private ControleurTraitement traitements;
	
	private JButton btnArtiste;
	private JButton btnAlbum;
	private JButton btnQuitter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueTraitements window = new VueTraitements();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueTraitements() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Bienvenue !");
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenue.setBounds(198, 28, 194, 56);
		frame.getContentPane().add(lblBienvenue);
		
		JLabel lblVeuillezChoisirUn = new JLabel("Veuillez choisir un traitement");
		lblVeuillezChoisirUn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezChoisirUn.setBounds(182, 105, 236, 20);
		frame.getContentPane().add(lblVeuillezChoisirUn);
		
		traitements = new ControleurTraitement(this); 
		
		btnArtiste = new JButton("Gestion des artistes");
		btnArtiste.setBounds(215, 153, 169, 38);
		frame.getContentPane().add(btnArtiste);
		btnArtiste.addActionListener(traitements);
		
		btnAlbum = new JButton("Gestion des albums");
		btnAlbum.setBounds(215, 220, 169, 38);
		frame.getContentPane().add(btnAlbum);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(476, 298, 89, 23);
		frame.getContentPane().add(btnQuitter);
		btnAlbum.addActionListener(traitements);
	}
	
	public JButton getBtnArtiste() {
		return btnArtiste;
	}
	
	public JButton getBtnAlbum() {
		return btnAlbum;
	}
	
	public JButton getBtnQuitter() {
		return btnQuitter;
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
