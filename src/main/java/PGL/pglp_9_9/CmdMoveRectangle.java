package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdMoveRectangle implements CmdMove{
	/**
	 * 
	 */
	private double newX;
	/**
	 * 
	 */
	private double newY;
	/**
	 * 
	 */
	private Rectangle c;
	/**
	 * Constructor
	 * @param c1
	 * @param x1
	 * @param y1
	 */
	public CmdMoveRectangle(final Rectangle c1, final double x1, final double y1) {
		c = c1;
		newX = x1;
		newY = y1;
	}

	@Override
	public void execute() {
		c.move(newX, newY);
	}
}
