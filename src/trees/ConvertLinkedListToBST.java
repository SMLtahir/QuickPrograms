package trees;

import linkedList.ListNode;

public class ConvertLinkedListToBST {

    private static ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) { return null;}
        ListNode runner = head;
        node = head;
        int size = 0;
        
        while(runner != null) {
            runner = runner.next;
            size++;
        }
        return inorderTraverser(0, size-1);
    }
    
    public static TreeNode inorderTraverser(int start, int end) {
        
        if(start > end) { return null;}
        int mid = (start + end)/2;
        TreeNode left = inorderTraverser(start, mid-1);
        
        TreeNode focus = new TreeNode(node.val);
        focus.left = left;
        node = node.next;
        
        TreeNode right = inorderTraverser(mid+1, end);
        focus.right = right;
        
        return focus;
    }
    

	/*static class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}*/
	 
	/*static class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}*/
}
