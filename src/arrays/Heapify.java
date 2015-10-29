package arrays;

import java.util.Arrays;

/**
 * MinHeapify/ MaxHeapify an array.
 * ExtractMin/ ExtractMax from heapified array.
 * @author Tahir
 *
 */
public class Heapify {

	static int ARR_LEN;
	public static void main(String[] args) {

		int[] input = {5,12,64,1,37,90,91,97};
		ARR_LEN = input.length;
		System.out.println(Arrays.toString(input));
		maxHeapify(input);
		extractMax(input);
		input = Arrays.copyOfRange(input, 0, ARR_LEN);
		System.out.println(Arrays.toString(input));
		
	}
	
	private static void minHeapify(int[] arr) {
		for(int i=ARR_LEN/2;i>=0;i--) {
			minHeapify(arr, i);
		}
	}
	
	private static void minHeapify(int[] arr, int i) {
		// This is because the nodes are inserted in the heap level by level, left to right
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min = i;
		
		if(left < ARR_LEN && arr[left] < arr[min])	{
			min = left;
		}
		
		if(right < ARR_LEN && arr[right] < arr[min])	{
			min = right;
		}
		
		if(min != i) {
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			minHeapify(arr, min);
		}
	}
	
	private static int extractMin(int[] arr) {
		if(ARR_LEN == 0) {
			System.out.println("Error! No elements in heap.");
			return -1;
		} else {
			int min = arr[0];
			arr[0] = arr[ARR_LEN-1];	// Take last element and put at root position
			ARR_LEN--;		// Shorten the array
			minHeapify(arr, 0);
			return min;
		}
	}
	
	private static void maxHeapify(int[] arr) {
		for(int i=ARR_LEN/2;i>=0;i--) {
			maxHeapify(arr, i);
		}
	}

	private static void maxHeapify(int[] arr, int i) {
		// This works because of how nodes are arranged in a heap.
		// The tree has a branching factor of 2 for all nodes.
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = i;
		
		if(left < ARR_LEN && arr[left] > arr[max])
			max = left;
		
		if(right < ARR_LEN && arr[right] > arr[max])
			max = right;
		
		if(max != i) {
			// Swap
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			maxHeapify(arr, max);
		}
	}
	
	private static int extractMax(int[] arr) {
		if(ARR_LEN == 0) {
			System.out.println("Error! No elements in heap.");
			return -1;
		} else {
			int max = arr[0];
			arr[0] = arr[ARR_LEN-1];	// Take last element and put at root position
			ARR_LEN--;		// Shorten the array
			maxHeapify(arr, 0);
			return max;
		}
	}
}
