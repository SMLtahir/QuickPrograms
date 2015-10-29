package graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a matrix of dimensions m*n where each cell in the matrix can have values 0,1 or 2 which has the following meaning :
      0:empty cell
      1:cells have fresh tomatoes
      2:cells have rotten tomatoes
So we have to determine what is the minimum time required so that all the tomatoes will be rotten. A rotten tomato at index [i,j] can rot other fresh tomato at indexes [i+1,j] ,[i,j+1] ,[i-1,j] ,[i,j-1]. If it is impossible to rot every tomato then simply return -1.
TODO: Do this without allocating any extra space.
- One way I can think of is making repeated sweeps of the board (time -> O(n^3)) and each time progressing one step of each of the old 2s.
Keeping track of old 2s and new 2s is going to be hard though esp. without extra space.
 * @author Tahir
 *
 */
public class RottenTomatoes {

	private static int[][] board = {{2,1,1,1},
									{1,1,1,1},
									{1,1,1,1},
									{1,1,1,2}};
	public static void main(String[] args) {
		System.out.println("Time taken to rot all tomatoes: "+ findTime(board));
	}
	
	private static int findTime(int[][] board) {
		if(board.length == 0) { return 0;}
		Set<TomatoNode> rotten = findRotten(board);
		int steps = 0;
		while(true) {
			if(!progressOneStep(board, rotten)) { break;}
			steps++;
		}
		boolean spoiled = isAllSpoiled(board);
		if(spoiled) { return steps;}
		return -1;
	}

	private static Set<TomatoNode> findRotten(int[][] board) {
		Set<TomatoNode> rotten = new HashSet<TomatoNode>();
		for(int i=0;i< board.length; i++) {
			for(int j=0;j< board[0].length; j++) {
				if(board[i][j] == 2) { rotten.add(new TomatoNode(i, j));}
			}
		}
		return rotten;
	}

	private static boolean progressOneStep(int[][] board, Set<TomatoNode> rotten) {
		boolean isProgress = false;
		Set<TomatoNode> newRotten = new HashSet<TomatoNode>();
		for(TomatoNode n : rotten) {
			if(move(board, n.x+1, n.y, newRotten) | move(board, n.x-1, n.y, newRotten) | move(board, n.x, n.y+1, newRotten) | move(board, n.x, n.y-1, newRotten))
				isProgress = true;
		}
		rotten.removeAll(rotten);
		rotten.addAll(newRotten);
		return isProgress;
	}

	private static boolean move(int[][] board, int x, int y, Set<TomatoNode> rotten) {
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) { return false;}
		if(board[x][y] == 1) {
			board[x][y] = 2;
			rotten.add(new TomatoNode(x, y));
			return true;
		}
		return false;
	}
	
	private static boolean isAllSpoiled(int[][] board) {
		for(int i=0;i< board.length; i++) {
			for(int j=0;j< board[0].length; j++) {
				if(board[i][j] == 1) { return false;}
			}
		}
		return true;
	}
}

class TomatoNode {
	int x;
	int y;
	public TomatoNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

