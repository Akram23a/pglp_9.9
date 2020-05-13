package PGL.pglp_9_9;

public abstract class Shape implements GraphicShape{
	/**
	   * shape's name
	   */
	  private String name;

	  /**
	   * Group id
	   */
	  private int groupId;
	  /**
	   * @param nameAtt.
	   */
	  public Shape(String name1,int groupId1) {
	    name = name1;
	    groupId = groupId1;
	  }
	  /**
	   * @param x 
	   * @param y 
	   */
	  public abstract void move(double x,double y);

	  /**
	   * @return 
	   */
	  public String getName() {
	    return name;
	  }

	  /**
	   * @param name1 
	   */
	  public void setName(String name1) {
	    name = name1;
	  }

	  /**
	   * @return id 
	   */
	  public int getGroupId() {
			return groupId;
		}
	  /**
	   * @param groupId1 
	   */
	  public void setGroupId(int groupId1) {
			this.groupId = groupId1;
		}

	  /**
	   * Show
	   */
	  public abstract String display();
}
