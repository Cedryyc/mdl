package gsb.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;
import gsb.utils.ValidationUtils;

public class VisiteService {
	
	public static int creationVisite(Visite uneVisite,Visiteur unVisiteur,Medecin unMedecin){
		int test = VisiteDao.creer(uneVisite,unVisiteur, unMedecin);
		try{
		if (test==0) {
		            throw new Exception("La création à échoué ");
		        }
		else{
			System.out.println("yes");
		}
		}
		catch(Exception e){
		System.out.println( e.getMessage());
		}
		return test;
		}
	
	public static boolean isDateValide(String uneDate) {
    	boolean resultat = false;
    	 try {
    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    		 sdf.setLenient(false);
    		 sdf.parse(uneDate);
    		 resultat = true;
    		 } catch (Exception e) {
    			 resultat = false;
    		 }
    	return resultat;
    }
}
