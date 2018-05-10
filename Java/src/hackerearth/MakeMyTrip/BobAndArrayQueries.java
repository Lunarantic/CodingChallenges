import java.util.Scanner;

/*
 * HackerEarth for MakeMyTrip
 * 
 * Input:
 * Line 1 > N M
 * -- Create an array A with all value 0 of size by number mentioned by N
 * -- M defines number cases of to follow
 * 
 * There are three cases each are operations:
 * 1 P -- apply 2 * ( A[P] + 1 )
 * 2 P -- apply Floor(A[P] / 2)
 * 3 P Q -- Print number of bits are 1 for all numbers inclusively between A[P] and A[Q]
 * 
 */

public class BobAndArrayQueries {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		String[] info = line.split(" ");
		
		long arr[] = new long[Integer.parseInt(info[0])];
		
	    int cases = Integer.parseInt(info[1]);
	    int p,q, bits;
	     
	    for (int i = 0; i < cases; ++i) {
	    	line = s.nextLine();
	    	info = line.split(" ");
	    	
	    	switch (info[0]) {
				case "1":
					p = Integer.parseInt(info[1]) - 1;
					arr[p] = 2 * arr[p] + 1;
					break;
				
				case "2":
					p = Integer.parseInt(info[1]) - 1;
					arr[p] = (long) Math.floor(arr[p] / 2.0);				
					break;
									
				case "3":
					bits = 0;
					for (p = Integer.parseInt(info[1]) - 1, q = Integer.parseInt(info[2]) - 1; p <= q; ++p) {
						bits += bitCount(arr[p]);
					}
					System.out.println(bits);
					break;

				default:
					break;
			}
	    }
	    
	    s.close();
	}
	
	public static long bitCount(long i) {
        i = i - ((i >>> 1) & 0x5555555555555555L);
        i = (i & 0x3333333333333333L) + ((i >>> 2) & 0x3333333333333333L);
        return (((i + (i >> 4)) & 0x0f0f0f0f0f0f0f0fL) * 0x0101010101010101L) >> 56;
     }
}
