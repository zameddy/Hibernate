package metier;

import java.util.Date;

public class CompteCourant extends Compte {

	private double decouvert;
	public CompteCourant() {
	super();
	}
	public CompteCourant(String numCompte, Date
	dateCreation,double solde,double dec) {
	super(numCompte, dateCreation, solde);
	this.decouvert=dec;
	}
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
