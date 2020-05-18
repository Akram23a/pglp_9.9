package PGL.pglp_9_9;

import java.util.Scanner;

/**
 * 
 * @author Akram
 *
 */
public class DrawingApp {
		/**
		 * scanner
		 */
	  private static Scanner sc;
	  /**
	   * main
	   * @param args
	   */
	public static void main(String[] args) {
			/* commandes pour utilisation
			 * exit
			 * create-cercle-nom-id-rayon-centreX-centreY
			 * showall pour  tout afficher
			 * create-carre-nom-id-length-bottomleftX-bottomleftY
			 * 
			 * exemple:
			 * create-carre-a-2-5-3-2
			 * create-cercle-b-1-5-2-3
			 * create-rectangle-c-4-6-5-1-2
			 * create-triangle-d-1-2-3-1-5-2-5
			 * showall to show everything
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

