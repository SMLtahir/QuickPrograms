package trees;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * @author Tahir
 *
 */
public class PathSum {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root != null) {
            int partialSum = sum - root.val;
            
            if(partialSum == 0)   {
                //Check whether it is a leaf node
                if(root.left == null && root.right == null)
                    return true;
            }
            return(hasPathSum(root.left, partialSum) || hasPathSum(root.right, partialSum));
            
        }
        return false;
    }

}
