package gsb.modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visite {
	

	protected String reference;
	protected String date;
	protected String commentaire;
	protected Medecin unMedecin;
	protected Visiteur unVisiteur;
	
	public Visite(String uneReference, String uneDate, String unCommentaire,Visiteur unVisiteur ,Medecin unMedecin) {
		super();
		this.reference = uneReference;
		this.date = uneDate;
		this.commentaire = unCommentaire;
		this.unMedecin = unMedecin;
		this.unVisiteur = unVisiteur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws ParseException {
		Date mDate =new SimpleDateFormat("yyyy/MM/dd").parse(date);
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
	
}