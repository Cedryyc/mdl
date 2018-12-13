package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

/**
 * @author LOHIER
 *
 */
public class MedicamentService {

	public static Medicament rechercherMedicament(String unDepotLegal) {
		Medicament unMedicament = null;
		try {
			if (unDepotLegal == null) {
				throw new Exception("Donnée obligatoire : code");
			}
			unMedicament = MedicamentDao.rechercher(unDepotLegal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}

	public static ArrayList<Medicament> collectionDesMedicaments() {
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		collectionDesMedicaments = MedicamentDao.toutLesMedicaments();
		try {
			if (collectionDesMedicaments == null) {
				throw new Exception(" Collection Medicaments invalide ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return collectionDesMedicaments;
	}
}
