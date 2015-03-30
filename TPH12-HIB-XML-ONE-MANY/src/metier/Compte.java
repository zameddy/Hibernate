package metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Compte {
	private String numCompte;
	private Date dateCreation;
	private double solde;
	private Client client;
	private Set<Operation> operations=new HashSet<Operation>();
	public Compte() {
	}
	public Compte(String numCompte,Date dateCreation,double solde)
	{
	this.numCompte = numCompte;
	this.dateCreation = dateCreation;
	this.solde = solde;
	}
	public void addOperation(Operation op){
	operations.add(op);
	op.setCompte(this);
	}
	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
}
