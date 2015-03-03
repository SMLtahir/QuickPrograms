package recursion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Imagine a robot sitting on the upper left hand corner of an NxN grid  The robot can
only move in two directions: right and down. How many possible paths are there for
the robot to move to given destination coordinates (x,y)?
 * @author Tahir
 *
 */
public class RobotPaths {

	private static final int X = 6;
	private static final int Y = 6;
	
	public static void main(String[] args) {
		System.out.println("Nr of paths from (0,0) to ("+ X+ ","+ Y+ "): "+ findNrPaths(X,Y));
	}
	
	public static int findNrPaths(int x, int y) {
		
		//Base cases
		if(x == 0 && y == 0) { return 1;}
		if(x < 0 || y < 0) { return 0;}
		
		//General case
		return findNrPaths(x-1, y)+ findNrPaths(x, y-1);
	}
	
	public static List<Point> currentPath = new ArrayList<Point>();
	public static boolean getPath(int x, int y) {
		Point p = new Point(x, y);
		currentPath.add(p);
		
		if(x == 0 && y == 0) { return true;}
		boolean result = false;
		
		if(x > 0) {
			result = getPath(x-1, y);
		}
		if(!result && y > 0) {
			result = getPath(x, y-1);
		}
		if(!result) { currentPath.remove(p);}
		return result;
	}
	
	
}
