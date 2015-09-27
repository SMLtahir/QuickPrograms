package arrays;

import java.util.HashSet;
import java.util.Set;

public class FindNearbyDuplicate {

	private static final int[] INPUT = {3,4,2,5,6,7,4,5,2,6,7,8,3,4};
	private static final int GAP = 4;
	public static void main(String[] args) {

		System.out.println("Nearby duplicates exist: "+ containsNearbyDuplicate(INPUT, GAP));

	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}
