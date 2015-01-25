package sorting;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
LeetCode question: https://oj.leetcode.com/problems/sort-colors/
 * @author Tahir
 *
 */
public class SortColors {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}
	
	public void sortColors(int[] A) {
        
        //Trivial cases
        if(A == null || A.length <= 1) {
            return;
        }
        
        int rEnd = 0; 
        int bStart = A.length-1;
        for(int i=0; i<= bStart;)  {
            if(A[i]==0) {
                //Append to start of list
                A[i] = A[rEnd];
                i++;
                A[rEnd] = 0;
                rEnd++;
            }
            else if(A[i]==2)   {
                //Append to end of list
                A[i] = A[bStart];
                A[bStart] = 2;
                bStart--;
            }
            else    { i++;}
        }
    }

}
