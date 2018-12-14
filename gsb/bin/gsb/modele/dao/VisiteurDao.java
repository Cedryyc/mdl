package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercherVisiteur(String matricule){
		Visiteur unVisiteur=null;
		Localite uneLocalite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+matricule+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(7));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4),reqSelection.getString(5),reqSelection.getString(6), uneLocalite, 
						reqSelection.getString(8), reqSelection.getString(9), reqSelection.getString(10));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from VISITEUR where MATRICULE ='"+matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
}
