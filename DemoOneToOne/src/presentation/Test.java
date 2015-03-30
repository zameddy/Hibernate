package presentation;

import java.util.Date;

import metier.Adresse;
import metier.Evenement;
import dao.laDao;

public class Test {

	public static void main(String[] args) {
		laDao dao = new laDao();
		
		/*Adresse a = new Adresse("zam", 
				"3 rue claude nicolas ledoux", 
				"77600", "Bussy saint georges");
		dao.addAdresse(a);
		Evenement e = new Evenement("guérison", "aaron", true);
		dao.addEvent(e);*/
		Adresse a=dao.getAdresse(1);
		Evenement e = dao.getEvent(1);
		dao.AdressEvent(a, e);
	}
	
	
}
