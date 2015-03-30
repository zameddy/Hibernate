package dao;

import java.util.List;

import metier.Personne;
import metier.Reunion;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import util.HibernateUtil;

public class DaoImpl {

	/*
	 * private SessionFactory sessionFactory; public DaoImpl() {
	 * sessionFactory=HibernateUtil.getSessionFactory().getCurrentSession(); }
	 */
	// Méthode de mapping objet relationnel
	public void addReunion(Reunion r) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(r);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}finally {
			// pas besoin de fermer la session car commit avant
			//session.close();
		}
		
	}

	public List<Reunion> getReunionsParMotCle(String mc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Query req = null;
		try {
			tx = session.beginTransaction();
			req = session
					.createQuery("select r from Reunion r where r.titre like :x");
			req.setParameter("x", "%" + mc + "%");
			
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			//session.close();
		}
		return req.list();
	}

	public Reunion getReunion(Long idR) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Reunion r;
		try {
			tx = session.beginTransaction();
			r = (Reunion) session.get(Reunion.class, idR);
			// HibernateUtil.getSessionFactory().close();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// on ferme la session car pas de commit avant
			session.close();
		}
		return r;
	}

	public void deleteReunion(Long idR) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
		session.beginTransaction();
		Reunion r = (Reunion) session.get(Reunion.class, idR);
		session.delete(r);
		// le commit ferme la session
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// plus besoin de close()
			//session.close();
		}
		// HibernateUtil.getSessionFactory().close();
	}

	public void addPersonne(Personne p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
		session.beginTransaction();
		session.save(p);
		// le commit ferme la session
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			//pas besoin de close
			//session.close();
		}
	}

	public void addReunionToPersonne(Long idPersonne, Long idReunion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
		session.beginTransaction();
		// Charger une personne
		Personne p = (Personne) session.get(Personne.class, idPersonne);
		// Charger une réunion
		Reunion r = (Reunion) session.get(Reunion.class, idReunion);
		// Ajouter la réunion r à la collection reunions de la personne p
		p.getReunions().add(r);
		// le commit ferme la session
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// pas besoin du close
			//session.close();
		}
	}

	public Personne getPersonne(Long idPersonne) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Personne p;
		try{
		session.beginTransaction();
		 p = (Personne) session.get(Personne.class, idPersonne);
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// on ferme la session car pas de commit avant
			session.close();
		}
		return p;
		
	}

	public Personne getPersonneV2(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Object o;
		try{
		session.beginTransaction();
		Criteria crit = session.createCriteria(Personne.class);
		crit.add(Expression.eq("idPersonne", id));
		 o = crit.uniqueResult();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// on ferme la session car pas de commit avant
			session.close();
		}
		
		return (Personne) o;
	}

	public void addPersonneToReunion(Long idReunion, Long idPersonne) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
		session.beginTransaction();
		// Charger une personne
		Personne p = (Personne) session.get(Personne.class, idPersonne);
		// Charger une réunion
		Reunion r = (Reunion) session.get(Reunion.class, idReunion);

		r.getPersonnes().add(p);
		// le commit ferme la session
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		finally {
			// plus besoin de fermer la session ici
			//session.close();
		}
	}

}
