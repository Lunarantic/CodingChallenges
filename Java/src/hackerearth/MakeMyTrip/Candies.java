import java.util.Scanner;

/*
 * HackerEarth for MakeMyTrip
 * Check whether a continous substring of length x can made a palindrome string
 * return size y of length of palindrome for minimum or -1 if not
 * Input:
 * babammm
 * 2
 * 2
 * 5
 * Output:
 * 2 -- "mm"
 * 5 -- "bamab"
 */

public class Candies {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ips = s.nextLine();
		String line = s.nextLine();
	    int cases = Integer.parseInt(line);
	     
	    for (int i = 0; i < cases; i++) {
	    	 int size = Integer.parseInt(s.nextLine());
	    	 
	    	 boolean status = false;
	    	 
	    	 for (int j = 0; !status && ips.length() > j+size; j++) {
	    		 int count[] = new int[26];
	    		 
	    		 for (int k = 0; k < size; k++)
	    			 count[ips.charAt(j+k) - 97]++;
	    		 
	    		 if (size % 2 == 0) {
	    			 boolean st = true;
	    			 for (Integer l : count) {
	    				 st = l % 2 == 0;
	    				 if (!st) {
	    					 break;
	    				 }
	    			 }
	    			 status = st;
	    		 } else {
	    			 boolean a = true;
	    			 boolean st = true;
	    			 for (Integer l : count) {
	    				 st = l % 2 == 0;
	    				 if (!st) {
	    					 if (!a) {
	    						 a = true;
	    						 break;
	    					 }
	    					 a = false;
	    					 st = true;
	    				 }
	    			 }
	    			 status = st && !a;
	    		 }
	    	 }
	    	 
	    	 if (status) {
	    		 System.out.println(size);
	    	 } else {
	    		 System.out.println("-1");
	    	 }
	    }
	    
	    s.close();
	}
}
