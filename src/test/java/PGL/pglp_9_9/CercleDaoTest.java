package PGL.pglp_9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.Statement;
import java.sql.Connection;

import org.junit.Test;

public class CercleDaoTest {


	
	  @Test
	  public void testFind() {
		  
		CercleJDBC jdbcShape=new CercleJDBC();

	    Point point = new Point(0.0,0.0);
		Cercle  c2= new Cercle("c2",2,point,2.0);
		jdbcShape.create(c2);
	    Cercle c = jdbcShape.find("c2");
	    assertEquals(c.getName(),"c2");
	    Double x = c.getCentre().getX();
	    Double y = c.getCentre().getY();
	    Double redius = c.getRayon();
	    assertTrue(x.equals(0.0));
	    assertTrue(y.equals(0.0));
	    assertTrue(redius.equals(2.0));
	    assertEquals(c.getGroupId(),2);
	  }
	  


}
