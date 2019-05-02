package livrable1.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import livrable1.controleur.ControleurArtiste;
import livrable1.modele.Album;
import livrable1.modele.Artiste;
import livrable1.modele.GestionArtistes;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class VueArtiste {

	private JFrame frame;
	
	private ControleurArtiste traitements;
	
	public JTextField textRecherche;
	private JTable tableArtistes;
	public JTextField textNumero;
	public JTextField textNom;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JList<Album> listAlbum;
	public JCheckBox checkBoxMembre;
	
	private JButton btnRechercher;
	private JButton btnQuitter;
	private JButton btnNouveau;
	private JButton btnRemplacer;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAjouter;
	private JButton btnAideEnLigne;
	private JButton aide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueArtiste window = new VueArtiste();
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
	public VueArtiste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestion des artistes");
		frame.setBounds(100, 100, 584, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		traitements = new ControleurArtiste(this);

		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(24, 22, 188, 14);
		lblRechercherUnArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblRechercherUnArtiste);
		
		textRecherche = new JTextField();
		textRecherche.setBounds(10, 47, 210, 20);
		frame.getContentPane().add(textRecherche);
		textRecherche.setColumns(10);
		
		btnRechercher = new JButton("Recherche");
		btnRechercher.setBounds(230, 46, 111, 23);
		frame.getContentPane().add(btnRechercher);
		btnRechercher.addActionListener(traitements);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(451, 46, 89, 23);
		frame.getContentPane().add(btnQuitter);
		btnQuitter.addActionListener(traitements);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArtistes.setBounds(33, 114, 65, 33);
		frame.getContentPane().add(lblArtistes);
		
		btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(10, 254, 103, 23);
		frame.getContentPane().add(btnRemplacer);
		btnRemplacer.addActionListener(traitements);
		
		GestionArtistes modeleTable = new GestionArtistes();
		
		btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(429, 121, 111, 23);
		frame.getContentPane().add(btnNouveau);
		btnNouveau.addActionListener(traitements);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(429, 155, 111, 23);
		frame.getContentPane().add(btnAjouter);
		btnAjouter.addActionListener(traitements);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(429, 189, 111, 23);
		frame.getContentPane().add(btnModifier);
		btnModifier.addActionListener(traitements);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(429, 223, 111, 23);
		frame.getContentPane().add(btnSupprimer);
		btnSupprimer.addActionListener(traitements);
		
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
		lblMembre.setBounds(24, 419, 58, 14);
		frame.getContentPane().add(lblMembre);
		
		textNumero = new JTextField();
		textNumero.setEnabled(false);
		textNumero.setBounds(79, 358, 144, 20);
		frame.getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		textNom = new JTextField();
		textNom.setEnabled(false);
		textNom.setBounds(80, 386, 144, 20);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		checkBoxMembre = new JCheckBox("");
		checkBoxMembre.setBounds(100, 415, 20, 20);
		frame.getContentPane().add(checkBoxMembre);
		
		listAlbum = new JList<Album>();
		listAlbum.setBounds(249, 346, 160, 99);
		frame.getContentPane().add(listAlbum);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(24, 158, 89, 85);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(420, 351, 120, 91);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 125, 281, 165);
		frame.getContentPane().add(scrollPane);
		
		tableArtistes = new JTable();
		
		tableArtistes.getSelectionModel().addListSelectionListener( traitements);
		
		tableArtistes.setModel(modeleTable);
		frame.getContentPane().add(tableArtistes);
		tableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnAideEnLigne = new JButton("Aide");
		btnAideEnLigne.setBounds(351, 46, 89, 23);
		frame.getContentPane().add(btnAideEnLigne);
		btnAideEnLigne.addActionListener(traitements);
		
		

	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtnRecherche() {
		return btnRechercher;
	}
	
	public JTable getTable() {
		return this.tableArtistes;
	}
	
	public JButton getBtnNouveau() {
		return this.btnNouveau;
	}
	
	public JButton getBtnAjouter() {
		return this.btnAjouter;
	}
	
	public JButton getBtnQuitter() {
		return this.btnQuitter;
	}
	
	public JButton getBtnRemplacer() {
		return this.btnRemplacer;
	}
	
	public JButton getBtnModifier() {
		return this.btnModifier;
	}
	
	public JButton getBtnSupprimer() {
		return this.btnSupprimer;
	}
	
	public JButton getBtnAide() {
		return this.btnAideEnLigne;
	}
}
