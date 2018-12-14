package gsb.tests;

import java.sql.Date;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;

public class VisiteServiceTest {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ArrayList<Visite> lesVisites = VisiteDao.retournerCollectionDesVisites();
			
			if (lesVisites.size()>0){
			System.out.println(lesVisites.get(0).getUnMedecin().getCodeMed());
			}
	}
}
