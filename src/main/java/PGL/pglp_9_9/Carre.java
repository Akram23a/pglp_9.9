package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class Carre extends Shape {

	private Point bottomLeft;
	private double length;
	/**
	 * Carre
	 * @param name1 name
	 * @param id1 id
	 * @param length1 length
	 * @param p1 point1
	 */
	public Carre(final String name1, final int id1,
			final double length1, final Point p1) {
		super(name1, id1);
		setBottomLeft(new Point(p1));
		setLength(length1);
	}

	@Override
	public void move(final double x, final double y) {
		bottomLeft.move(x, y);
	}

	@Override
	public String display() {
		return "Carre - nom : " + getName() + " bas-gauche : "
					+ bottomLeft.display() + " longueur : "
					+ length + " groupe : " + getGroupId();
	}
	/**
	 * 
	 * @return bottomleft
	 */
	public Point getBottomLeft() {
		return bottomLeft;
	}
	/**
	 * setter
	 * @param bottomLeft1 BL
	 */
	public void setBottomLeft(final Point bottomLeft1) {
		this.bottomLeft = bottomLeft1;
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
	 * @param length1 l
	 */
	public void setLength(final double length1) {
		this.length = length1;
	}
}
