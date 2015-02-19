package bitManipulation;

/**
 * You are given an UNSORTED list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer.
 * Refer to the FindMissingElement program in arrays package for dealing with a similar problem on a sorted list.
 * @author Tahir
 *
 */
public class MissingElement {

	private static final int[] INPUT_ARRAY = {8,7,5,6,4,2,9,1};
	public static void main(String[] args) {

		System.out.println("Missing element: "+ findMissingElement(INPUT_ARRAY, 9));

	}
	
	//Single pass, O(n) time and O(1) space
	public static int findMissingElement(int[] inputArray, int n)	{
		// Trivial cases
		if(inputArray.length == 0)	return 1;
		
		int xor1 = inputArray[0];
		int xor2 = 1;
		
		for(int i=1; i< inputArray.length; i++)	{
			xor1 = xor1^inputArray[i];
			xor2 = xor2^(i+1);
		}
		xor2 = xor2^n;
		
		//Below even the test case where there is no missing element, is handled by returning the next higher element.
		return (xor1^xor2) == n? (n+1): (xor1^xor2);
	}
	
	// Single pass, O(n) time, constant space but can run into overflow problems and so avoid this method
	public static int findMissingElement2 (int a[], int n)
	{
	    int i, total;
	    total  = (n+1)*(n+2)/2;   
	    for ( i = 0; i< n; i++)
	       total -= a[i];
	    return total;
	}

}
