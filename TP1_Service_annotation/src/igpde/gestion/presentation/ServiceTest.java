package igpde.gestion.presentation;
import junit.framework.TestCase;
import igpde.gestion.dao.ServiceManager;
import igpde.gestion.metier.Service;

public class ServiceTest extends TestCase{
	private ServiceManager serviceMgr = new ServiceManager();
    
    public void testLifeCycle(){
        int nb = serviceMgr.findAll().size();
        
        Service servicecdif = new Service("CDIF Nantes", "Michel MARTIN");
        
        servicecdif = serviceMgr.save(servicecdif);
        assertNotNull(serviceMgr.findService("CDIF Nantes"));
        assertEquals(nb+1, serviceMgr.findAll().size());
        
        serviceMgr.delete(servicecdif);
        assertEquals(nb, serviceMgr.findAll().size());        
    }
}




