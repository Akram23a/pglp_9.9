package PGL.pglp_9_9;

public class Rectangle extends Shape{
	/**
	 * 
	 */
	private Point bottomLeft;
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private double width;
	/**
	 * Constructor
	 * @param string
	 * @param int1
	 * @param bottomLeft1
	 * @param double1
	 * @param double2
	 */
	public Rectangle(String string, int int1, Point bottomLeft1, double double1, double double2) {
		super(string, int1);
		this.bottomLeft = bottomLeft1;
		this.height = double1;
		this.width = double2;
	}

	@Override
	public void move(double x1, double y1) {
		bottomLeft.move(x1, y1);
	}

	@Override
	public String display() {
		return "Rectangle - nom : " + getName() + 
				" bas-gauche: " + this.bottomLeft.display() +
				" longueur :" + height + " largeur :" + width
				+ " groupe : " + getGroupId();
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
	public double getHeight() {
		return height;
	}
	/**
	 * 
	 * @param height
	 */
	public void setHeight(final double height) {
		this.height = height;
	}
	/**
	 * 
	 * @return
	 */
	public double getWidth() {
		return width;
	}
/**
 * 
 * @param width
 */
	public void setWidth(final double width) {
		this.width = width;
	}

}
