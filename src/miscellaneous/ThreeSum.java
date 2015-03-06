package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all 3-number combinations that sum up to 0.
 * @author Tahir
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
	     
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //Trivial cases
        if(num.length < 3) { return list;}
        Arrays.sort(num);
        
        for(int i = 0; i< num.length -2; i++) {
            
            if(i == 0 || (i > 0 && (num[i] != num[i-1]) )) {
                int low = i+1;
                int high = num.length - 1;
                int sum = 0-num[i];
                
                while(low < high) {
                    if(num[low] + num[high] == sum) {
                        // We have a match
                        list.add(Arrays.asList(num[i], num[low], num[high]));
                        while(low< high && num[low] == num[low+1])    { low++;}
                        while(low< high && num[high] == num[high-1])    { high--;}
                        low++;
                        high--;
                    }
                    else if(num[low] + num[high] < sum) { low++;} //Higher value needed
                    else { high--;} //Lower value needed
                }
            }
        }
        
        return list;
    }
}
