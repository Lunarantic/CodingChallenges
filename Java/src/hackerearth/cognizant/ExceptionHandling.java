package cognizant;

import java.util.Scanner;
import java.lang.Exception;

/*
 * Exception Handling
 * You are given a piece of Java code.
 * You have to complete the code by writing down the handlers for exceptions thrown by the code.
 * The exceptions the code may throw along with the handler message are listed below:
 * 
 * Division by zero: Print "Invalid division".
 * String parsed to a numeric variable : Print "Format mismatch".
 * Accessing an invalid index in string : Print "Index is invalid".
 * Accessing an invalid index in array : Print "Array index is invalid".
 * MyException : This is a user defined Exception which you need to create. It takes a parameter param.
 * When an exception of this class is encountered, the handler should print "MyException[param]", here param is the parameter passed to the exception class.
 * 
 * Exceptions other than mentioned above : Any other exception except the above ones fall in this category. Print "Exception encountered".
 * 
 * Finally, after the exception is handled, print "Exception Handling Completed".
 * 
 * Example: For an exception of MyException class if the parameter value is 5, the message will look like MyException[5].
 * 
 * Input Format:
 * The code handles all the input itself.
 * 
 * Output Format:
 * If any exception is encountered in the code, print the respective handler code.
 * The last line of output should be "Exception Handling Completed".
 * 
 * Sample Input
 * 10
 * 10
 * 9
 * 8
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 * exceptionhandlingtime
 * 
 * Sample Output
 * a
 * MyException[117]
 * Exception Handling Completed
 * 
 * Explanation
 * An exception is thrown of MyException type.
 * 
 * First line of output is the 
 * 10th character of input string.
 * Second line of output is the handler message: "MyException[117]". Here 117 is the parameter value.
 * Last line of output is "Exception Handling Completed".
 * 
 * If the string was "exception" instead of "exceptionhandlingtime", the output would look like:
 * 
 * Index is invalid
 * Exception Handling Completed
 */

class ExceptionHandling
{
	static void solve(int arr[]) throws Exception, MyException
	{
		int ans=0;
		
		for(int i=0;i<10;i++){
			for(int j=i+1;j<10;j++){
				if (arr[j] == 0)
					throw new MyException(true);
				ans+=arr[i]/arr[j];
			}}
		throw new MyException(ans);
	}
	
	public static void main(String args[])
	{
		try
		{
			Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			int []arr= new int[n];
			in.nextLine();
			
			for(int i=0;i<10;i++)
				arr[i]=Integer.parseInt(in.nextLine());
			
			String s=in.nextLine();
			in.close();
			try {
				System.out.println(s.charAt(10));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Index is invalid");
			}
			solve(arr);
		} catch (MyException e) {
			System.out.println(e.toString());
		} catch (NumberFormatException e) {
			System.out.println("Format mismatch");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Array index is invalid");
		} catch (Exception e) {
			System.out.println("Exception encountered");
		}
		System.out.println("Exception Handling Completed");
	}
}

class MyException extends Throwable{

	private static final long serialVersionUID = 1L;
	int a;
	boolean s=false;
	
	public MyException(boolean t) {
		s = t;
	}

	public MyException(int ans) {
		a = ans;
	}
     @Override
    public String toString() {
    	 if (s)
    		return "Invalid division";
    	return ("MyException["+a+"]");
    }
}