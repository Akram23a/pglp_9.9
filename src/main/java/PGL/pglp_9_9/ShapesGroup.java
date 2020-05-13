package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
import java.util.ArrayList;
import java.util.List;

public abstract class ShapesGroup implements GraphicShape{

	private String groupName;
	private int groupId;
	private List<Shape> shapes;
	
	
	public ShapesGroup(String name, int id) {
		groupName = name;
		groupId = id;
	    shapes = new ArrayList<Shape>();
	}
	
	public void add(Shape gs) {
		shapes.add(gs);
	}
	
	public void remove(Shape gs) {
		shapes.remove(gs);
	}
	public void move(int x, int y) {
		for(Shape I: shapes) {
			I.move(x,y);
		}
	}
	
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public List<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	
	
	
	public String toString() {
		StringBuffer result = new StringBuffer();
	    for (Shape I : shapes) {
	    	result.append(" ");
	    	result.append(I.display());
		}
	    return this.getGroupName()+result;
	  }
}
