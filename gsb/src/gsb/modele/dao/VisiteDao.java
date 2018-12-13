package gsb.modele.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;

public class VisiteDao {
	
	public static int creer(Visite uneVisite, Visiteur unVisiteur, Medecin unMedecin){
		int result = 0;
		String requeteInsertion;
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		String matriculeVisiteur =  unVisiteur.getMatricule();
		String codeMedecin = unMedecin.getCodeMed();
		requeteInsertion = "insert into VISITE values('"+reference+"','"+date+"','"+commentaire+"','"+matriculeVisiteur+"','"+codeMedecin+"')";
		System.out.println(requeteInsertion);
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e) {
			System.out.println("Echec ajout d'une visite");
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
	}
	
	public static Visite rechercher(String matricule) {
		Visite uneVisite = null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
		.execReqSelection("select * from VISITE where VISITE.MATRICULE ='" + matricule + "'");
		try {
		if (reqSelection.next()) {
		uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2),
		reqSelection.getString(3), unVisiteur, unMedecin);
		}
		;
		} catch (Exception e) {
		System.out.println(
		"erreur reqSelection.next() pour la requête - select * from VISITE where VISITE.MATRICULE ='"
		+ matricule + "'");
		e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
		}
	
	public static ArrayList<Visite> retournerCollectionDesVisites(){
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE");
		try{
		while (reqSelection.next()) {
			String codeVisite = reqSelection.getString(1);
		    collectionDesVisites.add(VisiteDao.rechercher(codeVisite));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}

	}
