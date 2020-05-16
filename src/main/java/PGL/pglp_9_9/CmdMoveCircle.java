package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdMoveCircle implements Command{
	/**
	 * cercle
	 */
	private Cercle a;
	/**
	 * nouv x
	 */
	private double newX;
	/**
	 * nouv y
	 */
	private double newY;
	/**
	 * constructor
	 * @param c1
	 * @param x1
	 * @param y1
	 */
	public CmdMoveCircle(final Cercle c1, final double x1, final double y1) {
		a = c1;
		newX = x1;
		newY = y1;
	}
	@Override
	public void execute() {
		a.move(newX, newY);
	}

}
