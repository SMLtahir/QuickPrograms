package arrays;

import java.util.HashSet;

public class ValidSudoku {

	private static final char[][] INPUT_BOARD = 
		{ {'.','8','7','6','5','4','3','2','1'},
		  {'2','.','.','.','.','.','.','.','.'},
		  {'3','.','.','.','.','.','.','.','.'},
		  {'4','.','.','.','.','.','.','.','.'},
		  {'5','.','.','.','.','.','.','.','.'},
		  {'6','.','.','.','.','.','.','.','.'},
		  {'7','.','.','.','.','.','.','.','.'},
		  {'8','.','.','.','.','.','.','.','.'},
		  {'9','.','.','.','.','.','.','.','.'}
		};
	public static void main(String[] args) {

		System.out.println("Valid Sudoku board? "+ isValidSudoku(INPUT_BOARD));

	}
	
	public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
