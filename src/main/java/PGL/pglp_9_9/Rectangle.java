package PGL.pglp_9_9;

public class Rectangle extends Shape{
	
	private Point bottomLeft;
	private double height;
	private double width;
	
	public Rectangle(int Groupid1, final Point bottomLeft1,
			final double height1, final double width1) {
		super("rectangle", Groupid1);
		this.bottomLeft = bottomLeft1;
		this.height = height1;
		this.width = width1;
	}

	@Override
	public void move(double x1, double y1) {
		bottomLeft.move(x1, y1);
	}

	@Override
	public String display() {
		return "Carre : "+this.getGroupId()+
				" LeftBottom "+this.bottomLeft.display()+
				" Height :"+height+" Width :"+width;
	}

	public Point getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}
