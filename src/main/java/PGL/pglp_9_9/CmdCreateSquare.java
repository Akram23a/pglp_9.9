package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateSquare implements CmdCreate<Carre> {
	/**
	 * name
	 */
	private String name;
	/**
	 * name
	 */
	private Point bottomLeft;
	/**
	 * length
	 */
	private double length;
	/**
	 * id group
	 */
	private int groupId;

	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param int1
	 * @param int2
	 * @param groupId1
	 */
	public CmdCreateSquare(String name1,Point point1,double int1,int groupId1) {
	    name = name1;
	    bottomLeft = point1;
	    length = int1;
	    groupId = groupId1;
	  }

	  @Override
	  public Carre execute() {
		return new Carre(name, groupId, length, bottomLeft);
	  }
}
