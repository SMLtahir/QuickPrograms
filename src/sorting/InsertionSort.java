package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting: \n"+ Arrays.toString(input));
        doInsertionSort(input);
        System.out.println("After sorting by insertionSort: \n"+ Arrays.toString(input));
	}

	public static void doInsertionSort(int[] array) {
		
		int temp;
		for(int i=1; i< array.length; i++) {
			for(int j=i; j > 0; j--) {
				if(array[j] < array[j-1]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
}
