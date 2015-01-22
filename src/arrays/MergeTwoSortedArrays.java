package arrays;

/**
 * There are two sorted arrays, A and B such that A has enough buffer at the end to accommodate entire B. 
 * Merge both arrays into 1 sorted array.
 * @author Tahir
 *
 */
public class MergeTwoSortedArrays {

	
	public static void main(String[] args) {

		int[] A = new int[10];
		for(int i=0; i< A.length/2; i++)	{
			A[i] = i+1;
		}
		//int[] A = {1,2,3,4,5};
		int[] B = {6,7,8,9,10};
		A = mergeTwoArrays(A, B);
		System.out.println();
	}
	
	public static int[] mergeTwoArrays(int[] arrayA, int[] arrayB)	{
		if(arrayB.length == 0)	return arrayA;
		
		//Find max element of A
		int lastAInd = 0;
		int lastBInd = arrayB.length- 1;
		for(int i=0; i< arrayA.length; i++)	{
			if(arrayA[i]> arrayA[i+1])	{ 
				lastAInd = i;
				break;
			}
		}
		
		for(int i= arrayA.length -1; i>= 0; i--)	{
			if(lastBInd < 0 || (arrayA[lastAInd] > arrayB[lastBInd] && lastAInd >= 0))	{
				arrayA[i] = arrayA[lastAInd];
				lastAInd--;
			}
			else	{
				arrayA[i] = arrayB[lastBInd];
				lastBInd--;
			}
		}
		return arrayA;
	}

}
