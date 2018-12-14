/**
 * 
 */
package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

/**
 * @author LOHIER
 *
 */
public class MedicamentDaoTestCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medicament unMedicament = MedicamentService.rechercherMedicament("ADIMOL9");
		ArrayList<Medicament> lesMedicaments = new ArrayList<Medicament>();
		
		lesMedicaments.add(unMedicament);
		if (lesMedicaments.contains(unMedicament)){
			System.out.println(lesMedicaments.get(0).getNomCommercial());
			System.out.println(lesMedicaments.get(0).getComposition());
			System.out.println(lesMedicaments.get(0).getEffets());
			System.out.println(lesMedicaments.get(0).getContreIndication());
			System.out.println(lesMedicaments.get(0).getPrixEchantillon());
			System.out.println(lesMedicaments.get(0).getCodeFamille());
			System.out.println(lesMedicaments.get(0).getLibelleFamille());
		}
			
	}

}
