package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting: \n"+ Arrays.toString(input));
        doQuickSort(input, 0, input.length - 1);
        System.out.println("After sorting by quickSort: \n"+ Arrays.toString(input));

	}
	
	public static void doQuickSort(int[] array, int lowerIndex, int higherIndex) {
		int pivot = array[(lowerIndex + higherIndex)/2];
		int i = lowerIndex;
		int j = higherIndex;
		while(i <= j) {
			while(array[i] < pivot) {
				i++;
			}
			while(array[j] > pivot) {
				j--;
			}
			if(i <= j) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
				j--;
			}
			
		}
		if(lowerIndex < j) { doQuickSort(array, lowerIndex, j);}
		if(higherIndex > i) { doQuickSort(array, i, higherIndex);}
	}

}
