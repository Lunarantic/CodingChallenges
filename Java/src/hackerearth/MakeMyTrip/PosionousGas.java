import java.util.Scanner;

/*
 * Posionous Gas is where you will encounter enemies in multiple slots
 * 
 * Input:
 * Line 1: Number of turns
 * Turn i: line 1 >> Number of enemies
 *         line 2 >> Strength of enemies
 * 
 * If they their maximum strength is even number they can be halved
 * it can be repeated multiple times if its total is still even
 * Output:
 * For every turn tell whether they can be brought to zero
 * 
 */

public class PosionousGas {
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	     String line = s.nextLine();
	     int cases = Integer.parseInt(line);
	     long l;
	     
	     for (int i = 0; i < cases; i++) {
	    	 line = s.nextLine();
	    	 int len = Integer.parseInt(line);
	    	 line = s.nextLine();
	    	 String[] enemies = line.split(" ");
	    	 
	    	 boolean status = enemies.length == len;
	    	 
	    	 Long total = 0L;
	    	 if (status) {
		    	 for (String enemy: enemies) {
		    		 l = Long.parseLong(enemy);
		    		 if (l > 0)
		    			 total += l;
		    	 }
		    	 status = total > 1;
	    	 }
	    	 
	    	 if (status) {
	    		 status = total % 2 == 0;
	    	 }
	    	 
	    	 if (status) {
	    		 for (long j = 3, t = 4; status && total > t; j++) {
	    			 status = total % t == 0;
	    			 t = (long) Math.pow(2.0, j);
	    		 }
	    	 }
	    	 
	    	 if (!status) {
	    		 status = total == 1;
	    	 }
	    	 
	    	 if (status) {
	    		System.out.println("Yes");
	    	 } else {
				System.out.println("No");
			}
	     }
	     
	     s.close();
	}
}
