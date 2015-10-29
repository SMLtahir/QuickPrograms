package arrays;

import java.util.Arrays;

/**
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array 
 * obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 * 
 * Explanation of the approach used here given here:
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * @author Tahir
 *
 */
public class FindMedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int[] INPUT1 = {1, 12, 15, 26, 38, 50};
		int[] INPUT2 = {2, 13, 17, 30, 45, 55};
		int n = INPUT1.length;
		System.out.println("Median: "+ findMedian(INPUT1, INPUT2, n));
	}
	
	public static float findMedian(int[] a, int[] b, int n) {
		// Trivial case
		if(n == 0) { return -1.0f;}
		if(n == 1) { return (a[0]+ b[0])/2;}
		if(n == 2) {
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1]) )/2;
		}
		float m1 = median(a, n);
		float m2 = median(b, n);
		if(m1 == m2) { return m1;}
		// Remember: If even, e.g n=6, next iteration should have 3 elements
		// Remember: If odd, e.g n=7, next iteration should have 4 elements
		if(m1 > m2) { 
			int[] a1 = (n%2==0) ? Arrays.copyOfRange(a, 0, a.length/2) : Arrays.copyOfRange(a, 0, a.length/2+1);
			int[] b1 = Arrays.copyOfRange(b, b.length/2, b.length);
			return findMedian(a1, b1, a1.length);
		} else {
			int[] a1 = Arrays.copyOfRange(a, a.length/2, a.length);
			int[] b1 = (n%2==0) ? Arrays.copyOfRange(b, 0, b.length/2) : Arrays.copyOfRange(b, 0, b.length/2+1);
			return findMedian(a1, b1, a1.length);
		}
	}
	
	public static float median(int[] arr, int len) {
		if(arr.length % 2 == 0) {
			return ((float)arr[len/2]+(float)arr[len/2-1])/2;
		} else {
			return arr[len/2];
		}
	}
}
