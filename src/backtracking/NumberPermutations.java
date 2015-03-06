package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all possible permutations of the given input string.
 * @author Tahir
 *
 */
public class NumberPermutations {

	private static final int[] NUM = {1,2,3,4,5};
	public static void main(String[] args) {

		List<List<Integer>> list = permute(NUM);
		System.out.println("All possible permutations: "+ list.size()+ "\n"+ list);

	}
	
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length == 0) { return result;}
        List<Integer> list = new ArrayList<Integer>();
        list.add(num[0]);
        result.add(list);
        
        // Loop through all elements starting from the 2nd one
        for(int i = 1; i< num.length; i++) {
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            // Insert new element at different positions
            for(int pos = 0; pos<= i; pos++) {
                // Pick every permutation created till last set of iterations
                for(List<Integer> l : result) {
                    List<Integer> tempList = new ArrayList<Integer>(l);
                    tempList.add(pos, num[i]);
                    tempResult.add(tempList);
                }
            }
            result = tempResult;
        }
        return result;
    }

}
