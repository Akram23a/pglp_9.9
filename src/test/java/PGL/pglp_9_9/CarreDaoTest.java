package PGL.pglp_9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarreDaoTest {

	
	  @Test
	  public void testFind() {
		 
		CarreJDBC jdbcShape=new CarreJDBC();

	    Point point = new Point(0.0,0.0);
		Carre  c2= new Carre("c3",2,2.0,point);
		jdbcShape.create(c2);
		Carre c = jdbcShape.find("c3");
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
		CarreJDBC jdbcShape=new CarreJDBC();
		  Point p = new Point(2.0,2.0);
		  Carre r = new Carre("c11",2,5.0,p);
		  jdbcShape.create(r);
		  jdbcShape.delete(r.getName());
		  assertNull(jdbcShape.find("c11"));
	  }
	  
}
