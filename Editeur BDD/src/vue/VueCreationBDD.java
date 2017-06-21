package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controleur.PresserBoutonListener;

public class VueCreationBDD extends JPanel{

	private JLabel lTitre;
	private JLabel lErreur;
	private JLabel lNomBDD;
	private JTextField fNomBDD;
	private JLabel lCodeURL;
	private JRadioButton boutonLocal;
	private JRadioButton boutonServeur;
	private JTextField fURL;
	private JLabel lNomUtilisateur;
	private JTextField fNomUtilisateur;
	private JLabel lMotDePasse;
	private JPasswordField fMotDePasse;
	private JButton valider;
	private JPanel panneauBoutons;
	private JPanel panneauPrincipal;
	private Fenetre fenetre;
	private JTextField port;
	private JLabel lPort;
	private JFrame fenetreNouvelleBDD;
	
	public VueCreationBDD(Fenetre fenetre) {
		this.fenetre = fenetre;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				creer();
			}
		});
	}
	
	public void decoration(){
		lTitre = new JLabel("CREATION D'UNE BDD");
		lTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lErreur = new JLabel("");
		lErreur.setForeground(new Color(255,0,0));
		lErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lNomBDD = new JLabel("Nom de la BDD");
		fNomBDD = new JTextField();
		lCodeURL = new JLabel("URL du serveur distant");
		boutonLocal = new JRadioButton("Hebergement Local");
		boutonLocal.setName("creer bdd hebergement local");
		boutonLocal.addActionListener(new PresserBoutonListener(this.fenetre));
		boutonServeur = new JRadioButton("Hebergement Distant");
		boutonServeur.setName("creer bdd hebergement distant");
		boutonServeur.addActionListener(new PresserBoutonListener(this.fenetre));
		fURL = new JTextField();
		lNomUtilisateur = new JLabel("Nom de l'utilisateur");
		fNomUtilisateur = new JTextField();
		lMotDePasse = new JLabel("Mot de passe");
		fMotDePasse = new JPasswordField();
		valider = new JButton("Valider");
		valider.setName("valider creation bdd");
		valider.addActionListener(new PresserBoutonListener(this.fenetre));
		panneauBoutons = new JPanel();
		panneauPrincipal = new JPanel();
		this.port = new JTextField();
		this.lPort = new JLabel("Port du serveur distant");
	}

	public void creer(){
		this.fenetre.setVueCreationBDD(this);
		decoration();
		panneauPrincipal.setLayout(new GridLayout(0,1));
		panneauBoutons.setLayout(new GridLayout(1,2));
		this.setLayout(new BorderLayout());
		panneauPrincipal.add(lTitre);
		panneauPrincipal.add(lNomBDD);
		panneauPrincipal.add(fNomBDD);
		panneauBoutons.add(boutonLocal);
		panneauBoutons.add(boutonServeur);
		panneauPrincipal.add(panneauBoutons);
		panneauPrincipal.add(lCodeURL);
		panneauPrincipal.add(fURL);
		panneauPrincipal.add(lNomUtilisateur);
		panneauPrincipal.add(fNomUtilisateur);
		panneauPrincipal.add(lMotDePasse);
		panneauPrincipal.add(fMotDePasse);
		panneauPrincipal.add(this.lPort);
		panneauPrincipal.add(this.port);
		panneauPrincipal.add(valider);
		this.add(new JLabel("      "),BorderLayout.SOUTH);
		this.add(new JLabel("      "),BorderLayout.WEST);
		this.add(new JLabel("      "),BorderLayout.EAST);
		this.add(panneauPrincipal,BorderLayout.CENTER);
		fenetreNouvelleBDD = new JFrame("Créer une nouvelle base de données");
		fenetreNouvelleBDD.setContentPane(this);
		fenetreNouvelleBDD.setSize(new Dimension(400, 500));
		fenetreNouvelleBDD.setResizable(false);
		fenetreNouvelleBDD.setLocationRelativeTo(null);
		fenetreNouvelleBDD.setVisible(true);
	}
	
	/**
	 * @return the lErreur
	 */
	public JLabel getlErreur() {
		return lErreur;
	}

	/**
	 * @return the fNomBDD
	 */
	public JTextField getfNomBDD() {
		return fNomBDD;
	}

	/**
	 * @return the boutonLocal
	 */
	public JRadioButton getBoutonLocal() {
		return boutonLocal;
	}

	/**
	 * @return the boutonServeur
	 */
	public JRadioButton getBoutonServeur() {
		return boutonServeur;
	}

	/**
	 * @return the fURL
	 */
	public JTextField getfURL() {
		return fURL;
	}

	/**
	 * @return the fNomUtilisateur
	 */
	public JTextField getfNomUtilisateur() {
		return fNomUtilisateur;
	}

	/**
	 * @return the fMotDePasse
	 */
	public JPasswordField getfMotDePasse() {
		return fMotDePasse;
	}
	
	public JTextField getfPort(){
		return this.port;
	}
	
	public JFrame getFrame(){
		return this.fenetreNouvelleBDD;
	}
	
}