package livrable1.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import livrable1.modele.GestionArtistes;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;

public class vueArtiste {

	private JFrame frame;
	private JTextField textRecherche;
	private JTable tableArtistes;
	private JTextField textNumero;
	private JTextField textNom;
	private GestionArtistes artiste;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueArtiste window = new vueArtiste();
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
	public vueArtiste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(24, 22, 104, 14);
		lblRechercherUnArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblRechercherUnArtiste);
		
		textRecherche = new JTextField();
		textRecherche.setBounds(24, 47, 210, 20);
		frame.getContentPane().add(textRecherche);
		textRecherche.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(252, 46, 89, 23);
		frame.getContentPane().add(btnRecherche);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(451, 46, 89, 23);
		frame.getContentPane().add(btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArtistes.setBounds(33, 114, 65, 33);
		frame.getContentPane().add(lblArtistes);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(24, 254, 89, 23);
		frame.getContentPane().add(btnRemplacer);
		
		artiste = new GestionArtistes();
		
		
		GestionArtistes test = new GestionArtistes();
		tableArtistes = new JTable(test);
		tableArtistes.setBounds(140, 125, 286, 152);
		frame.getContentPane().add(tableArtistes);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(451, 121, 89, 23);
		frame.getContentPane().add(btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(451, 155, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(451, 189, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(451, 223, 89, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JLabel lblInformation = new JLabel("Informations");
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInformation.setBounds(24, 301, 130, 46);
		frame.getContentPane().add(lblInformation);
		
		JLabel lblNewLabel = new JLabel("Num\u00E9ro");
		lblNewLabel.setBounds(24, 359, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(24, 389, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setBounds(24, 419, 46, 14);
		frame.getContentPane().add(lblMembre);
		
		textNumero = new JTextField();
		textNumero.setBounds(68, 356, 144, 20);
		frame.getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		textNom = new JTextField();
		textNom.setBounds(68, 386, 144, 20);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JList listAlbum = new JList();
		listAlbum.setBounds(252, 356, 144, 99);
		frame.getContentPane().add(listAlbum);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(24, 158, 89, 85);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(429, 357, 107, 98);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
