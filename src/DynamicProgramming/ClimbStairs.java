package DynamicProgramming;


/**
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Tahir
 *
 */

public class ClimbStairs {

	private static final int NR_OF_STAIRS = 4;
	public static void main(String[] args) {

		System.out.println("Nr of ways in which "+ NR_OF_STAIRS+ " can be climbed: "+ climbStairs(NR_OF_STAIRS));

	}
	
	public static int climbStairs(int n) {
        // This is Fibonacci sequence starting with 1,2 instead of 1,1. See Pattern below:
		// NrSteps -> Solution
        // <=0 -> 0
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 4 -> 5
        // 5 -> 8
        // 6 -> 13
        
        // Base cases
        if(n <= 0) { return 0;}
        if(n == 1) { return 1;}
        if(n == 2) { return 2;}
        
        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        
        for(int i=3; i<= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        
        return steps[n];
    }

}
