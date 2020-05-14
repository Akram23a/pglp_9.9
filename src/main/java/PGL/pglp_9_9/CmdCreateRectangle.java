package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateRectangle implements Command{
	
	private String name;
	private Point bottomLeft;
	private double height;
	private double width;
	private int groupId;

	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param int1
	 * @param int2
	 * @param groupId1
	 */
	public CmdCreateRectangle(String name1,Point point1,double int1,double int2,int groupId1) {
	    name = name1;
	    bottomLeft = point1;
	    height = int1;
	    height = int2;
	    groupId = groupId1;
	  }

	  @Override
	  public void execute() {
		// TODO Auto-generated method stub
	    new Rectangle(name, groupId, bottomLeft, height, width);
	  }
}
