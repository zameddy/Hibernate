package com.objis.demohibernate.test;

import com.objis.demohibernate.service.GestionnaireFormation;
import com.objis.demohibernate.simple.Formation;

import junit.framework.TestCase;

public class GestionnaireFormationTest extends TestCase {

	// Tester la création d'une Formation. Teste clé primaire retournée
	public void testCreerFormation() {
		Formation formation = new Formation("EJB3");
		GestionnaireFormation gestionnaire = new GestionnaireFormation();		
		Long id = gestionnaire.creerFormation(formation);
		assertNotNull(id);
	}
}
