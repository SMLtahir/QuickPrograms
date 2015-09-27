package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/**
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.

FOLLOW-UP: Return the order in which courses can be taken. There can be multiple right answers in some cases
 * @author Tahir
 *
 */
public class CourseSchedule {

	private static final int[][] PREREQUISITES = {{0,1},{1,0}};
	private static final int NR_OF_COURSES = 2;
	public static void main(String[] args) {

		System.out.println(canFinish(NR_OF_COURSES, PREREQUISITES));

	}
	
    static boolean[] possibleCourses;
    static boolean[] explored;
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        possibleCourses =  new boolean[numCourses];
        explored =  new boolean[numCourses];
        for(int i=0; i< numCourses; i++) {
            if(!checkCourse(i, prerequisites)) {
                return false;    
            }
        }
        return true;
    }
    
    public static boolean checkCourse(int courseNr, int[][] prerequisites) {
    	explored[courseNr] = true;
    	
    	List<Integer> prereqs = getPrereqs(courseNr, prerequisites);
        if(possibleCourses[courseNr] == true)  { return true;}
        for(int req: prereqs) {
            if(!explored[req] && !checkCourse(req, prerequisites)) { return false;}
            if(possibleCourses[req]) { continue;}
            return false;
        }
        possibleCourses[courseNr] = true;
        return true;
    }
    
    public static List<Integer> getPrereqs(int courseNr, int[][] pre) {
        List<Integer> prereqs = new ArrayList<Integer>();
        for(int[] row : pre) {
            if(row.length > 0 && row[0] == courseNr) {
                prereqs.add(row[1]);
            }
        }
        return prereqs;
    }

}
