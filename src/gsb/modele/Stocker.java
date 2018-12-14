/**
 * 
 */
package gsb.modele;

/**
 * @author LOHIER
 *
 */
public class Stocker {

	protected int qteStock;
	protected Visiteur unVisiteur;
	protected Medicament unMedicament;

	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		super();
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}

	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * @param qteStock
	 *            the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	/**
	 * @return the unVisiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	/**
	 * @param unVisiteur
	 *            the unVisiteur to set
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	/**
	 * @return the unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 * @param unMedicament
	 *            the unMedicament to set
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

}