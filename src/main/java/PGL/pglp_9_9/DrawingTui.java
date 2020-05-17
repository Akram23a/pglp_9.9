package PGL.pglp_9_9;

import java.util.ArrayList;
import java.util.List;

public class DrawingTui {
	/**
	 * List of shapes
	 */
	private List<Shape> shapes;
//	private CmdCreate<Cercle> cmdCreate;
	
    public DrawingTui(){
    	
    	setShapes(new ArrayList<Shape>());

    }
    
    
    
    /**
     * Main func of commands
     * @param cmd command
     * @return ret
     */
    public Command nextCommand(String cmd) {
       
    	String[] text = cmd.split("-");
        Command command = null;
        String nextCmd = text[0].toLowerCase();
    	Shape shape = null;

    	
        switch(nextCmd) {
        	case "showall":
        		StringBuffer show = new StringBuffer();
        	    for(Shape s : this.getShapes()) {
        	    	show.append(this.showShape(s));
        	    	show.append("\n");
        	    }
        	    System.out.println(show);
        	    break;
        	case "exit":
        		command = new CommandExit();
        		((CommandExit)command).execute();
        		break;
        	
        	case "move":
                 shape = findShape(text[1].toLowerCase());
                 double x1 = Double.parseDouble(text[2]);
              	 double y1 = Double.parseDouble(text[3]);
                 command = this.moveShape(shape,x1,y1);
                 ((CmdMove)command).execute();
                 break;
            
        	case "create":
        		nextCmd = text[1].toLowerCase();        		
        		switch(nextCmd) {
        		case "cercle":
        			String name = text[2].toLowerCase();
        			int grid = Integer.parseInt(text[3]);
              	  	double r = Double.parseDouble(text[4]);
              	  	double centerX = Double.parseDouble(text[5]);
              	  	double centerY = Double.parseDouble(text[6]);
              	  	Point p = new Point(centerX, centerY);
              	  	
              	  	command = new CmdCreateCircle(name,p,r,grid);
                	@SuppressWarnings("unchecked") CmdCreate<Cercle> cmdCreate2 = (CmdCreate<Cercle>)command;
					shape = cmdCreate2.execute();
					
					shapes.add(shape);
        			break;
        			
        		case "carre":
        			break;
        		
        		case "rectangle":
        			break;
        		
        		case "triangle":
        			break;
        		}
        		default:
        			break;
        }

    	return null;
    }
    
    
    public Shape findShape(String nameId) {
        for(Shape s: shapes) {
          if(s.getName().contentEquals(nameId)) {
            return s;
          }
        }
        return null;
      }

    
    
    
    
    
    
    
    
    /**
     * Interpreteur de l'affichage
     * @param shape
     * @return
     */
    public String showShape(Shape shape) {
	    
    	if(shape instanceof Carre) {
    		return ((Carre)shape).display();
    	}

    	if(shape instanceof Cercle) {
    		return ((Cercle)shape).display();
    	}

    	if(shape instanceof Rectangle) {
    		 return ((Rectangle)shape).display();
    	}

    	if(shape instanceof Triangle) {
    		 return ((Triangle)shape).display();
    	}

    	if(shape instanceof ShapesGroup) {
    		 return ((ShapesGroup)shape).display();
    	}
    		 return null;	
    	}
    /**
     * Interpreuteur du deplacements
     * @param shape
     * @param x
     * @param y
     * @return
     */
    public Command moveShape(Shape shape,double x,double y) {
        if(shape instanceof Carre) {
          return new CmdMoveSquare(((Carre)shape),x,y);
        }
        if(shape instanceof Triangle) {
            return new CmdMoveTriangle(((Triangle)shape),x,y);
        }
        if(shape instanceof Rectangle) {
            return new CmdMoveRectangle(((Rectangle)shape),x,y);
        }
        if(shape instanceof Cercle) {
            return new CmdMoveCircle(((Cercle)shape),x,y);
        }
        if(shape instanceof ShapesGroup) {
            return new CmdMoveGroup(((ShapesGroup)shape),x,y);
        }
        return null;	
      }
    /**
     * users shapes getter
     * @return
     */
	public List<Shape> getShapes() {
		return shapes;
	}
	/**
	 * users shape setter
	 * @param shapes
	 */
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
}
