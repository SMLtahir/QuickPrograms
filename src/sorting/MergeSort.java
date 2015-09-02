package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting: \n"+ Arrays.toString(input));
        doMergeSort(input, 0, input.length - 1);
        System.out.println("After sorting by mergeSort: \n"+ Arrays.toString(input));

	}
	
	public static void doMergeSort(int[] array, int lowIndex, int highIndex) {
		if(lowIndex == highIndex) { return;}
		int mid = (lowIndex + highIndex)/2;
		doMergeSort(array, lowIndex, mid);
		doMergeSort(array, mid+1, highIndex);
		mergeParts(array, lowIndex, mid, highIndex);
	}
	
	private static void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
		int[] tempMergArr = new int[array.length];
		for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i++];
                i++;
            } else {
                array[k] = tempMergArr[j++];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
	}

}
