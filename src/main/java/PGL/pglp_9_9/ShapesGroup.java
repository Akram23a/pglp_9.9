package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
import java.util.ArrayList;
import java.util.List;

public abstract class ShapesGroup implements GraphicShape{
	/**
	 * Name
	 */
	private String groupName;
	/**
	 * Id
	 */
	private int groupId;
	/**
	 * Shapes list
	 */
	private List<Shape> shapes;
	
	/**
	 * 
	 * @param name
	 * @param id
	 */
	public ShapesGroup(String name, int id) {
		groupName = name;
		groupId = id;
	    shapes = new ArrayList<Shape>();
	}
	/**
	 * 
	 * @param gs
	 */
	public void add(Shape gs) {
		shapes.add(gs);
	}
	/**
	 * 
	 * @param gs
	 */
	public void remove(Shape gs) {
		shapes.remove(gs);
	}
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		for(Shape I: shapes) {
			I.move(x,y);
		}
	}
	/**
	 * 
	 * @return
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 
	 * @param groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 
	 * @return
	 */
	public int getGroupId() {
		return groupId;
	}
	/**
	 * 
	 * @param groupId
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	/**
	 * 
	 * @return
	 */
	public List<Shape> getShapes() {
		return shapes;
	}
	/**
	 * 
	 * @param shapes
	 */
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	/**
	 * @return String
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
	    for (Shape I : shapes) {
	    	result.append(" ");
	    	result.append(I.display());
		}
	    return this.getGroupName()+result;
	  }
}
