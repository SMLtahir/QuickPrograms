package Recursion;

public class FIbonacci {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(n+ "th Fibonacci number: "+ getFibonacciSequence(n));

	}
	
	public static int getFibonacciSequence(int n)	{
		if(n > 2)	{
			return getFibonacciSequence(n-1)+ getFibonacciSequence(n-2);
		}
		else if(n == 1 || n == 2) {
			return 1;
		}
		else	{
			//This should never occur
			return 0;
		}
		
		
	}

}
