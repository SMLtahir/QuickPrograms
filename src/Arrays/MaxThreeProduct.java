package arrays;

import java.util.Arrays;

public class MaxThreeProduct {

	private static final int[] INPUT = {-6,4,3,8,7,-79,-79,-3,0,-2,3,0,9,8,-8,-9,4};
	public static void main(String[] args) {

		System.out.println("Max Three Product is: "+ getMaxThreeProduct(INPUT));

	}
	private static int getMaxThreeProduct(int[] array) {

		// Trivial cases
		if(array.length < 3) {
			int result = 1;
			for(int i = 0; i< array.length; i++) {
				result *= array[i];
			}
			return result;
		}
		
		Arrays.sort(array);
		
		long maxA = (long) array[array.length-1]*(long) array[array.length-2]*(long) array[array.length-3];
		System.out.println("3 biggest numbers: "+ array[array.length-1]+ ", "+ array[array.length-2]+ ", "+ array[array.length-3]);
		
		long maxB = (long) array[array.length-1]*(long) array[0]*(long) array[1];
		System.out.println("Biggest number, 2 smallest numbers: "+ array[array.length-1]+ ", "+ array[0]+ ", "+ array[1]);
		
		if(maxA > Integer.MAX_VALUE || maxB > Integer.MAX_VALUE) { return -1;}
		
		return (int) Math.max(maxA, maxB);
	}
	
	

}
