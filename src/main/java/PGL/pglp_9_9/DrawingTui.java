package PGL.pglp_9_9;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Akram
 *
 */
public class DrawingTui {
	/**
	 * List of shapes
	 */
	private List<Shape> shapes;

	/**
	 * constructor
	 */
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
        		
        	case "save":
        		for(Shape s: shapes) {
        			if(s instanceof Carre) {
        	    		CmdSave Q = new CmdSave((Carre)s);
        	    		Q.execute();
        	    	}else if(s instanceof Cercle) {
        	    		CmdSave Q = new CmdSave((Cercle)s);
        	    		Q.execute();
        	    	}else if(s instanceof Triangle) {
        	    		CmdSave Q = new CmdSave((Triangle)s);
        	    		Q.execute();
        	    	}else if(s instanceof Rectangle) {
        	    		CmdSave Q = new CmdSave((Rectangle)s);
        	    		Q.execute();
        	    	}
        		}
                 break;
                 
        	case "load":
        	    CmdLoad Q = new CmdLoad(text[1],text[2]);
        	    shapes.add(Q.execute());
        	    System.out.println("Shape loaded");
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
        			String nameC = text[2].toLowerCase();
        			int gridC = Integer.parseInt(text[3]);
              	  	double l = Double.parseDouble(text[4]);
              	  	double blX = Double.parseDouble(text[5]);
              	  	double blY = Double.parseDouble(text[6]);
              	  	Point pC = new Point(blX, blY);
              	  	
              	  	command = new CmdCreateSquare(nameC,pC,l,gridC);
                	@SuppressWarnings("unchecked") CmdCreate<Carre> cmdCreate3 = (CmdCreate<Carre>)command;
					shape = cmdCreate3.execute();
					
					shapes.add(shape);
        			break;
        		
        		case "rectangle":
        			String nameC1 = text[2].toLowerCase();
        			int gridC1 = Integer.parseInt(text[3]);
              	  	double l1 = Double.parseDouble(text[4]);
              	  	double l2 = Double.parseDouble(text[5]);
              	  	double blX1 = Double.parseDouble(text[6]);
              	  	double blY1 = Double.parseDouble(text[7]);
              	  	Point pC1 = new Point(blX1, blY1);
              	  	
              	  	command = new CmdCreateRectangle(nameC1,gridC1,pC1,l1,l2);
                	@SuppressWarnings("unchecked") CmdCreate<Rectangle> cmdCreate4 = (CmdCreate<Rectangle>)command;
					shape = cmdCreate4.execute();
					
					shapes.add(shape);
        			break;
        		
        		case "triangle":
        			String nameT = text[2].toLowerCase();
        			
        			int gridT = Integer.parseInt(text[3]);
              	  	double p1x = Double.parseDouble(text[4]);
              	  	double p1y = Double.parseDouble(text[5]);
              	  	double p2x = Double.parseDouble(text[6]);
              	  	double p2y = Double.parseDouble(text[7]);
              	  	double p3x = Double.parseDouble(text[8]);
              	  	double p3y = Double.parseDouble(text[9]);

              	  	Point pT1 = new Point(p1x, p1y);
              	  	Point pT2 = new Point(p2x, p2y);
             	  	Point pT3 = new Point(p3x, p3y);
             	  	
              	  	command = new CmdCreateTriangle(nameT,gridT,pT1,pT2,pT3);
                	@SuppressWarnings("unchecked") CmdCreate<Triangle> cmdCreate5 = (CmdCreate<Triangle>)command;
					shape = cmdCreate5.execute();
					shapes.add(shape);
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
     * Interpreuteur des deplacements
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
