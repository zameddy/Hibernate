package com.objis.demohibernate;

import com.objis.demohibernate.service.GestionnaireFormation;
import com.objis.demohibernate.simple.Formation;

public class DemoHibernate {

	public static void main(String[] args) {
		
		// 1 : instanciation objet couche service
		GestionnaireFormation serviceGestionnaire = new GestionnaireFormation();
		
		// 2 : Instanciation Objet couche métier
		Formation formation = new Formation("Hibernate");
		
		// 3 : Utilisation du service
		serviceGestionnaire.creerFormation(formation);
				
	}

}
