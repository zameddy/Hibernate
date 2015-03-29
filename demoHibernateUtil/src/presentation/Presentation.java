package presentation;



import java.util.List;

import metier.Formation;
import dao.FormationDao;

public class Presentation {

	public static void main(String[] args) {

		FormationDao dao = new FormationDao();
		Formation f = new Formation("Hibernate");
		
		/*dao.create(f);*/
		List<Formation> liste = dao.findAll();
		for(Formation formation : liste)
		{
			System.out.println(formation);
		}
		/*dao.update(1L, "SPRING");*/
		/*dao.delete(1L);*/
		
		
	}
}
