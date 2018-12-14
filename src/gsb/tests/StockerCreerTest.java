package gsb.tests;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.ValidationUtils;

public class StockerCreerTest {
	public static void creerTest(Stocker unStock)
	{
		boolean test = false;
		//ArrayList<Medicament> lesMedicaments = MedicamentDao.toutLesMedicaments();
				Medicament unMed = MedicamentDao.rechercher(unStock.getUnMedicament().getDepotLegal());
				if(unMed!=null){
					test = true;
				}

		if (test==false){
			JOptionPane jop1;
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Ce dépot n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);

		}
		boolean test2 = false;
		//ArrayList<Visiteur> lesVisiteurs = VisiteurDao.toutLesVisiteurs();

		if(VisiteurDao.rechercher(unStock.getUnVisiteur().getMatricule())!=null){
			test2 = true;
		}
	
		if (test2==false){
			JOptionPane jop2;
			jop2 = new JOptionPane();
			jop2.showMessageDialog(null, "Ce matricule n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		if(ValidationUtils.estUnEntier(String.valueOf(unStock.getQteStock()))==false){
			JOptionPane jop3;
			jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "La quantité n'est pas au bon format", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			if (test==true && test2==true){
				StockerDao.creer(unStock);
			}
		}
	}
}
