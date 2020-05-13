package PGL.pglp_9_9;

public class Cercle extends Shape {
	/**
	 * 
	 */
	private Point centre;
	/**
	 * 
	 */
	private double rayon;
	/**
	 * 
	 * @param name1
	 * @param id1
	 */
	public Cercle( final int id1, final Point centre1, final double r) {
		super("Cercle", id1);
		centre = new Point(centre1.getX(), centre1.getY());
		rayon = r;
	}
	@Override
	public void move(double x1, double y1) {
		centre.move(x1, y1);
	}
	@Override
	public String display() {
		return " centre : "+centre.display()+" Rayon : "+getRayon();
	}
	/**
	 * 
	 * @return
	 */
	public Point getCentre() {
		return centre;
	}
	/**
	 * 
	 * @param centre1
	 */
	public void setCentre(Point centre1) {
		this.centre = centre1;
	}
	/**
	 * 
	 * @return
	 */
	public double getRayon() {
		return rayon;
	}
	/**
	 * 
	 * @param rayon1
	 */
	public void setRayon(double rayon1) {
		this.rayon = rayon1;
	}
}
