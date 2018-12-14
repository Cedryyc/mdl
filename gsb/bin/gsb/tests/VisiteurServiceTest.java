package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteurServiceTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Visiteur unVisiteur = VisiteurDao.rechercherVisiteur("a131");
		
		System.out.println(unVisiteur.getNom());
	}
}
