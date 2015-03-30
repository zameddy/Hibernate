package metier;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private Long codeClient;
	private String nom,adresse;
	private Set<Compte>comptes=new HashSet<Compte>();
	public Client() {
	}
	public Client(String nom, String adresse) {
	this.nom = nom;
	this.adresse = adresse;
	}
	public void addCompte(Compte c){
	comptes.add(c);
	c.setClient(this);
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Set<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
