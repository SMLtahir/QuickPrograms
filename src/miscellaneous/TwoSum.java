package miscellaneous;

import java.util.HashMap;

/**
 * Find two numbers in an array whose sum is equal to the given sum.
 * @author Tahir
 *
 */
public class TwoSum {

	private static final int[] INPUT_ARRAY = {8,9,4,3,-2,8,4,5,3,4,6,7,1,2,3,0,-5,-4,-2,-1,-8,1,23,8};
	private static final int SUM = 15;
	public static void main(String[] args) {

		findTwoSum(INPUT_ARRAY, SUM);

	}
	
	public static void findTwoSum(int[] inputArr, int sum)	{
		
		int i = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(i=0; i< inputArr.length; i++)	{
			if(!map.containsKey(inputArr[i]))	{ map.put(sum-inputArr[i], 0);}
			else	{
				break;
			}
		}
		if(i < inputArr.length)
			System.out.println("Numbers are: "+ (sum - inputArr[i])+ " and "+ inputArr[i]+ " for sum of "+ sum);
		else
			System.out.println("No numbers fit this criterion");
	}

}
