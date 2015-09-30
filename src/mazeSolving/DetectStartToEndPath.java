package mazeSolving;

import java.util.HashMap;
import java.util.Map;

/**
Suppose you are given a puzzle that is represented as a matrix with 0s and 1s, where a 0 indicates you’re allowed to move into that position and 1 means you’re not 
allowed to move in that position. Write a function that given a start position and an end position, returns a boolean value indicating if there exists a path from 
start to end. You are only allowed to move up, down, right or left. Diagonal movement is not allowed. 

Follow up: Print the path from start to end, if a path does exist.
 * @author Tahir
 *
 */
public class DetectStartToEndPath {

	private static final int[][] maze = { {0,1,1,0},
		                             	  {0,0,1,0},
		                             	  {1,0,0,1},
		                             	  {0,0,0,1},
		                             	  {1,1,0,0}
										};
	public static void main(String[] args) {

		Position startPos = new Position(0,0);
		Position endPos = new Position(4,3);
		System.out.println("Start -> "+ startPos);
		System.out.println("End -> "+ endPos);
//		System.out.println("Path Available: "+ isPathAvailable(maze, startPos, endPos));
		System.out.println("Path Found: "+ findPath(maze, startPos, endPos, ""));
	}
	
	private static Map<String, Boolean> explored = new HashMap<String, Boolean>();
	public static boolean isPathAvailable(int[][] maze, Position start, Position end) {
		if(isIllegal(maze, start) || isIllegal(maze, end)) { return false;}
		if(maze[start.x][start.y] == 1 || maze[end.x][end.y] == 1) { return false;}
		if(start.x == end.x && start.y == end.y) { return true;}
		
		// Add to explored nodes to avoid stackOverflow error (back and forth looping)
		if(explored.containsKey(start.x+","+start.y)) { return false;}
		else { explored.put(start.x+","+start.y, true);}
		
		if(isPathAvailable(maze, new Position(start.x, start.y-1), end) ) { return true;} // Up
		if(isPathAvailable(maze, new Position(start.x+1, start.y), end) ) { return true;} // Right
		if(isPathAvailable(maze, new Position(start.x, start.y+1), end) ) { return true;} // Down
		if(isPathAvailable(maze, new Position(start.x-1, start.y), end) ) { return true;} // Left
		return false;
	}
	
	public static boolean isIllegal(int[][] maze, Position pos) {
		return (pos.x < 0 || pos.x >= maze.length 
				|| pos.y < 0 || pos.y >= maze[0].length);
	}

	public static String findPath(int[][] maze, Position start, Position end, String path) {
		if(isIllegal(maze, start) || isIllegal(maze, end)) { return null;}
		if(maze[start.x][start.y] == 1 || maze[end.x][end.y] == 1) { return null;}
		if(start.x == end.x && start.y == end.y) { return (path+start);}
		
		// Add to explored nodes to avoid stackOverflow error (back and forth looping)
		if(explored.containsKey(start.x+","+start.y)) { return null;}
		else { explored.put(start.x+","+start.y, true);}
		
		String newPath = path + start;
		String up = findPath(maze, new Position(start.x, start.y-1), end, newPath); 
		if(up != null) { return up;} // Up
		String right = findPath(maze, new Position(start.x+1, start.y), end, newPath); 
		if(right != null) { return right;} // Right
		String down = findPath(maze, new Position(start.x, start.y+1), end, newPath); 
		if(down != null) { return down;} // Down
		String left = findPath(maze, new Position(start.x-1, start.y), end, newPath); 
		if(left != null) { return left;} // Left
		return null;
	}
}

class Position {
	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+ x+ ", "+ y+ ")";
	}
	
	public boolean equals(Position pos) {
		return (pos.x == x && pos.y == y);
	}
}
