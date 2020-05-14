package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateCircle implements Command{
	
	private String name;
	private Point center;
	private double radius;
	private int groupId;
	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param radius1
	 * @param groupId1
	 */
	public CmdCreateCircle(String name1,Point point1,double radius1,int groupId1) {
	    name = name1;
	    center = point1;
	    radius = radius1;
	    groupId = groupId1;
	  }

	  @Override
	  public void execute() {
		// TODO Auto-generated method stub
	    new Cercle(name, groupId, center, radius);
	  }

}
