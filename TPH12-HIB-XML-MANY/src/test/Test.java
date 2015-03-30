package test;

import java.util.Date;
import java.util.List;

import metier.Personne;
import metier.Reunion;
import dao.DaoImpl;

public class Test {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	DaoImpl metier = new DaoImpl();
	// Ajouter 3 Réunions
	metier.addReunion(new Reunion("R1", new Date()));
	metier.addReunion(new Reunion("R2", new Date()));
	metier.addReunion(new Reunion("R3", new Date()));
	//Ajouter une personne
	metier.addPersonne(new Personne("dupond","jean",25));
	// Afficher les Réunions dont le titre contient R
	List<Reunion> reunions=metier.getReunionsParMotCle("R");
	for(Reunion r:reunions)
	System.out.println(r.getTitre());
	// Afficher le titre de la réunion dont le id est 2
	Reunion r=metier.getReunion(2L);
	System.out.println(r.getTitre());
	// ajouter une réunion à une personne
	metier.addReunionToPersonne(1L, 1L);
	//Personne p = metier.getPersonne(1L);
	//System.out.println(p);
}
}
