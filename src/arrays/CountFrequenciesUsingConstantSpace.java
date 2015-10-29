package arrays;

import java.util.Arrays;

/**
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be 
 * repeated multiple times and some other elements can be absent from the array. Count frequency of all 
 * elements that are present and print the missing elements.
 * @author Tahir
 *
 */
public class CountFrequenciesUsingConstantSpace {

	private static final int[] INPUT = {2,4,5,5,5};
	public static void main(String[] args) {

		countFrequencies(INPUT);
		System.out.println("Frequencies represented by negative of array: "+ Arrays.toString(INPUT));

	}
	
	public static void countFrequencies(int[] arr) {
		for(int i=0; i< arr.length;) {
			if(arr[i] <= 0) { 
				i++;
				continue;
			}
			int elementIndex = arr[i]-1;
			if(arr[elementIndex] <= 0) {
				arr[elementIndex]--;
				arr[i] = 0;
				i++;
			} else {
				arr[i] = arr[elementIndex];
				arr[elementIndex] = -1;
			}
		}
	}

}
