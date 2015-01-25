package arrays;

/**
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author Tahir
 *
 */
public class WordSearch {

	public static boolean exist(char[][] board, String word) {
        
        //Handle trivial cases
        if(board.length == 0)   return false;
        if(word.equals("")) return true;
        
        char[] ch = word.toCharArray();
        int[][] usedBoard = new int[board.length][board[0].length];
        
        //Scan the board for first character
        for(int r=0; r< board.length; r++)  {
            for(int c=0; c< board[0].length; c++)   {
                if(board[r][c] == ch[0])    {
                    usedBoard[r][c] = 1;
                    if(isWordPresent(ch, 0, board, r, c, usedBoard))    return true;
                    usedBoard[r][c] = 0;
                }
            }
        }
        
        return false;
        
    }
    
    public static boolean isWordPresent(char[] word, int start, char[][] board, int row, int col, int[][] usedBoard)   {
        if(start+1 == word.length)    return true;
        
        //Search right
        if(col< board[0].length-1) { 
            if(word[start+1] == board[row][col+1] && usedBoard[row][col+1] != 1)  {
                usedBoard[row][col+1] = 1;
                if(isWordPresent(word, start+1, board, row, col+1, usedBoard)) return true;
                usedBoard[row][col+1] = 0;
            }
                
        }
        //Search down
        if(row< board.length-1) { 
            if(word[start+1] == board[row+1][col] && usedBoard[row+1][col] != 1)  {
                usedBoard[row+1][col] = 1;
                if(isWordPresent(word, start+1, board, row+1, col, usedBoard)) return true;
                usedBoard[row+1][col] = 0;
            }
                
        }
        //Search left
        if(col> 0) { 
            if(word[start+1] == board[row][col-1] && usedBoard[row][col-1] != 1)  {
                usedBoard[row][col-1] = 1;
                if(isWordPresent(word, start+1, board, row, col-1, usedBoard)) return true;
                usedBoard[row][col-1] = 0;
            }
                
        }
        //Search up
        if(row> 0) { 
            if(word[start+1] == board[row-1][col] && usedBoard[row-1][col] != 1)  {
                usedBoard[row-1][col] = 1;
                if(isWordPresent(word, start+1, board, row-1, col, usedBoard)) return true;
                usedBoard[row-1][col] = 0;
            }
                
        }
        
        return false;
        
    }
}
