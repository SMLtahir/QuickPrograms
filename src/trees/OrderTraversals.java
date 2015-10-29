package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTraversals {

	// Recursive Inorder Traversal
	public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) { return result;}
        
        result.addAll(inorderTraversalRecursive(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalRecursive(root.right));
        
        return result;
    }
	
	// Iterative Inorder Traversal
	public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
	
	// Iterative Preorder Traversal
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) { return result;}
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            if(node.right != null) { stack.push(node.right);}
            if(node.left != null) { stack.push(node.left);}
        }
        return result;
    }

    // Recursive Preorder Traversal
 	public List<Integer> preorderTraversalRecursive(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         if(root == null) { return result;}
         
         result.add(root.val);
         result.addAll(preorderTraversalRecursive(root.left));
         result.addAll(preorderTraversalRecursive(root.right));
         
         return result;
    }
 	
    /*class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/
}
