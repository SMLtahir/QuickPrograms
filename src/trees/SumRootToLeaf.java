package trees;

/**
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
 * @author Tahir
 *
 */
public class SumRootToLeaf {


	public int sumNumbers(TreeNode root) {
        
        if(root == null)    return 0;
        if(root.left == null && root.right == null) return root.val;
        
        return( sumNumbers(root.left, root.val) + sumNumbers(root.right, root.val) );
    }
    
    public static int sumNumbers(TreeNode focus, int currentVal)    {
        //If focus does not exist on tree
        if(focus == null)   return 0;
        int currentSum = focus.val + 10*currentVal;
        
        //If focus is a leaf node
        if(focus.left == null && focus.right == null)   { return(currentSum);}
        
        return sumNumbers(focus.left,currentSum) + sumNumbers(focus.right,currentSum);
    }
	
}
