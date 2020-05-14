package PGL.pglp_9_9;

public class Rectangle extends Shape{
	
	private Point bottomLeft;
	private double height;
	private double width;
	


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
