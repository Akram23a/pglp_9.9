package PGL.pglp_9_9;

public abstract class Shape implements GraphicShape{
	/**
	   * shape's name
	   */
	  private String name;

	  /**
	   * Group id
	   */
	  private int id;
	  /**
	   * @param nameAtt.
	   */
	  public Shape(String name1,int id1) {
	    name = name1;
	    id = id1;
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
			return id;
		}
	  /**
	   * @param groupId1 
	   */
	  public void setGroupId(int groupId1) {
			this.id = groupId1;
		}

	  /**
	   * Show
	   */
	  public abstract String display();
}
