package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LevelOrderTraversal {

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 * LeetCode question: https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null)    return output;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        
        ArrayList<Integer> levelList = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            
            TreeNode focus = queue.remove();
            levelList.add(focus.val);
            if(focus.left != null)   { queue.add(focus.left);}
            if(focus.right != null)   { queue.add(focus.right);}    
            
            if(focus == endOfLevel) {
                output.add(levelList);
                levelList = new ArrayList<Integer>();
                endOfLevel = queue.peekLast();
            }
        }
        return output;
    }
	
	// This method does not use any additional data structure and thus uses O(1) space if 
	// memory used for result list is not considered. In general, it is a more efficient method than when queue is used.
	public List<List<Integer>> levelOrderRecursive(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) { return result;}
		getLevelOrder(result, root, 0);
		return result;
	}
	
	private void getLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
		
		if(result.size() <= level) { result.add(new ArrayList<Integer>());}
		result.get(level).add(root.val);
		if(root.left != null) { getLevelOrder(result, root.left, level+1);}
		if(root.right != null) { getLevelOrder(result, root.right, level+1);}
	}
	
	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
	 * LeetCode question: https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null)    return output;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        Stack<List<Integer>> intermedOutput = new Stack<List<Integer>>();
        
        List<Integer> levelList = new ArrayList<Integer>();
        
        while(!queue.isEmpty()) {
            TreeNode focus = queue.remove();
            levelList.add(focus.val);
            if(focus.left != null)  { queue.add(focus.left);}
            if(focus.right != null)  { queue.add(focus.right);}
            
            if(focus == endOfLevel) {
                intermedOutput.push(levelList);
                levelList = new ArrayList<Integer>();
                endOfLevel = queue.peekLast();
            }
        }
        
        while(!intermedOutput.empty()) {
            output.add(intermedOutput.pop());
        }
        return output;
    }

    /*class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/
}
