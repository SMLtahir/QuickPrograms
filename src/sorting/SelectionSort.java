package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting: \n"+ Arrays.toString(input));
        doSelectionSort(input);
        System.out.println("After sorting by selectionSort: \n"+ Arrays.toString(input));
	}

	public static void doSelectionSort(int[] array) {
		
		int min;
		for(int i=0; i< array.length-1; i++) {
			min = i;
			for(int j=i+1; j< array.length; j++) {
				if(array[j] < array[min]) { min = j;}
			}
			if(min != i) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
}
