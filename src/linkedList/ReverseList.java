package linkedList;

public class ReverseList {

	public static void main(String[] args) {

		int size = 10;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
//		ListNode reversedHead = reverseRecursively(head);
//		LinkListUtils.display(reversedHead);
//		ListNode reversedHead = reverseBetween(head,1,5);
//		LinkListUtils.display(reversedHead);
		ListNode reversedKHead = reverseKGroup(head,3);
		LinkListUtils.display(reversedKHead);

	}
	
	/**
	 * Reverse a linked list recursively
	 * @param head
	 * @return
	 */
	public static ListNode reverseRecursively(ListNode head)
	{
	    //Trivial/ base cases
	    if (head == null || head.next == null) return head;

	    ListNode nextElem = head.next;

	    head.next = null;

	    // Reverse everything from the second element on
	    ListNode reverseRest = reverseRecursively(nextElem);
	    nextElem.next = head;

	    return reverseRest;
	}
	
	/**
	 * Reverse whole linked list
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head)	{
		//Trivial Cases
		if(head == null || head.next == null)	return head;
		
		//General case
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode focus = head;
			
		while(focus.next != null)	{
			ListNode temp = focus.next;
			focus.next = focus.next.next;
			temp.next = start.next;
			start.next = temp;
		}
		return start.next;
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
		int count = 0;
		ListNode start = new ListNode(0);
		ListNode prefocus = start, focus = head, end = head;
		start.next = head;
		
		while(focus != null) {
			while(end != null && count < k-1) {
				end = end.next;
				count++;
			}
			if(end == null) { break;}
			
			while(count != 0) {
				count--;
				ListNode temp = prefocus.next; 
				prefocus.next = focus.next;
				focus.next = focus.next.next;
				prefocus.next.next = temp;
			}
			prefocus = focus;
			focus = focus.next;
			end = focus;
		}
		return start.next;
	}
}
