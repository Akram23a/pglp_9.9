package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class Cercle extends Shape {
	/**
	 * centre
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
	public Cercle(final String name1, final int id1, final Point centre1, final double r) {
		super(name1, id1);
		centre = new Point(centre1.getX(), centre1.getY());
		rayon = r;
	}
	@Override
	public void move(final double x1, final double y1) {
		centre.move(x1, y1);
	}
	@Override
	public String display() {
		return "Cercle - nom: " + getName() + " centre : " 
					+ centre.display() + 
					" rayon : " + getRayon() + 
					" groupe : " + getGroupId();
	}
	/**
	 * getter
	 * @return c
	 */
	public Point getCentre() {
		return centre;
	}
	/**
	 * setter
	 * @param centre1 c
	 */
	public void setCentre(final Point centre1) {
		this.centre = centre1;
	}
	/**
	 * getter
	 * @return r
	 */
	public double getRayon() {
		return rayon;
	}
	/**
	 * setter
	 * @param rayon1 r
	 */
	public void setRayon(final double rayon1) {
		this.rayon = rayon1;
	}
}
