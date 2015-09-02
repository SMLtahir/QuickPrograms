package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author Tahir
 *
 */
public class BalancedBinaryTree {

/* * The problem about this solution however is that, the program checks the depth of every node till the end.
 * It can potentially stop much earlier, as soon as the depth on one side exceeds that on the other.
 * Try to correct this.
 * EDIT: I have now used the Exception handler to bring down the time complexity by returning an exception as soon as the difference in depth
 * is found to be more than the limit. This however, still is required to reach the last node. In case of a very long branch of a tree therefore, this 
 * is still very inefficient. Try to improve.
 */
	public boolean isBalanced(TreeNode root) {
        try {
            getDepth(root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private int getDepth(TreeNode root) throws Exception {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            throw new Exception("Not balanced!");
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    // Check if this BFS works fine too
    private boolean isBalanced2(TreeNode root) {
    	LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	TreeNode endOfLevel = root;
    	boolean isBranchEnd = false;
    	int depthDiff = 1;
    	while(q.size() > 0) {
    		
    		TreeNode focus = q.remove();
    		if(focus.left != null) { 
    			q.add(focus.left);
    		} else {
    			isBranchEnd = true;
    		}
    		if(focus.right != null) { 
    			q.add(focus.right);
    		} else {
    			isBranchEnd = true;
    		}
    		
    		if(depthDiff < 0) { return false;}
    		if(focus == endOfLevel && isBranchEnd) {
    			endOfLevel = q.peekLast();
    			depthDiff--;
    		}
    	}
    	return true;
    }
	
}
