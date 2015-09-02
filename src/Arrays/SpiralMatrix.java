package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	private static final int[][] INPUT = {{1,2,3,4},
										  {5,6,7,8},
										  {9,10,11,12},
										  {13,14,15,16}};
	public static void main(String[] args) {

		System.out.println("There! Spirally printed matrix!\n"+ spiralOrder(INPUT).toString());

	}
	
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0) { return list;}
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        
        while(startCol <= endCol && startRow <= endRow) {
            for(int j=startCol; j<= endCol; j++) {
                list.add(matrix[startRow][j]);
            }
            startRow++;
            
            for(int i=startRow; i<= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            endCol--;
            
            if (startRow <= endRow) {
                for(int j=endCol; j>= startCol; j--) {
                    list.add(matrix[endRow][j]);
                }
            }
            endRow--;
            
            if (startCol <= endCol) {
                for(int i=endRow; i>= startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
            }
            startCol++;    
        }
        return list;
        
    }

}
