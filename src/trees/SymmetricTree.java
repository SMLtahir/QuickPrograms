package trees;

public class SymmetricTree {

	private static final String[] INPUT = {"1","#","2","3"};  
	
	public static void main(String[] args) {

//		TreeNode root = TreeUtils.initializeTree(INPUT, 0);

	}
	
    public static boolean isSymmetric(TreeNode root) {
        return (root == null || isChildSymmetric(root.left, root.right));
    }
    
    public static boolean isChildSymmetric(TreeNode left, TreeNode right)   {
        //Check whether end is reached
        if(left == null || right == null)  { return left == right;}
        
        //Check whether left node value = right node value
        if(left.val != right.val)   { return false;}
        
        //Check whether children are symmetric
        return (isChildSymmetric(left.left, right.right) && isChildSymmetric(left.right, right.left));
    }

}

//Definition for binary tree
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}*/
