package trees;

/**
 * Build binary tree given:
 * 1) Inorder and Postorder
 * 2) Inorder and Preorder
 * @author Tahir
 *
 */
public class BuildTreeFromOrders {

	// Given postorder and inorder traversal of a tree, construct the binary tree.
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildFromPostAndInorder(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }

	// Given preorder and inorder traversal of a tree, construct the binary tree.
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildFromPreAndInorder(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode buildFromPostAndInorder(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if(postStart < 0 || inStart > inEnd) { return null;}
        
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0;
        for(inIndex = inStart; inIndex <= inEnd; inIndex++) {
            if(root.val == inorder[inIndex]) { break;}
        }
        
        int nrNodesInRightSubtree = inEnd-inIndex;
        root.left = buildFromPostAndInorder(postStart-nrNodesInRightSubtree-1, inStart, inIndex-1, postorder, inorder);
        root.right = buildFromPostAndInorder(postStart-1, inIndex+1, inEnd, postorder, inorder);
        return root;
    }
    
    public TreeNode buildFromPreAndInorder(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart >= preorder.length || inStart > inEnd) { return null;}
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(inIndex = inStart; inIndex <= inEnd; inIndex++) {
            if(root.val == inorder[inIndex]) { break;}
        }
        
        root.left = buildFromPreAndInorder(preStart + 1, inStart, inIndex-1, preorder, inorder);
        int nrNodesInLeftSubtree = inIndex - inStart;
        root.right = buildFromPreAndInorder(preStart+ nrNodesInLeftSubtree + 1, inIndex+1, inEnd, preorder, inorder);
        
        return root;
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
