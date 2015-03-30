
package igpde.gestion.presentation;

import igpde.gestion.dao.ServiceManager;
import igpde.gestion.metier.Service;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServiceManager serviceMgr = new ServiceManager();
		List mesServices = new ArrayList();
		
		//CRUD
		Service s= new Service("Toto","Tata");
		s=serviceMgr.save(s);
		
		mesServices = serviceMgr.findAll();
		System.out.println("AVANT MISE A JOUR");
		for(int i=0;i<mesServices.size();i++)
		{
			
			System.out.println(mesServices.get(i));
			
		}
		
      Service modif = serviceMgr.serviceUpdate(s);
      System.out.println("Service mis à jour =>"+s);
      mesServices = serviceMgr.findAll();
      //contrôle de mise à jour
      System.out.println("APRES MISE A JOUR");
      for(int i=0;i<mesServices.size();i++)
		{
    	    
			System.out.println(mesServices.get(i));
			
		}
  /*    System.out.println("service supprimé="+s);
      serviceMgr.delete(s);
      mesServices = serviceMgr.findAll();
      //contrôle de mise à jour
      System.out.println("APRES SUPPRESSION");
      for(int i=0;i<mesServices.size();i++)
		{
    	    
			System.out.println(mesServices.get(i));
			
		}*/
		System.out.println("get");
      System.out.println(serviceMgr.serviceGet(2));
      //test du load
		System.out.println("load");
      Service leservice = serviceMgr.serviceLoad(2);
      System.out.println(leservice.getId());
	}

}
