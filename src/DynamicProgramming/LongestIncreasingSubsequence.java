package DynamicProgramming;

import java.util.Arrays;

/**
 * Problem 1:
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a 
 * given sequence such that all elements of the subsequence are sorted in increasing order. For example, 
 * length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * Reference:
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * http://www.geeksforgeeks.org/construction-of-longest-monotonically-increasing-subsequence-n-log-n/
 * 
 * Problem 2:
 * There is a river that runs horizontally through an area. There are a set of cities above (north) 
 * and below (south) the river. 
 * Each city above the river is matched with a city below the river, and you are given this matching 
 * as a set of pairs.
 * You are interested in building a set of bridges across the river to connect the largest number of the 
 * matching pairs of cities, but you must do so in a way that no two bridges intersect one another.
 */
public class LongestIncreasingSubsequence {
    
    public static void main(String args[]){
        //int input[] = {2,5,3,1,2,10,6,7,8};
        int input[] = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
//        System.out.println("Maximum length " + longestIncreasingSubSequence(input));
        
        int[] north = {3,2,4,5,1,0,6};
        int[] south = {0,1,2,3,4,5,6};
        System.out.println("The order of bridges from the north bank is: ");
        System.out.println("Max no. of bridges: "+ buildingBridges(north, south));
    }
    
    public static int longestIncreasingSubSequence(int inputArr[]){
        int tempArr[] = new int[inputArr.length];
        int finalArr[] = new int[inputArr.length];
        Arrays.fill(finalArr, -1);
        
        tempArr[0] = 0;
        int len = 0;
        for(int i=1; i < inputArr.length; i++){
            if(inputArr[i] < inputArr[tempArr[0]]){ //if input[i] is less than 0th value of T then replace it there.
                tempArr[0] = i;
            }else if(inputArr[i] > inputArr[tempArr[len]]){ //if input[i] is greater than last value of T then append it in T
                len++;
                tempArr[len] = i;
                finalArr[tempArr[len]] = tempArr[len-1];
            }else{ //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(inputArr, tempArr, len, inputArr[i]);
                tempArr[index] = i;
                finalArr[tempArr[index]] = tempArr[index-1];
            }
        }

        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        int index = tempArr[len];
        StringBuilder sb = new StringBuilder();
        while(index != -1) {
        	sb.insert(0," "+ inputArr[index]);
            index = finalArr[index];
        }
        System.out.println(sb.toString());
        return len+1;
    }
    
    public static int buildingBridges(int[] north, int[] south) {
    	for(int i=0; i< north.length; i++) {
    		south[north[i]] = i;
    	}
    	return longestIncreasingSubSequence(south);
    }
    
    /**
     * Returns index in T for ceiling of s
     */
    private static int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
}
