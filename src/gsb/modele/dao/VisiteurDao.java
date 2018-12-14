package gsb.modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String matricule){
		Visiteur unVisiteur = null;
		Localite uneLocalite =null;
		Date uneDate = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITEUR where MATRICULE ='" + matricule + "'");
		try {
			if (reqSelection.next()) 
			{
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), uneLocalite,  uneDate,reqSelection.getString(9),
						reqSelection.getString(10));
			}
			

			}
		catch (Exception e) 
		{
				System.out.println(
						"erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"
								+ matricule + "'");
				e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static ArrayList<Visiteur> toutLesVisiteurs() {
		ArrayList<Visiteur> ToutLesVisiteurs = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection(
				"select MATRICULE from VISITEUR");
		try {
			while (reqSelection.next()) {
				String matricule = reqSelection.getString(1);
				ToutLesVisiteurs.add(VisiteurDao.rechercher(matricule));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerToutLesVisiteurs()");
		}
		return ToutLesVisiteurs;

	}
}
