package arrays;

import java.util.HashMap;
import java.util.Set;

/**
 * All numbers in the list have duplicates, except for one. Find that one. 
 * @author Tahir
 *
 */
public class FindUniqueAmongstDuplicates {

	private static final int[] input = {1,2,3,4,5,4,3,2,1};
	
	public static void main(String[] args) {

		System.out.println("Unique element: "+ (findUnique(input)!= -1? findUnique(input): "Value = -1 or no elements in the array"));

	}
	
	public static int findUnique(int[] numbers)	{
		if(numbers.length < 1)	return -1;
		if(numbers.length == 1)	return numbers[0];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< numbers.length; i++)	{
			if(!map.containsKey(numbers[i]))	{ map.put(numbers[i], 1);}
			else	{
				//Counting here single and multiple duplicates as the same case
				map.put(numbers[i], 0);
			}
		}
		
		//Traverse the map looking for key with value == 1
		Set<Integer> mapKeys = map.keySet();
		for(int key: mapKeys)	{
			if(map.get(key) == 1)	{ return key;}
		}
		
		//If all values contain duplicates, return 0
		return -1;
	}

}
