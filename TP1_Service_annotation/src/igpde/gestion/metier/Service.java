package igpde.gestion.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="services")
public class Service {

	/**
	 * @param args
	 */
	private int id;
	private String libelle;
	private String interlocuteur;
	private int version;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Service(String libelle, String interlocuteur) {
		super();
		// TODO Auto-generated constructor stub
		this.interlocuteur = interlocuteur;
		this.libelle = libelle;
	}
	public Service()  {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column
	public String getInterlocuteur() {
		return interlocuteur;
	}
	public void setInterlocuteur(String interlocuteur) {
		this.interlocuteur = interlocuteur;
	}
	@Column
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id ="+id+" "+"libelle ="+libelle+" interlocuteur="+interlocuteur;
	}
}
