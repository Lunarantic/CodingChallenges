package cognizant;

import java.util.*;

/*
 * School Prayer
 * You are given the task to manage students coming to morning prayer in the school.
 * Students having roll numbers 1to N are coming in an arbitrary manner and you need
 * to make them stand in a queue such that queue is always in ascending order of roll number.
 * In order to achieve this task, for every incoming student you need to find a student
 * in the queue he will be standing behind (or in front of the queue if no such student is present in the queue ).
 * 
 * For example, if currently, the queue is 1 2 4 and student with roll number 3 arrives, you will have to locate 2 and make 3 stand behind 2.
 * For each incoming student, find the roll number of student he will be standing behind ( -1 in case no student with roll less than current exists).
 * 
 * Input Format:
 * The first line of input will contain T
 * T, number of test cases.
 * The first line of each test case will contain N
 * N, the number of students.
 * The second line of each test case will have N
 * N distinct space separated numbers denoting the order in which each student is coming.
 * 
 * Output Format:
 * Output a single number which is the sum of N
 * N numbers where ith
 * ith number denotes answer for ith
 * ith incoming student.
 * Answer for each test case should come in a new line.
 * 
 * Input Constraints:
 * 1≤T≤10
 * 1≤N≤10^5
 * 1≤RollNumber≤N
 * 
 * Sample Input
 * 2
 * 4
 * 2 1 4 3
 * 6
 * 4 6 1 2 3 5
 * 
 * Sample Output
 * 2
 * 9
 * 
 * Explanation
 * For the first case 
 * 1. Current queue {} , 2 will stand at front so -1. 
 * 2. Current queue {2}, 1 will stand at front so -1. 
 * 3. Current queue {1,2} 4 will stand behind 2 so 2. 
 * 4. Current queue {1,2,4} 3 will stand behind 3 so 2. 
 * so sum is -1 -1 + 2 + 2 = 2
 */

class SchoolPrayer {
    public static void main(String args[] ) throws Exception {
    	
    	Scanner s = new Scanner(System.in);
        String run = s.nextLine();
        List<Integer> outs = new LinkedList<>();
        for (int i = 0; i < Integer.parseInt(run); i++) {
        	s.nextLine();
        	String inc = s.nextLine();
        	List<Integer> studs = new LinkedList<>();
        	int c = 0;
        	for (String split : inc.split(" ")) {
        		int n = Integer.parseInt(split);
        		int pos = -1;
        		for (Integer pc : studs) {
        			if (n < pc) {
        				break;
        			}
        			pos++;
        		}
        		if (pos == -1){
        			c += -1;}
        		else{
        			c += studs.get(pos);}
        		studs.add(pos+1, n);
        	}
        	outs.add(c);
        }
        outs.forEach(I->{System.out.println(I);});
        s.close();
	}
}