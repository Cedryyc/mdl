package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;

public class JIFVisiteListe extends JIFVisite implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Visite> lesVisites;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTmatriculeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFVisiteListe() {
		
		super();
		// récupération des données Medecin dans la collection
		lesVisites = VisiteDao.retournerCollectionDesVisites();

		int nbLignes = lesVisites.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][3];
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getUnMedecin().getCodeMed();
			data[i][2] = uneVisite.getUnVisiteur().getUneLocalite().getVille();
			i++;
			}
		String[] columnNames = {"Référence", "Code Médecin","Lieu"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTmatriculeVisiteur = new JTextField(20);
		JTmatriculeVisiteur.setMaximumSize(JTmatriculeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Visite détaillée");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTmatriculeVisiteur);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medecin unMedecin = MedecinDao.rechercher(JTcodeMedecin.getText());
   			if (unMedecin!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedecinFiche(unMedecin));
   			}
   		}	
	}
}