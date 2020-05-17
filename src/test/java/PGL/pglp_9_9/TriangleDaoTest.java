package PGL.pglp_9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TriangleDaoTest {
	  public void testUpdate() {
		  
		  TriangleJDBC jdbcShape=new TriangleJDBC();

		  Point p1 = new Point(5,8);
		  Point p2 = new Point(5,0);
		  Point p3 = new Point(0,8);

		  Point p4 = new Point(2,8);
		  Point p5 = new Point(5,2);

		  Triangle  t= new Triangle("t1",2,p1,p2,p3);
		  jdbcShape.create(t);
		  Triangle  t2 = new Triangle("t2",3, p1,p4,p5);
		  jdbcShape.update(t2);
		  Triangle t3 = jdbcShape.find("t1");
		  assertEquals(t3.getName(),"t1");
		  Double x = t3.getP1().getX();
		  Double y = t3.getP1().getY();
		  assertTrue(x.equals(2.0));
		  assertTrue(y.equals(8.0));
		  assertEquals(t3.getGroupId(),3);

	  }

}
