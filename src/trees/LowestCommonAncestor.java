package trees;

/**
Given a BINARY SEARCH TREE (BST)[Part 1] and BINARY TREE[Part 2], find the lowest common ancestor (LCA) of two given nodes in 
the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest 
node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * @author Tahir
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorInBinarySearchTree(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorInBinarySearchTree(root.right, p, q);
        } 
        return root;
    }
    
    public TreeNode lowestCommonAncestorInBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) { return root;}
        
        TreeNode leftLca = lowestCommonAncestorInBinaryTree(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestorInBinaryTree(root.right, p, q);
        return (leftLca == null) ? rightLca : (rightLca == null) ? leftLca : root;
    }
	
}
