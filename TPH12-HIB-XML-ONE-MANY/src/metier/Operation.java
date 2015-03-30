package metier;

import java.util.Date;

public class Operation {

	private Long numOperation;
	private Date dateOperation;
	private double mtVersement,mtRetrait;
	private Compte compte;
	public Operation() {
	}
	public Operation(Date dateOperation, double
	mtVersement, double mtRetrait) {
	this.dateOperation = dateOperation;
	this.mtVersement = mtVersement;
	this.mtRetrait = mtRetrait;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMtVersement() {
		return mtVersement;
	}
	public void setMtVersement(double mtVersement) {
		this.mtVersement = mtVersement;
	}
	public double getMtRetrait() {
		return mtRetrait;
	}
	public void setMtRetrait(double mtRetrait) {
		this.mtRetrait = mtRetrait;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
