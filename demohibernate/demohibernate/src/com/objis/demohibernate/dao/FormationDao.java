package com.objis.demohibernate.dao;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;

import com.objis.demohibernate.simple.Formation;
import com.objis.demohibernate.simple.util.HibernateUtil;

public class FormationDao {

	// Rendre persistant une formation 
	// Tous le code 'technique' liés aux exceptions et gestion Session est ici
	public Long save(Formation formation){
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics(); // statistiques

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		Long formationId = null;
		try {
			session.saveOrUpdate(formation);
			tx.commit();
			formationId = formation.getId();
		} 
		catch (Exception e) {
			tx.rollback();
		} 
		
		stats.logSummary();                                                    // statistiques

		return formationId;
	}
}
