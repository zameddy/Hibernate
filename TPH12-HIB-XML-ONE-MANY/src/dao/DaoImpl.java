package dao;

import metier.Client;
import metier.Compte;
import metier.Operation;

import org.hibernate.Session;

import util.HibernateUtil;

public class DaoImpl {

	/* AJOUTER UN NOUVEAU CLIENT */
	public void addClient(Client c) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.save(c);
		sess.getTransaction().commit();
	}

	/* AJOUTER UN NOUVEAU COMPTE D’UN CLIENT DONNE */
	public void addCompte(Compte cpte, Long idCli) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		Client cli = (Client) sess.get(Client.class, idCli);
		cli.addCompte(cpte);
		sess.save(cpte);
		sess.getTransaction().commit();
	}

	/* AJOUTER UNE NOUVELLE OPERATION D’UN COMPTE DONNE */
	public void addOperation(Operation op, String numCpte) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		Compte cpte = (Compte) sess.get(Compte.class, numCpte);
		cpte.addOperation(op);
		sess.save(op);
		sess.getTransaction().commit();
	}

	/* CONSULTER UN COMPTE SACHANT SON CODE */
	public Compte getCompte(String numCpte) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		Object o = sess.get(Compte.class, numCpte);
		if (o == null)
			throw new RuntimeException("Compte introuvable");
		Compte cpte = (Compte) o;
		return cpte;
	}
	
	/* CONSULTER UN CLIENT SACHANT SON CODE */
	public Client getClient(Long idc){
	Session sess=HibernateUtil.getSessionFactory().getCurrentSession();
	sess.beginTransaction();
	Object o=sess.get(Client.class, idc);
	if(o==null) throw new RuntimeException("Client introuvable");
	Client cpte=(Client)o;
	return cpte;
	}
}
