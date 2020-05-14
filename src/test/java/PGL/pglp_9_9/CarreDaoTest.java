package PGL.pglp_9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarreDaoTest {

	
	  @Test
	  public void testFind() {
		 
		CarreJDBC cjdbc=new CarreJDBC();

	    Point point = new Point(0.0,0.0);
		Carre  c2= new Carre("c3",2,2.0,point);
		cjdbc.create(c2);
		Carre c = cjdbc.find("c3");
	    assertEquals(c.getName(),"c3");
	    Double x = c.getBottomLeft().getX();
	    Double y = c.getBottomLeft().getY();
	    Double lengh = c.getLength();
	    assertTrue(x.equals(0.0));
	    assertTrue(y.equals(0.0));
	    assertTrue(lengh.equals(2.0));
	    assertEquals(c.getGroupId(),2);
	  }
	  
	  @Test
	  public void testDelete() {
		CarreJDBC cjdbc=new CarreJDBC();
		  Point p = new Point(2.0,2.0);
		  Carre r = new Carre("c11",2,5.0,p);
		  cjdbc.create(r);
		  cjdbc.delete(r.getName());
		  assertNull(cjdbc.find("c11"));
	  }
	  
}
