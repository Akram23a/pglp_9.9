package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdCreateCircle implements CmdCreate<Cercle>{
	/**
	 * name
	 */
	private String name;
	/**
	 * center
	 */
	private Point center;
	/**
	 * radius
	 */
	private double radius;
	/**
	 * id
	 */
	private int gId;
	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param radius1
	 * @param groupId1
	 */
	public CmdCreateCircle(final String name1, final Point point1, final double radius1,final int gId1) {
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
