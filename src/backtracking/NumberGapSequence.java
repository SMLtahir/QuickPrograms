package backtracking;

import java.util.Arrays;

/**
Question - We are interested in building a special type of sequence. for a given number N, we want to arrange the numbers {1,1,2,2,3,3,... N,N} such that they have the following property. 
For each number / in (1,N) there should be exactly / numbers between the first appearance of the number and the second appearance. Below example would clarify further. 

Input: 
A Single number N for which we want to produce the sequence. 

Output: 
A space separated list of sequence or NA if there is no possible sequence.

Example Input: 
3 

Example Output: 
2 3 1 2 1 3 

Explanation : There is 1 number between 1s(2). There are 2 numbers between the 2's(3 1 ). There are 3 numbers between the 3's(1 2 1 ).
 * @author Tahir
 *
 */
public class NumberGapSequence {

	private static final int INPUT = 4;
	public static void main(String[] args) {

		int[] output = getNumberGapSequence(INPUT); 
		if(output == null) { 
			System.out.println("NA");
			return;
		}
		System.out.print(Arrays.toString(output));
	}
	
	public static int[] getNumberGapSequence(int n){
	    int[] sol = new int[2*n];
	    if (checkGaps(sol, n)) return sol;
	    return null;
	}

	public static boolean checkGaps(int[] sol, int gap){
	    if (gap == 0) return true;
	    for (int i = sol.length-1; i - gap > 0 ; i--) {
	      if (sol[i] == 0 && sol[i-gap-1] == 0) {
	        sol[i] = gap;
	        sol[i-gap-1] = gap;
	        if (checkGaps(sol, gap-1)) return true;
	        else {
	          sol[i] = 0;
	          sol[i-gap-1] = 0;
	        }
	      }
	    }
	    return false;
	}

}
