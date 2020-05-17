package PGL.pglp_9_9;

public class CmdCreateShpaesGroup implements CmdCreate<ShapesGroup>{
	private String name;
	private int id;
	/**
	 * Constructor
	 * @param n1
	 * @param int1
	 */
	public CmdCreateShpaesGroup(final String n1,final int int1) {
		name = n1;
		id = int1;
	}
	
	@Override
	public ShapesGroup execute() {
	    return new ShapesGroup(name,id);	
	}
}
