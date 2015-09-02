package arrays;

import java.util.Arrays;

/**
 * Given an array of only 1s and 0s, sort the array in place and in one pass.
 * @author Tahir
 *
 */
public class SortZeroOneArray {

	private static int[] INPUT = {0,0,0,1,1,0,1,1,0,0,1,1,1,1,0,0,1,0,1,0,1,0,0,0,1,1,1,1};
	public static void main(String[] args) {

		System.out.println("Original Array: "+ Arrays.toString(INPUT)+ "\nSorted Array: "+ Arrays.toString(sortArray2(INPUT)));

	}

	/**
	 * Sort the array such that all 0s come first and then all 1s.
	 */
	private static int[] sortArray(int[] A) {
		for(int i = 0, j = A.length -1; i< A.length && j > i; i++) {
			if(A[i] == 1) {
				while(A[j] == 1 && j> i) { j--;}
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}
	
	/**
	 * Sort the array such that all 0s fall in even places and all 1s in odd places.
	 * If suppose, no. of 0s exceeds no. of 1s or vice versa then keep them untouched.
	 */
	private static int[] sortArray2(int[] A) {
		int len = A.length;
		for(int i=0, j=1; i< len && j < len; i+=2) {
			if(A[i] == 1) {
				while(j< len && A[j] == 1) { j+=2;}
				if(j < len) {
					int temp = A[j];
					A[j] = A[i];
					A[i] = temp;
				}
			}
		}
		return A;
	}
}
