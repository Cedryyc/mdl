package gsb.tests;

import java.sql.ResultSet;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.JOptionPane;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;

public class VisiteAjoutTest {
	public static void ajouterTest(Visite uneVisite,Visiteur unVisiteur,Medecin unMedecin) {
		boolean refExist = true;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select REFERENCE from VISITE where REFERENCE ='" + uneVisite.getReference() +"'");
				try{
				if(reqSelection.next()){
					refExist = false;
				}
				}catch (Exception e){
					System.out.println("Erreur avec la quantité");
					e.printStackTrace();
					}

		if(uneVisite.getReference().length() !=5) {
			JOptionPane jop1;
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Le nombre de caractère doit être de 5","Information",JOptionPane.INFORMATION_MESSAGE);
		}else if(refExist == false) {
			JOptionPane jop1;
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "La référence existe déjà","Information",JOptionPane.INFORMATION_MESSAGE);
		}else if(VisiteService.isDateValide(uneVisite.getDate()) == false){
			JOptionPane jop1;
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "La date doit être au format année/mois/jour","Information",JOptionPane.INFORMATION_MESSAGE);
		}else {
			VisiteDao.creer(uneVisite, unVisiteur, unMedecin);
		}
				}
	}
