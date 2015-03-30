package metier;

import java.util.HashSet;
import java.util.Set;

public class Personne {
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private int age;
	private Set<Reunion> reunions=new HashSet<Reunion>();
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personne(String nomPersonne, String prenomPersonne, int age) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.age = age;
	}


	public Personne(String nomPersonne, String prenomPersonne) {
		// TODO Auto-generated constructor stub
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Reunion> getReunions() {
		return reunions;
	}
	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}
	/*
	 * méthodes additionnelles
	 */
	public void addReunion(Reunion r) {
		reunions.add(r);
		r.getPersonnes().add(this);
		}
		public void removeReunion(Reunion r) {
		reunions.remove(r); r.getPersonnes().remove(this);
		}
}
