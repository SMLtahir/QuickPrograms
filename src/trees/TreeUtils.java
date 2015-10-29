package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import linkedList.LinkListUtils;
import linkedList.ListNode;

public class TreeUtils {
	
	public static ListNode rootHead;
	public static void main(String[] args) {
		int[] array = {5, -1, 6, 4, -1, -1, 3, -1, -1};
		linkedList.ListNode head = LinkListUtils.initializeLinkList(array);
		
		TreeNode deserializedRoot = deserialize(head);
		System.out.println("Deserialized Tree: ");
		levelOrderPrint(deserializedRoot);
		ListNode serializedHead = serialize(deserializedRoot);
		System.out.println("Serialized Link List: ");
		LinkListUtils.display(serializedHead);
	}
	
	/**
	 * Given binary tree, serialize to LinkedList
	 * @param root
	 * @return
	 */
	public static ListNode serialize(TreeNode root) {
		ListNode rootHead = new ListNode(0);
		if(root == null) { return null;}
		
		ListNode focus = new ListNode(0);
		rootHead = focus;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            focus.next = new ListNode(node.val);
            focus = focus.next;
            if(node.val == -1) { continue;}		// Represents a null node
            
            if(node.right != null) { stack.push(node.right);}
            else { stack.push(new TreeNode(-1));}
            if(node.left != null) { stack.push(node.left);}
            else { stack.push(new TreeNode(-1));}
        }
        return rootHead.next;
	}
	
	/**
	 * Given LinkedList, deserialize it to binary tree
	 * Serialized tree example: 5 -1 6 4 -1 -1 3 -1 -1
	 * @param head
	 * @return
	 */
	public static TreeNode deserialize(ListNode head) {
		rootHead = head;
		return deserialize(new TreeNode(0));
	}
	
	public static TreeNode deserialize(TreeNode root) {
		if(rootHead == null || rootHead.val == -1) { 
			rootHead = (rootHead != null) ? rootHead.next : null;
			return root;
		}
		root = new TreeNode(rootHead.val);
		rootHead = rootHead.next;
		root.left = deserialize(root.left);
		root.right = deserialize(root.right);
		return root;
	}
	
	public static void levelOrderPrint(TreeNode root) {
        
        if(root == null)    System.out.println("#");
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        System.out.println(" "+ root.val+ " ");
        
        while(!queue.isEmpty()) {
            
            TreeNode focus = queue.remove();
            if(focus.left != null) { 
            	System.out.print(" "+ focus.left.val+ " ");
            	queue.add(focus.left);
            }
            else { System.out.print(" # ");}
            if(focus.right != null) { 
            	System.out.print(" "+ focus.right.val+ " ");
            	queue.add(focus.right);
            }    
            else { System.out.print(" # ");}
            
            if(focus == endOfLevel) {
            	System.out.println();
                endOfLevel = queue.peekLast();
            }
        }
    }
	
	/*class ListNode {
		  int val;
		  ListNode next;
		  ListNode(int x) { val = x; }
	}*/
	
	/*class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/
}
