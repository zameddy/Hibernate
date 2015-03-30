package test;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import metier.Personne;
import metier.Reunion;
import dao.DaoImpl;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl dao=new DaoImpl();
		/*dao.addReunion(new Reunion("RT1",new Date()));
		dao.addReunion(new Reunion("RR2",new Date()));
		dao.addReunion(new Reunion("RT3",new Date()));
		dao.addPersonne(new Personne("P1","N1"));
		dao.addPersonne(new Personne("P2","N2"));
		dao.addPersonne(new Personne("P3","N3"));*/
		//dao.addPersonneToReunion(new Long(1), new Long(1));
		//dao.addPersonneToReunion(new Long(1), new Long(2));
		dao.addPersonneToReunion(2L,1L);
		
		dao.addReunionToPersonne(1L, 1L);
		//Iterator<Reunion> it=dao.getAllReunions().iterator();
		/*Iterator<Reunion> it=dao.getReunionsParMotCle("RT").iterator();
		while(it.hasNext()){
		Reunion r=(Reunion)it.next();
		System.out.println(r.getTitre());
		}
		System.out.println("Consulter la personne 1");
		Personne p=dao.getPersonne(new Long(1));
		System.out.println("Nom="+p.getNomPersonne());
		System.out.println("Prénom="+p.getPrenomPersonne());
		System.out.println("Reunions");
		Iterator<Reunion> it2=p.getReunions().iterator();
		while(it2.hasNext()){
		Reunion r=it2.next();
		System.out.println(r.getTitre());
		}*/}
	}


