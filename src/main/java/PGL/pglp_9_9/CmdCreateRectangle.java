package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateRectangle implements CmdCreate<Rectangle>{
	/**
	 * rect name
	 */
	private String name;
	/**
	 * bottom left
	 */
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
	public CmdCreateRectangle(final String name1, final int groupId1, final Point point1, final double int1, final double int2) {
		name = name1;
	    bottomLeft = point1;
	    height = int1;
	    width = int2;
	    groupId = groupId1;
	  }
	
	  @Override
	  public Rectangle execute() {
		return new Rectangle(name, groupId, bottomLeft, height, width);
	  }
}
