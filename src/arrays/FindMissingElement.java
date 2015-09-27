package arrays;

/**
 * You are given a SORTED list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer.
 * Refer to bit manipulation package for missing element in unsorted array.
 * @author Tahir
 *
 */
public class FindMissingElement {

	private static final int[] INPUT_ARRAY = {1,2,3,4,5,6,8,9};
	public static void main(String[] args) {

		System.out.println("Missing Element is: "+ findMissingElement(INPUT_ARRAY));

	}
	
	public static int findMissingElement(int[] array)	{
		
		// Trivial case
		if(array.length == 0)	return 1;
		if(array.length == 1) 	return 2;
		
		int min = 0;
		int max = array.length - 1;
		
		while(max-min > 1)	{
			int mid = (int) (max + min) /2;
			if(mid+1 == array[mid])	{
				min = mid;
			}
			else	{
				max = mid;
			}
		}
		return array[min] + 1;
		
	}

}
