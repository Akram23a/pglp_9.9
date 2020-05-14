package PGL.pglp_9_9;

public class CmdCreateSquare implements Command {
	private String name;
	private Point bottomLeft;
	private double length;
	private int groupId;

	/**
	 * Constructor
	 * @param name1
	 * @param point1
	 * @param int1
	 * @param int2
	 * @param groupId1
	 */
	public CmdCreateSquare(String name1,Point point1,double int1,int groupId1) {
	    name = name1;
	    bottomLeft = point1;
	    length = int1;
	    groupId = groupId1;
	  }

	  @Override
	  public void execute() {
		// TODO Auto-generated method stub
	    new Carre(name, groupId, length, bottomLeft);
	  }
}