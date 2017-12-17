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
        String str = s.nextLine();
        String qString = s.nextLine();
        List<String> qList = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(qString); i++) {
        	qList.add(s.nextLine());
        }
        String mString = s.nextLine();
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(mString); i++) {
        	mList.add(s.nextLine());
        }
        s.close();
        for (String q: qList) {
        	String[] split = q.split(" ");
        	str = str.substring(0, Integer.parseInt(split[0])-1) + split[1] + str.substring(Integer.parseInt(split[0]));
        }
        System.out.println(str);
        String fin = str;
        for (String m: mList) {
        	String[] split = m.split(" ");
        	fin = fin.substring(0, Integer.parseInt(split[0])-1) + (new StringBuilder(fin.substring(Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]))).reverse().toString()) + fin.substring(Integer.parseInt(split[1]));
        }
        System.out.println(fin);
        int icnt = 0;
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(i) == fin.charAt(i)) {
        		++icnt;
        	}
        }
        System.out.println(icnt);
    }
}