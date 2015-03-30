package metier;

import java.util.Date;

public class CompteEpargne extends Compte {
	private double taux;
	public CompteEpargne() {
	super();
	}
	public CompteEpargne(String numCompte, Date
	dateCreation,double solde,double taux) {
	super(numCompte, dateCreation, solde);
	this.taux=taux;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
