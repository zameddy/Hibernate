package dao;

import java.util.List;

import org.hibernate.Session;

import metier.Formation;

public class FormationDao {

	public Formation create(Formation f)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(f);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
		return f;
	}
	
	public void delete (Formation f)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(f);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
	}
	
	public void delete (Long id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(session.get(Formation.class, id));
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
	}
	
	public void update(Long id,String theme)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Formation f = (Formation) session.get(Formation.class, id);
        f.setTheme(theme);
        session.saveOrUpdate(f);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
	}
	
	public List<Formation> findAll()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<Formation> list = session.createQuery("from Formation").list();
        return list;
	}
}
