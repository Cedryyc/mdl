package gsb.vue;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.tests.VisiteAjoutTest;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JIFVisiteAjout extends JIFVisite implements ActionListener {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	protected JPanel p;

	private static final long serialVersionUID = 1L;
	private JButton ajouter;
	protected MenuPrincipal fenetreContainer;
	
	protected Visite uneVisite;

	public JIFVisiteAjout() {

		super();

		ajouter = new JButton("Ajouter");
		ajouter.addActionListener(this);
		pBoutons.add(ajouter);

		// déclaration des sources d'évènements
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout d'une visite");

		// ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				// le code que tu veux exécuter à la fermeture de la JInternalFrame
			}
		});
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == ajouter) {

			String reference = JTreference.getText();
			String commentaire = JTcommentaire.getText();
			String date = JTdate.getText();
			String matriculeVisiteur = JTmatriculeVisiteur.getText();
			String codeMedecin = JTcodeMedecin.getText();

			
			Localite uneLocalite = new Localite("cp", "ville");
			Visiteur unVisiteur = new Visiteur(matriculeVisiteur, "nom", "prenom", "login", "mdp", "adresse", uneLocalite, "", "codeUnite", "nomUnite");
			Medecin unMedecin = new Medecin(codeMedecin, "nom", "prenom", "adresse", uneLocalite, "telephone", "potentiel", "specialite");
			Visite uneVisite = new Visite(reference, date,commentaire, unVisiteur, unMedecin);


			if (uneVisite != null) {
				VisiteAjoutTest.ajouterTest(uneVisite, unVisiteur, unMedecin);
				
			}
		}
	}
}
