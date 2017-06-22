package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import controleur.ChampsListener;
import controleur.PresserBoutonListener;
import controleur.TouchePresseListener;
import controleur.ValeurListener;

public class VueRechercheAvance extends JPanel{

	private JLabel lTitre;
	private JButton bValider;
	private JTextField fRecherche;
	private JCheckBox sensibleALaCasse;
	private JCheckBox motComplet;
	private JCheckBox selectionnerLigne;
	private JSpinner ligneMin;
	private JSpinner ligneMax;
	private Fenetre fenetre;
	private JPanel panneauPrincipal;
	private JPanel panneauCasseMotComplet;
	private JPanel panneauSelectionnerLigne;
	private JSpinner.NumberEditor ligneMinEditeur;
	private JSpinner.NumberEditor ligneMaxEditeur;
	private JFrame fenetreRechercheAvance;
	
	public VueRechercheAvance(Fenetre fenetre) {
		this.fenetre = fenetre;
		fenetre.setVueRechercheAvance(this);
		declaration();
		bValider.setName("LancerRechercheAvance");
		bValider.addActionListener(new PresserBoutonListener(fenetre));
		ligneMin.setEnabled(false);
		ligneMax.setEnabled(false);
		selectionnerLigne.setName("selectionnerLigne");
		selectionnerLigne.addActionListener(new PresserBoutonListener(this.fenetre));
		ligneMin.setEditor(ligneMinEditeur);
		ligneMin.addChangeListener(new ValeurListener(fenetre));
		ligneMax.setEditor(ligneMaxEditeur);
		ligneMax.addChangeListener(new ValeurListener(fenetre));
		ligneMinEditeur.getModel().setMinimum(0);
		ligneMaxEditeur.getModel().setMaximum(10);//fenetre.getVuePrincipale().getTable().getRowCount());
		lTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panneauCasseMotComplet.setLayout(new GridLayout(1,2));
		panneauCasseMotComplet.add(sensibleALaCasse);
		panneauCasseMotComplet.add(motComplet);
		panneauSelectionnerLigne.setLayout(new GridLayout(1,3));
		panneauSelectionnerLigne.add(selectionnerLigne);
		panneauSelectionnerLigne.add(ligneMin);
		panneauSelectionnerLigne.add(ligneMax);
		panneauPrincipal.setLayout(new GridLayout(0,1));
		panneauPrincipal.add(lTitre);
		panneauPrincipal.add(fRecherche);
		panneauPrincipal.add(panneauCasseMotComplet);
		panneauPrincipal.add(panneauSelectionnerLigne);
		panneauPrincipal.add(bValider);
		fRecherche.setName("BarreRecherche");
		fRecherche.addFocusListener(new ChampsListener(this.fenetre));
		//fRecherche.addKeyListener(new TouchePresseListener(this.fenetre));
		this.setLayout(new BorderLayout());
		this.add(new JLabel("      "),BorderLayout.SOUTH);
		this.add(new JLabel("      "),BorderLayout.WEST);
		this.add(new JLabel("      "),BorderLayout.EAST);
		this.add(panneauPrincipal,BorderLayout.CENTER);
		fenetreRechercheAvance = new JFrame("Créer une nouvelle base de données");
		fenetreRechercheAvance.setContentPane(this);
		fenetreRechercheAvance.setSize(new Dimension(400, 500));
		fenetreRechercheAvance.setResizable(false);
		fenetreRechercheAvance.setLocationRelativeTo(null);
		fenetreRechercheAvance.setVisible(true);
	}

	private void declaration(){
		lTitre = new JLabel("Recherche Avancée");
		bValider = new JButton("Valider recherche");
		fRecherche = new JTextField("Chercher les occurences");
		sensibleALaCasse = new JCheckBox("Sensible à la casse");
		motComplet = new JCheckBox("Mot complet");
		selectionnerLigne = new JCheckBox("Selectionner des lignes");
		ligneMin = new JSpinner(new SpinnerNumberModel());
		ligneMax = new JSpinner(new SpinnerNumberModel());
		ligneMinEditeur = new JSpinner.NumberEditor(ligneMin);
		ligneMaxEditeur = new JSpinner.NumberEditor(ligneMax);
		panneauPrincipal = new JPanel();
		panneauCasseMotComplet = new JPanel();
		panneauSelectionnerLigne = new JPanel();
	}

	/**
	 * @return the ligneMinEditeur
	 */
	public JSpinner.NumberEditor getLigneMinEditeur() {
		return ligneMinEditeur;
	}

	/**
	 * @return the ligneMaxEditeur
	 */
	public JSpinner.NumberEditor getLigneMaxEditeur() {
		return ligneMaxEditeur;
	}

	/**
	 * @return the ligneMin
	 */
	public JSpinner getLigneMin() {
		return ligneMin;
	}

	/**
	 * @return the ligneMax
	 */
	public JSpinner getLigneMax() {
		return ligneMax;
	}

	/**
	 * @return the sensibleALaCasse
	 */
	public JCheckBox getSensibleALaCasse() {
		return sensibleALaCasse;
	}

	/**
	 * @return the motComplet
	 */
	public JCheckBox getMotComplet() {
		return motComplet;
	}

	/**
	 * @return the selectionnerLigne
	 */
	public JCheckBox getSelectionnerLigne() {
		return selectionnerLigne;
	}

	/**
	 * @return the fRecherche
	 */
	public JTextField getfRecherche() {
		return fRecherche;
	}

	/**
	 * @return the fenetreRechercheAvance
	 */
	public JFrame getFenetreRechercheAvance() {
		return fenetreRechercheAvance;
	}
}
