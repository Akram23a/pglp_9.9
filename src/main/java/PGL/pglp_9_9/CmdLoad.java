package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CmdLoad implements CmdCreate<Shape> {
		/**
		 * 
		 */
	  private String name;
	  /**
	   * 
	   */
	  private String type;
	  /**
	   * 
	   */
	  private CarreJDBC c;
	  private CercleJDBC l;
	  private TriangleJDBC t;
	  private RectangleJDBC r;

	  /**
	   * 
	   * @param group1
	   */
	  public CmdLoad(final String name1,final String type1) {
	    this.name = name1;
	    this.name = type1;
	    switch(type) {
	    case "cercle":
	    	l = new CercleJDBC();
	    	break;
	    case "carre":
	    	c = new CarreJDBC();
	    	break;
	    case "triangle":
	    	t = new TriangleJDBC();
	    	break;
	    case "rectangle":
	    	r = new RectangleJDBC();
	    	break;	
	    }
	  }
	  
	  @Override
	  public Shape execute() {
		  switch(type) {
		    case "cercle":
		    	return l.find(name);
		case "carre":
		    	return c.find(name);

		case "triangle":
		    	return t.find(name);

		case "rectangle":
		    	return r.find(name);	
		    }
		return null;
	  }
}
