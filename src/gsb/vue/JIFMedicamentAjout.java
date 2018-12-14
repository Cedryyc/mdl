package gsb.vue;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

import gsb.tests.StockerCreerTest;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JIFMedicamentAjout extends JIFStocker implements ActionListener {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	protected JPanel p;

	private static final long serialVersionUID = 1L;
	private JButton ajouter;
	protected MenuPrincipal fenetreContainer;
	protected JLabel JLreussi;

	public JIFMedicamentAjout(MenuPrincipal uneFenetreContainer) {

		super();

		ajouter = new JButton("Ajouter");
		ajouter.addActionListener(this);
		pBoutons.add(ajouter);

		// déclaration des sources d'évènements
	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout d'un échantillon");

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

			String depot = JTdepot.getText();
			String matricule = JTmatricule.getText();
			String qte = JTqte.getText();
			int quantite = Integer.parseInt(qte);
			
			Visiteur unVisiteur = VisiteurDao.rechercher(matricule);
			Medicament unMedicament = MedicamentDao.rechercher(depot);
			Stocker unStock;
			if(unVisiteur!=null && unMedicament!=null){
			unStock = new Stocker(quantite,unVisiteur,unMedicament);
			StockerDao.creer(unStock);
			}
			else if (unMedicament==null){
				JOptionPane jop1;
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "Ce dépot n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);

			}
			else if(unVisiteur==null){
				JOptionPane jop2;
				jop2 = new JOptionPane();
				jop2.showMessageDialog(null, "Ce matricule n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);
			
			}
			}
		}
	}

