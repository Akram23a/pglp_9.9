package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateCircle implements CmdCreate<Cercle>{
	
	private String name;
	private Point center;
	private double radius;
	private int gId;
	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param radius1
	 * @param groupId1
	 */
	public CmdCreateCircle(String name1,Point point1,double radius1,int gId1) {
	    gId = gId1;
		name = name1;
	    center = point1;
	    radius = radius1;
	  }

	  @Override
	  public Cercle execute() {
		return new Cercle(name, gId, center, radius);
	  }

}
