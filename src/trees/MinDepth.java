package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author Tahir
 *
 */
public class MinDepth {

	
	//The DFS method. This is inefficient as all nodes have to be traversed.
	public int minDepthDFS(TreeNode root) {
        if(root == null)   return 0;
        return minDepth(root, 1);
    }
    public static int minDepth(TreeNode focus, int minD)    {
        if(focus.left == null && focus.right == null)   { return(minD);}
        if(focus.left == null && focus.right != null)   { return(minDepth(focus.right, minD+1));}
        if(focus.left != null && focus.right == null)   { return(minDepth(focus.left, minD+1));}
        return(Math.min(minDepth(focus.left, minD+1), minDepth(focus.right, minD+1)));
    }
    
    
    
    //The BFS method. This is more efficient although extra space is used. As soon as the first leaf node is found, the min depth is returned.
    public int minDepthBFS(TreeNode root) {
        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        int depth = 1;

        while( !queue.isEmpty() ) {
            TreeNode node = queue.remove();
            if(node.left==null && node.right==null) return depth;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null)  queue.add(node.right);
            if(node == endOfLevel) {
                endOfLevel = node.right==null ? node.left : node.right;
                depth++;
            }
        }

        return depth;
    }
	
}
