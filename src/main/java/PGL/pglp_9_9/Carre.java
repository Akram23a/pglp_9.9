package PGL.pglp_9_9;

public class Carre extends Shape {
	/**
	 * 
	 */
	private Point bottomLeft;
	/**
	 * 
	 */
	private double length;
	/**
	 * 
	 * @param name1
	 * @param id1
	 * @param length1
	 * @param p1
	 */
	public Carre(String name1, int id1, final double length1, final Point p1) {
		super(name1, id1);
		setBottomLeft(new Point(p1));
		setLength(length1);
	}

	@Override
	public void move(double x, double y) {
		bottomLeft.move(x,y);
	}

	@Override
	public String display() {
		return "Carre : BottomLeft ; "+bottomLeft.display()+" length : "+length;
	}
	/**
	 * 
	 * @return
	 */
	public Point getBottomLeft() {
		return bottomLeft;
	}
	/**
	 * 
	 * @param bottomLeft
	 */
	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	/**
	 * 
	 * @return
	 */
	public double getLength() {
		return length;
	}
	/**
	 * 
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}

}
