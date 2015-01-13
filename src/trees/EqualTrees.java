package trees;


/**
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author Tahir
 *
 */
public class EqualTrees {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;   //The case of both being null is taken care of above
        if(p.val != q.val)  return false;
        else    {
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

}
