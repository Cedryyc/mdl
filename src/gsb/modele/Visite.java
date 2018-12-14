package gsb.modele;

import java.sql.Date;

public class Visite {

	protected String reference;
	protected Date date;
	protected String commentaire;
	protected Medecin unMedecin;
	protected Visiteur unVisiteur;
	protected int codeVisite;

	public Visite(String uneReference, Date uneDate, String unCommentaire, Medecin unMedecin, Visiteur unVisiteur,
			int unCodeVisite) {

		super();

		this.reference = uneReference;

		this.date = uneDate;

		this.commentaire = unCommentaire;

		this.unMedecin = unMedecin;

		this.unVisiteur = unVisiteur;

		this.codeVisite = unCodeVisite;

	}

	public String getReference() {

		return reference;

	}

	public void setReference(String reference) {

		this.reference = reference;

	}

	public Date getDate() {

		return date;

	}

	public void setDate(Date date) {

		this.date = date;

	}

	public String getCommentaire() {

		return commentaire;

	}

	public void setCommentaire(String commentaire) {

		this.commentaire = commentaire;

	}

	public Medecin getUnMedecin() {

		return unMedecin;

	}

	public void setUnMedecin(Medecin unMedecin) {

		this.unMedecin = unMedecin;

	}

	public Visiteur getUnVisiteur() {

		return unVisiteur;

	}

	public void setUnVisiteur(Visiteur unVisiteur) {

		this.unVisiteur = unVisiteur;

	}

	public int getCodeVisite() {

		return codeVisite;

	}

	public void setCodeVisite(int codeVisite) {

		this.codeVisite = codeVisite;

	}

}