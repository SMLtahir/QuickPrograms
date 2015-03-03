package DynamicProgramming;

import javax.management.RuntimeErrorException;
import javax.naming.LimitExceededException;

import org.w3c.dom.ranges.RangeException;

/**
 * Generate the Nth number of a Fibonacci sequence
 * @author Tahir
 *
 */
public class Fibonacci {

	private static final int N = 30;
	
	public static void main(String[] args) {

		System.out.println("Nth fibonacci: "+ getNthFib(N));

	}
	
	public static int getNthFib(int N)	{
		
		//Trivial cases
		if(N < 0) { return -1;}
		long[] storedFibs = new long[N+1];
		if(N == 0 || N == 1) { 
			storedFibs[N] = N;
			return (int)storedFibs[N]; 
		}		
		
		storedFibs[0] = 0;
		storedFibs[1] = 1;
		
		for(int i=2; i<= N; i++) {
			storedFibs[i] = storedFibs[i-1] + storedFibs[i-2];
			if(storedFibs[i] > Integer.MAX_VALUE) { return -1;}
		}
		return (int)storedFibs[N];
	}

}
