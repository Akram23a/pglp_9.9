package PGL.pglp_9_9;

public class Triangle extends Shape{
	/**
	 * 
	 */
	private Point p1;
	/**
	 * 
	 */
	private Point p2;
	/**
	 * 
	 */
	private Point p3;
	/**
	 * 
	 * @param id1
	 * @param pp1
	 * @param pp2
	 * @param pp3
	 */
	public Triangle(final String name1, 
		final int id1, final Point pp1, final Point pp2, final Point pp3) {
		super(name1, id1);
		p1 = new Point(pp1);
		p2 = new Point(pp2);
		p3 = new Point(pp3);
	}
	@Override
	public void move(final double x1, final double y1) {
		p1.move(x1, y1);
		p2.move(x1, y1);
		p3.move(x1, y1);
	}
	@Override
	public String display() {
		return "Triangle - nom :"+getName()+" p1: "+getP1().display()+
				" p2: "+getP2().display()+
				" p3 :"+getP3().display()+
				" groupe : "+getGroupId();
	}
	/**
	 * 
	 * @return
	 */
	public Point getP2() {
		return p2;
	}
	/**
	 * 
	 * @param p2
	 */
	public void setP2(final Point p2) {
		this.p2 = p2;
	}
	/**
	 * 
	 * @return
	 */
	public Point getP1() {
		return p1;
	}
	/**
	 * 
	 * @param p1
	 */
	public void setP1(final Point p1) {
		this.p1 = p1;
	}
	/**
	 * 
	 * @return
	 */
	public Point getP3() {
		return p3;
	}
	/**
	 * 
	 * @param p3
	 */
	public void setP3(final Point p3) {
		this.p3 = p3;
	}

}
