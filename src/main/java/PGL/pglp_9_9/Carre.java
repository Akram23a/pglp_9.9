package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class Carre extends Shape {
	/**
	 * BL
	 */
	private Point bottomLeft;
	/**
	 * L
	 */
	private double length;
	/**
	 * Carre
	 * @param name1
	 * @param id1
	 * @param length1
	 * @param p1
	 */
	public Carre(final String name1, int id1, final double length1, final Point p1) {
		super(name1, id1);
		setBottomLeft(new Point(p1));
		setLength(length1);
	}

	@Override
	public void move(final double x, final double y) {
		bottomLeft.move(x,y);
	}

	@Override
	public String display() {
		return "Carre - nom : " + getName() + " bas-gauche : "
					+ bottomLeft.display() + " longueur : "
					+ length + " groupe : " + getGroupId();
	}
	/**
	 * 
	 * @return string
	 */
	public Point getBottomLeft() {
		return bottomLeft;
	}
	/**
	 * setter
	 * @param bottomLeft BL
	 */
	public void setBottomLeft(final Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	/**
	 * getter
	 * @return l
	 */
	public double getLength() {
		return length;
	}
	/**
	 * setter
	 * @param length l
	 */
	public void setLength(final double length) {
		this.length = length;
	}
}
