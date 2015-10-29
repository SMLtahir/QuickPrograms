package arrays;

/**
 * Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x, how 
 * to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.
 * @author Tahir
 *
 */
public class SearchInSortedMatrix {

	private static int[][] matrix = { {10, 20, 30, 40},
        							  {15, 25, 35, 45},
        							  {27, 29, 37, 48},
        							  {32, 33, 39, 50},
      								};
	public static void main(String[] args) {

		findElement(matrix, 32);

	}
	
	private static void findElement(int[][] matrix, int x) {
		// Start at top right corner
		int i=0, j= matrix[0].length - 1;
		while(i< matrix.length && j >= 0) {
			if(matrix[i][j] == x) {
				System.out.println("Element found at "+ i+ ", "+ j);
				return;
			} else if(matrix[i][j] > x) { j--;}
			else { i++;}
		}
		System.out.println("Element not found");
	}

}
