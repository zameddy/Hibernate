package igpde.gestion.dao;

import igpde.gestion.metier.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ServiceManager {

	@SuppressWarnings("deprecation")
	public static final SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();

	
	public ServiceManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List findAll() {
		List listeService = new ArrayList();
		
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			List list = s.createQuery("from Service").list();

			Iterator it = list.iterator();
			for (; it.hasNext();) { 
				Service service = (Service) it.next();
				listeService.add(service);
			  }
			
			/* JDK 5.0
			  for (Service service : (List<Service>) list) {
				listeService.add(service);
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}

		return listeService;
		
		
	}

	public void delete(Service service) {
		Service serviceSauve = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(service);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		
	}

	public Service save(Service service) {

		// TODO Auto-generated method stub
		Service serviceSauve = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(service);
			tx.commit();
			serviceSauve = service;
			
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		return serviceSauve;
		
	}

	public Service findService(String libelle) {
		// TODO Auto-generated method stub
		Service service = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			List list = s.createQuery("from Service where libelle = ?").setString(0,
					libelle).list();
			
			tx.commit();
			
			if (list.size() > 0)
				service = (Service) list.get(0);

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
		} finally {
			s.close();
		}

		return service;
		
		

	}
  public Service serviceUpdate (Service service)
  {
	  Service serviceUpdate = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
	  try {
		  tx = s.beginTransaction();
		  System.out.println();
		  Query query = s.createQuery("update Service set interlocuteur = 'DIALOG2'" +
  				" where id = ?").setInteger(0, service.getId());
          int result = query.executeUpdate();
          tx.commit();
		
	} catch (Exception e)  {
		// TODO: handle exception
		if (tx != null)
			tx.rollback();
		// throw e;
	} finally {
		s.close();
	}
	  return service;
  }
  
}

/*
class ServiceManager2 {
	 static SessionFactory sessionFactory = 
	  new Configuration().configure().buildSessionFactory();
	public void test()
	 {Session session = sessionFactory.openSession();
	  Transaction tx = null ;
	  try {
	   tx = session.beginTransaction();
	   //votre code
	   tx.commit();
	  }catch (Exception e) {
	   if (tx != null) {
	    try {
	     tx.rollback();
	    }catch (HibernateException he) {throw he;}
	   }
	   throw e;
	  }
	  finally {
	   try {session.close();} catch (HibernateException ex) {
	   throw ex;}
	  }
	}
}*/
