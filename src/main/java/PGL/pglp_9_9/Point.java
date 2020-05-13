package PGL.pglp_9_9;

public class Point {
	/**
	 * cord X
	 */
	private double x;
	/**
	 * cord Y
	 */
	private double y;
	/**
	 * Constructor
	 * @param newX
	 * @param newY
	 */
	public Point(final double newX, final double newY) {
		x = newX;
		y = newY; 
	}
	
	public Point(final Point P) {
		x = P.getX(); 
		y = P.getY(); 
	}
	/**
	 * 
	 * @return X
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 * @param x 
	 */
	public void setX(double x1) {
		this.x = x1;
	}
	/**
	 * 
	 * @return cord Y
	 */
	public double getY() {
		return y;
	}
	/**
	 * Move
	 * @param x1
	 * @param y1
	 */
	public void move(double x1, double y1) {
		this.setX(x1);
		this.setY(y1);
	}
	/**
	 * 
	 * @param y cord X
	 */
	public void setY(double y1) {
		this.y = y1;
	}
	/**
	 * 
	 * @return display
	 */
	public String display() {
		return " ( "+this.x+","+this.y+" ) ";
	}
}
