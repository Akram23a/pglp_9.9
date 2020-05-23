package PGL.pglp_9_9;

public class CmdSave implements CmdMove{

	  private ShapesGroup sGroup;
	  private ShapesGroupJDBC sGroupBdd;

	  private Triangle t;
	  private TriangleJDBC tj;

	  private Carre c;
	  private CarreJDBC cj;

	  private Cercle l;
	  private CercleJDBC lj;
	  
	  
	  private Rectangle r;
	  private RectangleJDBC rj;

	  private int which;
	  
	  
	  public CmdSave(final ShapesGroup attribute) {
		  	 this.sGroup = attribute;
		  	 sGroupBdd = new ShapesGroupJDBC();
		  	 which = 1;
	  	  }
	  
	  public CmdSave(final Carre attribute) {
		    this.c = attribute;
		    cj = new CarreJDBC();
		    which = 2;
		  }
	  
	  public CmdSave(final Triangle attribute) {
		    this.t = attribute;
		    tj = new TriangleJDBC();
		    which = 3;
		  }
	  public CmdSave(final Cercle attribute) {
		    this.l = attribute;
		    lj = new CercleJDBC();
		    which = 4;
		    
		  }
	  public CmdSave(final Rectangle attribute) {
		    this.r = attribute;
		    rj = new RectangleJDBC();
		    which = 5;
		  }
	  
	  
	  
	  @Override
	  public void execute() {
		  switch(which) {
		    case 1:
		  		  sGroupBdd.create(sGroup);
		  		  break;
		  	case 2:
		  		  cj.create(c);
		  		  break;
		  	case 3:
		  		  tj.create(t);
		  		  break;	  
		  	case 4:
		  		  lj.create(l);
		  		  break;
		  	case 5:
		  		  rj.create(r);
		  		  break;	  
		  }
	  }
}
