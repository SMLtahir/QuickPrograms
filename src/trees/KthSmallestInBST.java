package trees;

/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
You may assume k is always valid, 1 <= k <= BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
Solution:
Method 2: Augmented Tree Data Structure.
The idea is to maintain rank of each node. We can keep track of elements in a subtree of any node while building the tree. 
Since we need K-th smallest element, we can maintain number of elements of left subtree in every node.
Assume that the root is having N nodes in its left subtree. If K = N + 1, root is K-th node. If K < N, we will continue 
our search (recursion) for the Kth smallest element in the left subtree of root. If K > N + 1, we continue our search in the 
right subtree for the (K – N – 1)-th smallest element. Note that we need the count of elements in left subtree only.

Time complexity: O(h) where h is height of tree.

 * @author Tahir
 *
 */
public class KthSmallestInBST {

    int count = 0;
    int current = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root,k);
        return current;
    }
    public void inOrderTraversal(TreeNode root, int k){
        if(count==k) return;
        else{
            if(root.left!=null) inOrderTraversal(root.left, k);
            count++;
            if(count==k){
                current = root.val;
                return;
            } 
            if(root.right!=null) inOrderTraversal(root.right, k);
        }
    }
}
