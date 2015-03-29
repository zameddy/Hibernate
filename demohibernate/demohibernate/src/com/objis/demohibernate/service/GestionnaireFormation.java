package com.objis.demohibernate.service;

import com.objis.demohibernate.dao.FormationDao;
import com.objis.demohibernate.simple.Formation;

public class GestionnaireFormation {

		FormationDao formationDao;
		
	// Rendre persistant une formation : déléguer à couche Dao !
	public Long creerFormation(Formation formation){
        Long formationId = formationDao.save(formation);                                       
        return formationId;
	}

	public GestionnaireFormation() {
		this.formationDao = new FormationDao();
	}
}
