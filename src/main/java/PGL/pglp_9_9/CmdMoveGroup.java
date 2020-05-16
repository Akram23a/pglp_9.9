package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdMoveGroup implements Command{
	/**
	 * 
	 */
	private ShapesGroup g;
	/**
	 * 
	 */
	private double newX;
	/**
	 * 
	 */
	private double newY;
	/**
	 * Constructor
	 * @param c1
	 * @param x1
	 * @param y1
	 */
	public CmdMoveGroup(final ShapesGroup c1, final double x1, final double y1) {
		g = c1;
		newX = x1;
		newY = y1;
	}
	
	@Override
	public void execute() {
		g.move(newX, newY);
	}

}
