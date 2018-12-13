package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JIFVisite extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JLabel JLreference;
	protected JLabel JLdate;
	protected JLabel JLcommentaire;
	protected JLabel JLmatriculeVisiteur;
	protected JLabel JLcodeMedecin;
	
	protected JTextField JTreference;
	protected JTextField JTdate;
	protected JTextField JTcommentaire;
	protected JTextField JTmatriculeVisiteur;
	protected JTextField JTcodeMedecin;
	
	public JIFVisite() {
		p = new JPanel();
		pBoutons = new JPanel();
		pTexte = new JPanel(new GridLayout(9, 2));
		
		JLreference = new JLabel("Référence");
		JLdate = new JLabel("Date visite");
		JLcommentaire = new JLabel("Commentaire visite");
		JLmatriculeVisiteur = new JLabel("Matricule du visiteur");
		JLcodeMedecin = new JLabel("Code médecin");
		
		JTreference = new JTextField();
		JTdate = new JTextField();
		JTcommentaire = new JTextField();
		JTmatriculeVisiteur = new JTextField();
		JTcodeMedecin = new JTextField();
		
		pTexte.add(JLreference);
        pTexte.add(JTreference);
        pTexte.add(JLdate);
        pTexte.add(JTdate);
        pTexte.add(JLcommentaire);
        pTexte.add(JTcommentaire);
        pTexte.add(JLmatriculeVisiteur);
        pTexte.add(JTmatriculeVisiteur);
        pTexte.add(JLcodeMedecin);
        pTexte.add(JTcodeMedecin);
        
        p.add(pTexte);
        p.add(pBoutons);
        Container contentPane = getContentPane();
        contentPane.add(p);
        
       /* UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,null);
         
        p.add(datePicker);*/
	}
	
	public void remplirText(Visite uneVisite,Visiteur unVisiteur,Medecin unMedecin) {
		JTreference.setText(uneVisite.getReference());
		JTdate.setText(uneVisite.getDate());
        JTcommentaire.setText(uneVisite.getCommentaire());
        JTmatriculeVisiteur.setText(unVisiteur.getMatricule());    
        JTcodeMedecin.setText(unMedecin.getCodeMed());
	}
}
