package gsb.modele.dao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import gsb.modele.Stocker;

public class StockerDao {
	public static int creer(Stocker unStock){
		String requeteInsertion;
		String depot = unStock.getUnMedicament().getDepotLegal();
		String matricule = unStock.getUnVisiteur().getMatricule();
		int quantite = unStock.getQteStock();
		int result=0;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select QTESTOCK from STOCKER where DEPOTLEGAL ='" + depot + "' AND MATRICULE ='"+ matricule +"'");
		try{
			if(reqSelection.next()){
				int newqte = quantite + reqSelection.getInt(1);
				requeteInsertion = "update STOCKER set QTESTOCK='"+newqte+"'where DEPOTLEGAL ='" + depot + "' AND MATRICULE ='"+ matricule +"'";
				result = ConnexionMySql.execReqMaj(requeteInsertion);
				JOptionPane jop1;
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "Quantité mise à jour", "Information", JOptionPane.INFORMATION_MESSAGE);

			}
			else{
				requeteInsertion = "insert into STOCKER values('" + depot + "','" + matricule + "','" + quantite +"')";
				result = ConnexionMySql.execReqMaj(requeteInsertion);
				JOptionPane jop1;
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "Insertion d'échantillon réussi", "Information", JOptionPane.INFORMATION_MESSAGE);

			}
		}catch (Exception e){
			System.out.println("Erreur avec la quantité");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
