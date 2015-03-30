package igpde.gestion.metier;

public class Service {

	/**
	 * @param args
	 */
	private int id;
	private String libelle;
	private String interlocuteur;
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
	public String getInterlocuteur() {
		return interlocuteur;
	}
	public void setInterlocuteur(String interlocuteur) {
		this.interlocuteur = interlocuteur;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id ="+id+" "+"libelle ="+libelle+" interlocuteur="+interlocuteur;
	}
}
