package livrable1.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VueAlbum extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frameAlbum;
	private JTextField textNumero;
	private JTextField textTitre;
	private JTextField textGenre;
	private JTextField textAnnee;
	private JTextField textNumArtiste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAlbum frame = new VueAlbum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueAlbum() {
		
		frameAlbum = new JFrame();
		frameAlbum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlbum.setBounds(100, 100, 450, 300);
		frameAlbum.getContentPane().setLayout(null);
		
		
		JLabel labelAlbum = new JLabel("New label");
		labelAlbum.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAlbum.setBounds(165, 28, 190, 27);
		frameAlbum.getContentPane().add(labelAlbum);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 59, 136, 125);
		frameAlbum.getContentPane().add(lblNewLabel);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro ");
		lblNumro.setBounds(171, 89, 46, 14);
		frameAlbum.getContentPane().add(lblNumro);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setBounds(171, 114, 46, 14);
		frameAlbum.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Genre");
		lblNewLabel_2.setBounds(171, 138, 46, 14);
		frameAlbum.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAnneDeSortie = new JLabel("Ann\u00E9e de sortie");
		lblAnneDeSortie.setBounds(171, 163, 89, 14);
		frameAlbum.getContentPane().add(lblAnneDeSortie);
		
		JLabel lblNumroDeLartiste = new JLabel("Num\u00E9ro de l'artiste");
		lblNumroDeLartiste.setBounds(171, 190, 95, 14);
		frameAlbum.getContentPane().add(lblNumroDeLartiste);
		
		textNumero = new JTextField();
		textNumero.setBounds(269, 86, 155, 20);
		frameAlbum.getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		textTitre = new JTextField();
		textTitre.setBounds(269, 111, 155, 20);
		frameAlbum.getContentPane().add(textTitre);
		textTitre.setColumns(10);
		
		textGenre = new JTextField();
		textGenre.setBounds(269, 135, 155, 20);
		frameAlbum.getContentPane().add(textGenre);
		textGenre.setColumns(10);
		
		textAnnee = new JTextField();
		textAnnee.setBounds(270, 160, 154, 20);
		frameAlbum.getContentPane().add(textAnnee);
		textAnnee.setColumns(10);
		
		textNumArtiste = new JTextField();
		textNumArtiste.setBounds(269, 187, 155, 20);
		frameAlbum.getContentPane().add(textNumArtiste);
		textNumArtiste.setColumns(10);
	}
	
	public JFrame getFrame() {
		return frameAlbum;
	}

}
