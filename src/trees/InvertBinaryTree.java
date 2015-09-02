package trees;

/**
Invert a binary tree such as what is on the left appears on the right and vice-versa.
 * @author Tahir
 *
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) { return null;}
        TreeNode right = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right  = right;
        return root;
    }
	
}
