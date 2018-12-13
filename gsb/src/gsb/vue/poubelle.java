package gsb.vue;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;

public class poubelle extends JIFVisite implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton ajout;
	protected Visite uneVisite;
	protected Visiteur unVisiteur;
	protected Medecin unMedecin;
	
	public poubelle() {
		super();
		ajout = new JButton("Ajouter");
		pBoutons.add(ajout);
		// Déclaration des sources d'événements
		ajout.addActionListener(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout d'une visite");
		
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == ajout) {
			System.out.println("ça marche");
			VisiteDao.creer(uneVisite, unVisiteur, unMedecin);
		}
		
	}
	
}
