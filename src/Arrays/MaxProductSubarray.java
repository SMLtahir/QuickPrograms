package arrays;

/**
 * Find the maximum valued contiguous subarray from the given array.
 * @author Tahir
 *
 */
public class MaxProductSubarray {

	public static void main(String[] args) {

		int arr[] = {1, -2, -3, 0, 7, -8, -2, 9, 8, 0, 4, 3};
	    System.out.println("Maximum Sub array product is: "+ maxSubarrayProduct(arr));

	}

	// This method assumes however that the maximum will be >= 1
	// Also apply protection against Integer overflows that can occur due to multiplication.
	public static int maxSubarrayProduct(int arr[]) {
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSoFar = 1;
		
		for(int i =0; i< arr.length; i++) {
			if(arr[i] > 0) {
				maxEndingHere = Math.max(arr[i]*maxEndingHere, 1);
				minEndingHere = Math.min(arr[i]*minEndingHere, 1);
			} else if(arr[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(arr[i]*minEndingHere, 1);
				minEndingHere = arr[i]*temp;
			}
			
			if(maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
}
