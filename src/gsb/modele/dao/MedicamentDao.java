/**
 * 
 */
package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;

/**
 * @author LOHIER
 *
 */
public class MedicamentDao {

	public static ArrayList<Medicament> toutLesMedicaments() {
		ArrayList<Medicament> ToutLesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection(
				"select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String depotLegal = reqSelection.getString(1);
				ToutLesMedicaments.add(MedicamentDao.rechercher(depotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerToutLesMedicamentq()");
		}
		return ToutLesMedicaments;

	}

	public static Medicament rechercher(String depotLegal) {
		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + depotLegal + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8));
			}
			;
		} catch (Exception e) {
			System.out.println(
					"erreur reqSelection.next() pour la requête - select * from MEDICAMENT where MED_DEPOTLEGAL ='"
							+ depotLegal + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	public static int creer(Medicament unMedicament) {
		String requeteInsertion;
		String depot = unMedicament.getDepotLegal();
		String nom = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effet = unMedicament.getEffets();
		String contre = unMedicament.getContreIndication();
		String prix = unMedicament.getPrixEchantillon();
		String code = unMedicament.getCodeFamille();
		String libelle = unMedicament.getLibelleFamille();
		requeteInsertion = "insert into MEDICAMENT values('" + depot + "','" + nom + "','" + composition + "','" + effet
				+"','" +contre+"','" + prix + "','" + code + "','" + libelle + "')";
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
