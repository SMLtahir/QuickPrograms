package DynamicProgramming;

/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author Tahir
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
        long prevNo = 0;
        long prevYes = 0;
        
        for(int i : nums) {
            // Take from previous step
            long temp = prevNo;
            // Prepare for next step
            prevNo = Math.max(prevNo, prevYes);
            prevYes = i + temp;
            
            // Check for overflow
            if(Math.max(prevNo, prevYes) > Integer.MAX_VALUE)
                return 0;
        }
        return (int) Math.max(prevNo, prevYes);
    }
	
}
