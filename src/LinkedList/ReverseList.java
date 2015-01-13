package linkedList;

public class ReverseList {

	public static void main(String[] args) {

		int size = 5;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
//		ListNode reversedHead = reverseBetween(head,1,5);
//		LinkListUtils.display(reversedHead);
		ListNode reversedKHead = reverseKGroup(head,3);
		LinkListUtils.display(reversedKHead);

	}
	
	/**
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
	    ListNode start = new ListNode(0);
	    start.next = head;
	    ListNode tail = null;
	    ListNode beforeHead = start;
	    for (int i = 1; i <= n; i++) {
	        if (i < m) {
	            beforeHead = head;
	            head = head.next;
	        } else if (i == m) {
	            tail = head;
	        } else {
	            beforeHead.next = tail.next;
	            tail.next = tail.next.next;
	            beforeHead.next.next = head;
	            head = beforeHead.next;
	        }
	    }
	    return start.next;
	}
	
	
	/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
        int i = 1;
        int size = getSize(head);
        ListNode beforeHead = new ListNode(0);
        ListNode start = new ListNode(0);
        start.next = head;
        beforeHead.next = head;
        ListNode tail = head;
        boolean isStartSet = false;
        while(i+k-1 <= size)   {
            for(int j=i; j< i+k-1; j++) {
                beforeHead.next = tail.next;
                tail.next = tail.next.next;
                beforeHead.next.next = head;
                head = beforeHead.next;
            }
            i+= k;
            
            if(!isStartSet) { 
            	start.next = beforeHead.next;
            	isStartSet = true;
            }
            beforeHead = tail;
            head = tail.next;
            tail = head;
        }
        return start.next;
    }

	public static int getSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
