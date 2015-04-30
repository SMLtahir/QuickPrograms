package DynamicProgramming;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * @author Tahir
 *
 */
public class MaxProductSubarray {

	private static final int[] INPUT = {2,3,-2,4};
	public static void main(String[] args) {

		System.out.println("Maximum Product: "+ maxProduct(INPUT));

	}
	
	public static int maxProduct(int[] nums) {
		
		// Trivial case
		if(nums.length == 0) { return 0;}
		
		int maxPrev = nums[0], minPrev = nums[0];
		int maxSoFar = nums[0];
		int currMax, currMin;
		
		for(int i = 1; i< nums.length; i++) {
			currMax = Math.max(Math.max(maxPrev*nums[i], minPrev*nums[i]), nums[i]);
			currMin = Math.min(Math.min(maxPrev*nums[i], minPrev*nums[i]), nums[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
			maxPrev = currMax;
			minPrev = currMin;
		}
		return maxSoFar;
	}

}
