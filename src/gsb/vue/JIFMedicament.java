/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	

	protected JLabel JLdepot;
	protected JLabel JLnom;
	protected JLabel JLcomposition;
	protected JLabel JLeffet;
	protected JLabel JLcontre;
    protected JLabel JLprix;
    protected JLabel JLcode;
    protected JLabel JLlibelle;
    
	protected JTextField JTdepot;
	protected JTextField JTnom;
	protected JTextField JTcomposition;
	protected JTextField JTeffet;
	protected JTextField JTcontre;
    protected JTextField JTprix;
    protected JTextField JTcode;
    protected JTextField JTlibelle;
   
	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(8,2));
    	
    	 JLdepot = new JLabel("Depot");
         JLnom = new JLabel("Nom");
         JLcomposition = new JLabel("Composition");
         JLeffet = new JLabel("Effets");
         JLcontre = new JLabel("Contre-indication");
         JLprix = new JLabel("Prix");
         JLcode = new JLabel("Code Famille");
         JLlibelle = new JLabel("Libelle Famille");
         
         
         JTdepot = new JTextField(20);
         JTdepot.setMaximumSize(JTdepot.getPreferredSize());
         JTnom = new JTextField();
         JTcomposition = new JTextField();
         JTeffet = new JTextField(20);
         JTeffet.setMaximumSize(JTeffet.getPreferredSize());
         JTcontre = new JTextField(20);
         JTcontre.setMaximumSize(JTcontre.getPreferredSize());
         JTprix = new JTextField();
         JTcode = new JTextField();
         JTlibelle = new JTextField();
         		
         
         pTexte.add(JLdepot);
         pTexte.add(JTdepot);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLcomposition);
         pTexte.add(JTcomposition);
         pTexte.add(JLeffet);
         pTexte.add(JTeffet);
         pTexte.add(JLcontre);
         pTexte.add(JTcontre);
         pTexte.add(JLprix);
         pTexte.add(JTprix);
         pTexte.add(JLcode);
         pTexte.add(JTcode);
         pTexte.add(JLlibelle);
         pTexte.add(JTlibelle);
       
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medicament unMedicament) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTdepot.setText(unMedicament.getDepotLegal());        
        JTnom.setText(unMedicament.getNomCommercial());
        JTcomposition.setText(unMedicament.getComposition());
        JTeffet.setText(unMedicament.getEffets());    
        JTcontre.setText(unMedicament.getContreIndication());
        JTprix.setText(unMedicament.getPrixEchantillon());
        JTcode.setText(unMedicament.getCodeFamille());
        JTlibelle.setText(unMedicament.getLibelleFamille());
 
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTdepot.setText("");        
        JTnom.setText("");
        JTcomposition.setText("");
        JTeffet.setText("");    
        JTcontre.setText("");
        JTprix.setText("");
        JTcode.setText("");
        JTlibelle.setText("");
       
     }


    
}
