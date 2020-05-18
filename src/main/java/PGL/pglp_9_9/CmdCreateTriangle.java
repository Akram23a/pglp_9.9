package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateTriangle implements CmdCreate<Triangle>{
		/**
		 * 
		 */
	  private String name;
	  /**
	   * 
	   */
	  private Point p1;
	  /**
	   * 
	   */
	  private Point p2;
	  /**
	   * 
	   */
	  private Point p3;
	  /**
	   * 
	   */
	  private int groupId;
	  /**
	   * Constructor
	   * @param name1
	   * @param groupId1
	   * @param pnt1
	   * @param pnt2
	   * @param pnt3
	   */
	  public CmdCreateTriangle(String name1, int groupId1, Point pnt1, Point pnt2,Point pnt3) {
		  name = name1;
		  p1 = pnt1;
		  p2 = pnt2;
		  p3 = pnt3;
		  groupId = groupId1;
	  }

	  @Override
	  public Triangle execute() {
	    return new Triangle(name,groupId,p1,p2,p3);
	  }

}
