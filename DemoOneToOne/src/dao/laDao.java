package dao;

import metier.Adresse;
import metier.Evenement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class laDao {
	//@SuppressWarnings("deprecation")
		static SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		public laDao() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Adresse addAdresse(Adresse a)
	{
	
		Session s = sessionFactory.openSession();
		
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		return a;
	}
	
	public Evenement addEvent(Evenement ev)
	{
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(ev);
			tx.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		return ev;
	}
	
	public void AdressEvent(Adresse a, Evenement ev)
	{
		Session s = sessionFactory.openSession();
		Evenement even=null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			even=(Evenement) s.get(Evenement.class, ev.getId());
			even.setAddress(a);
			tx.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
	}
	
	public Evenement getEvent(int id)
	{
		Session s = sessionFactory.openSession();
		Evenement a=null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			a=(Evenement) s.get(Evenement.class, id);
		}
		catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return a;
	}
	
	public Adresse getAdresse(int id)
	{
		Session s = sessionFactory.openSession();
		Adresse a=null;
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			a=(Adresse) s.get(Adresse.class, id);
		}
		catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return a;
	}
}
