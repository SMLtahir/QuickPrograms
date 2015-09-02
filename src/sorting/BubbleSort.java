package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        System.out.println("Before sorting: \n"+ Arrays.toString(input));
        doBubbleSort(input);
        System.out.println("After sorting by bubbleSort: \n"+ Arrays.toString(input));
    }
    
    // logic to sort the elements
    public static void doBubbleSort(int array[]) {
        int n = array.length;
        for (int m = 0; m <= array.length; m++) {
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i+1]) {
                    swapNumbers(i, i+1, array);
                }
            }
        }
    }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
