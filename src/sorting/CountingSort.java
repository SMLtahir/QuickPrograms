package sorting;

import java.util.Arrays;

/**
 * Given a list of numbers and the upper and lower bounds, sort them in LESS than O(nlog(n)) time.
 * The method given below sorts in linear time and space
 * @author Tahir
 *
 */
public class CountingSort {

	private static final int[] INPUT = {20,16,24,15,26,12,17,17,21,23,19,14,28};
	public static void main(String[] args) {

		System.out.println(Arrays.toString(countingSort(INPUT, 12, 28)));

	}
	
	// Counting Sort
	public static int[] countingSort(int[] arr, int min, int max) {
		int[] counts = new int[max-min+1];
		int[] result = new int[arr.length];
		
		// Store counts of each number
		for(int i=0; i< arr.length; i++) {
			int val = arr[i];
			counts[val-min]++;
		}
		
		// Update counts array to store future positions of the numbers
		for(int i=1;i< counts.length;i++) {
			counts[i] += counts[i-1];
		}
		
		// Run through the original array and put each number in its previously determined position
		for(int i=0; i< arr.length; i++) {
			int val = arr[i];
			int pos = counts[val-min]-1;
			result[pos] = val;
			counts[val-min]--;
		}
		
		return result;
	}

}
