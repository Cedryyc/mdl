/*
 * Cr�� le 22 mars 2012
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;


import gsb.modele.Stocker;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFStocker extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	
	protected JLabel JLmatricule;
	protected JLabel JLdepot;
	protected JLabel JLqte;
    
	
	protected JTextField JTmatricule;
	protected JTextField JTdepot;
	protected JTextField JTqte;
	

   
	
    public JIFStocker() {
    	p = new JPanel();  // panneau principal de la fen�tre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(3,2));
        
         JLmatricule = new JLabel("Code visiteur");
    	 JLdepot = new JLabel("D�pot l�gal");
         JLqte = new JLabel("Quantit�");
         
         
         
         JTdepot = new JTextField(20);
         JTdepot.setMaximumSize(JTdepot.getPreferredSize());
         JTmatricule = new JTextField();
         JTqte = new JTextField();
        
         		
         
         pTexte.add(JLdepot);
         pTexte.add(JTdepot);
         pTexte.add(JLqte);
         pTexte.add(JTqte);
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);

       
		
        // mise en forme de la fen�tre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Stocker unStock) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
        JTdepot.setText(unStock.getUnMedicament().getDepotLegal());        
        JTmatricule.setText(unStock.getUnVisiteur().getMatricule());
        JTqte.setText(String.valueOf(unStock.getQteStock()));
       
 
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
        JTdepot.setText("");        
        JTmatricule.setText("");
        JTqte.setText("");
              
     }


    
}
