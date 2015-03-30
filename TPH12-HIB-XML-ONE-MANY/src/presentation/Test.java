package presentation;

import java.util.Date;
import java.util.Iterator;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Operation;
import dao.DaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl dao=new DaoImpl();
		dao.addClient(new Client("CLI1","ADR1"));
		dao.addClient(new Client("CLI2","ADR2"));
		dao.addCompte(new CompteCourant("CC1",new Date(),5000,8000),1L );
		dao.addCompte(new CompteEpargne("CE1",new Date(),8000,5.5),1L );
		dao.addOperation(new Operation(new Date(),4000, 0),"CC1");
		dao.addOperation(new Operation(new Date(),0, 7000),"CC1");
		try{
		Compte c=dao.getCompte("CC1");
		System.out.println("Solde:"+c.getSolde());
		System.out.println("Type de Compte:"+c.getClass().getSimpleName());
		System.out.println("Nom Client:"+c.getClient().getNom());
		Iterator<Operation> ops=c.getOperations().iterator();
		while(ops.hasNext()){
		Operation op=ops.next();
		System.out.println(op.getMtVersement()+"--"+op.getMtRetrait());
		}
		}
		catch (Exception e) { System.out.println(e.getMessage());
		}
	}

}
