package graphs;

public class CountIslands {

	private static final int[][] MAP = {{0,1,1,0,1},
										{0,1,1,0,1},
										{0,1,1,0,1},
										{0,1,1,0,1}};
	
	private static boolean[][] EXPLORED;
	
	public static void main(String[] args) {

		EXPLORED = new boolean[MAP.length][MAP[0].length];
		System.out.println("Number of islands: "+ countIslands(MAP));

	}
	
	public static int countIslands(int[][] map) {
		
		int count = 0;
		// Traverse whole map
		for(int i=0;i< map.length; i++) {
			for(int j=0;j< map[0].length; j++) {
				if(map[i][j] == 1 && !EXPLORED[i][j]) {
					exploreMap(i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void exploreMap(int row, int col) {
		if(!isValid(row, col)) return;
		if(MAP[row][col] == 1 && !EXPLORED[row][col]) {
			EXPLORED[row][col] = true;
			exploreMap(row+1,col);
			exploreMap(row-1,col);
			exploreMap(row,col+1);
			exploreMap(row,col-1);
		}
	}

	public static boolean isValid(int row, int col) {
		if(row< 0 || row >= MAP.length || 
				col<0 || col >= MAP[0].length) { return false;}
		return true;
	}
}
