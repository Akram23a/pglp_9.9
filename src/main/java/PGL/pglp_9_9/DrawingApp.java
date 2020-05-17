package PGL.pglp_9_9;

import java.util.Scanner;

/**
 * 
 * @author Akram
 *
 */
public class DrawingApp {

	  private static Scanner sc;

	public static void main(String[] args) {
			/*  
			 * exit
			 * create-cercle-nom-rayon-centreX-centreY
			 * showall
			 * 
			 * 
			 * 
			 */
		    DrawingTui D = new DrawingTui();
		    System.out.println("Started");
			sc = new Scanner(System.in, "UTF-8");
			String drawing ="";
			while (true) {
			  if (sc.hasNext()) {
				drawing = sc.next();
			    D.nextCommand(drawing);
			  }
			}

		}

}
