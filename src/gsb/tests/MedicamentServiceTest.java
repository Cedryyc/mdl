/**
 * 
 */
package gsb.tests;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

/**
 * @author LOHIER
 *
 */
public class MedicamentServiceTest {
	
	public static void main(String[] args){
		Medicament unMedicament = MedicamentService.rechercherMedicament("3MYC7");
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndication());
		System.out.println(unMedicament.getPrixEchantillon());
		System.out.println(unMedicament.getCodeFamille());
		System.out.println(unMedicament.getLibelleFamille());

	
	}

}
