package trees;

/**
Given a binary tree, a target node in the binary tree, and an integer value k, 
print all the nodes that are at distance k from the given target node. 
No parent pointers are available.
More detailed explanation given here: http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

By the method given below, no node is traversed more than twice. Therefore the time complexity is O(n).
 * @author Tahir
 *
 */
public class PrintDistanceKNodes {
	
	public static void printKDistanceDown(TreeNode target, int k) {
		if(target == null || k < 0) { return;}
		if(k == 0) {
			System.out.println(target.val);
			return;
		} else {
			printKDistanceDown(target.left, k-1);
			printKDistanceDown(target.right, k-1);
		}
	}
	
	public static int printKDistanceNodes(TreeNode root, TreeNode target, int k) {
		if(root == null) { return -1;}
		
		if(root == target) {
			printKDistanceDown(target, k);
			return 0;
		}
		
		// dl is distance of root's left child from target
		int dl = printKDistanceNodes(root.left, target, k);
		if(dl != -1) {	// Target lies in left subtree
			if(dl + 1 == k) { // Root is k units away from target
				System.out.println(root.val);
			} else { // right child is 2 units away from left child. Thus, dl+2
				printKDistanceDown(root.right, k-dl-2);
			}
			return 1+dl;
		}
		
		int dr = printKDistanceNodes(root.right, target, k);
		if(dr != -1) { // target is in right subtree
			if(dr + 1 == k) {
				System.out.println(root.val);
			} else {
				printKDistanceDown(root.left, k-dr-2);
			}
			return 1+dr;
		}
		
		// Target is neither in left nor right subtree
		return -1;
	}
	
}
