package gsb.modele;


public class Offrir {

	protected int qteOfferte;

	protected Medicament unMedicament;

	protected Visite uneVisite;
	

	public Offrir(int qteOfferte, Medicament unMedicament, Visite uneVisite) {
		super();
		this.qteOfferte = qteOfferte;
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
	}

	/**
	 * @return the qteOfferte
	 */
	public int getQteOfferte() {
		return qteOfferte;
	}

	/**
	 * @param qteOfferte the qteOfferte to set
	 */
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}

	/**
	 * @return the unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 * @param unMedicament the unMedicament to set
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	/**
	 * @return the uneVisite
	 */
	public Visite getUneVisite() {
		return uneVisite;
	}

	/**
	 * @param uneVisite the uneVisite to set
	 */
	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}

}
