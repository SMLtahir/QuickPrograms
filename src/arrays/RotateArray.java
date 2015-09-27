package arrays;

import java.util.LinkedList;

public class RotateArray {

	private static final int[] INPUT = {1,2,3,4,5,6,7};
	private static final int K = 3;
	public static void main(String[] args) {

		rotate1(INPUT, K);
		System.out.println();
	}
	
	/**
Using a queue with O(k) space
	 * @param input
	 * @param k
	 * @return
	 */
	public static int[] rotate(int[] input, int k) {
		
        // Trivial cases
		if(k == 0) { return input;}
		int len = input.length;
		while(k > len) {
		    k = k- len;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// Put all elements to be shifted in front at the start of the queue
		while(k != 0) {
			queue.add(input[len- k]);
			k--;
		}
		
		int i = 0;
		while(i != len) {
			queue.add(input[i]);
			input[i] = queue.remove();
			i++;
		}
		return input;
	}
	
	/**
O(1) space and O(1) time
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] rotate1(int[] nums, int k) {
	    if (nums.length == 0) return nums;
	    int n = nums.length;
	    while ((k %= n) > 0 && n > 1) {
	        int range = n - k;
	        for (int i = 1; i <= range; i++) {
	            int val = nums[n - i];
	            nums[n - i] = nums[n - i - k];
	            nums[n - i - k] = val;
	        }
	        n = k;
	        k = n - (range % k);
	    }
	    return nums;
	}

}
