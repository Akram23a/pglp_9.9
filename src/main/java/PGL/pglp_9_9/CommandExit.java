package PGL.pglp_9_9;
/**
 * 
 * @author Akram
 *
 */
public class CommandExit implements Command{

	  public void execute() {
	    Runtime.getRuntime().exit(0);	
	  }
}