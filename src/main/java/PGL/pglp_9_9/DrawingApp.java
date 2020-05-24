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
	   * run
	   */
		public void run() {

		System.out.println("-------- Manual ---------");
		
		System.out.println("-------- Draw Circle ---------");
		System.out.println("create-cercle-nom-id-rayon-centreX-centreY");
		System.out.println("example : create-cercle-b-1-5-2-3");
		System.out.println("\n");

		System.out.println("-------- Draw Triangle ---------");
		System.out.println("create-triangle-nom-groupid-x1-y1-x2-y2-x3-y3");
		System.out.println("example : create-triangle-d-1-2-3-1-5-2-5");
		System.out.println("\n");

		System.out.println("-------- Draw Rectanlge ---------");
		System.out.println("create-carre-nom-groupid-length-width-bottomleftX-bottomleftY");
		System.out.println("example : create-rectangle-c-4-6-5-1-2");
		System.out.println("\n");

		System.out.println("-------- Draw Square ---------");
		System.out.println("create-carre-a-2-5-3-2");
		System.out.println("example : create-rectangle-c-4-6-5-1-2");
		System.out.println("\n");

		System.out.println("-------- find Shape ---------");
		System.out.println("find-name-type");
		System.out.println("example : find-t2-triangle");
		System.out.println("example : find-c2-carre");
		System.out.println("\n");
		
		System.out.println("-------- Other commands ---------");
		System.out.println("exit : to exit software");
		System.out.println("save : to save all  ------- ");
		System.out.println("showall : to show all");
		System.out.println("\n");

	    DrawingTui D = new DrawingTui();
	    System.out.println("Started");
		sc = new Scanner(System.in, "UTF-8");
		String drawing = "";
		while (true) {
		  if (sc.hasNext()) {
			drawing = sc.next();
		    D.nextCommand(drawing);
		  }
		}

	}
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
	       DrawingApp dApp = new DrawingApp();
	       dApp.run();
		}
}

