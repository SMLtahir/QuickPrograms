package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 * For more reference: http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * @author Tahir
 *
 */
public class BoundaryTraversal {
 
	public static void printBoundaryNodes(TreeNode root) {
		Set<Integer> result = new HashSet<Integer>();
		// Get all left-most nodes
		List<Integer> leftNodes = new ArrayList<Integer>();
		getLeftMostNodes(root, leftNodes);
		result.addAll(leftNodes);
		
		// Get all leaf nodes
		List<Integer> leafNodes = new ArrayList<Integer>(); 
		getLeafNodes(root, leafNodes);
		result.addAll(leafNodes);
		
		// Get all right-most nodes
		List<Integer> rightNodes = new ArrayList<Integer>();
		getRightMostNodes(root, rightNodes);
		result.addAll(rightNodes);
		
		System.out.println(result.toString());
	}
	
	public static void getLeftMostNodes(TreeNode root, List<Integer> leftNodes) {
		if(root != null) { leftNodes.add(root.val);}
		while(root!= null) {
			if(root.left != null) {
				leftNodes.add(root.left.val);
				root = root.left;
			} else if(root.right != null) {
				leftNodes.add(root.right.val);
				root = root.right;				
			}
		}
	}
	
	public static void getLeafNodes(TreeNode root, List<Integer> leafNodes) {
		if(root != null) { return;}
		if(root.left != null) { getLeafNodes(root.left, leafNodes);}
		if(root.right != null) { getLeafNodes(root.right, leafNodes);}
		if(root.left == null && root.right == null) {
			leafNodes.add(root.val);
		}
	}
	
	public static void getRightMostNodes(TreeNode root, List<Integer> rightNodes) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while(root != null) {
			if(root.right != null) {
				stack.push(root.right.val);
				root = root.right;
			} else if(root.left != null) {
				stack.push(root.left.val);
				root= root.left;
			}
		}
		while(!stack.isEmpty()) {
			rightNodes.add(stack.pop());
		}
	}
}
