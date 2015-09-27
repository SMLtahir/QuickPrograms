package linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author Tahir
 *
 */
public class SwapNodes {

	public static void main(String[] args) {

		int size = 5;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
		//ListNode swappedHead = swapPairs1(head);
		ListNode swappedHead = swapPairs2(head);
		LinkListUtils.display(swappedHead);

	}

	//Using constant memory
	public static ListNode swapPairs1(ListNode head) {
	     
	     int size = getSize(head);
	     //Trivial case
	     if(size < 2)   return head;
	     ListNode focus = head;
	     ListNode focusHead = head.next;
	     ListNode prev = new ListNode(0);
	     
	     while(focus != null && focus.next != null)    {
	         ListNode temp = focus.next;
	         focus.next = temp.next;
	         temp.next = focus;
	         prev.next = temp;
	         
	         prev = focus;
	         focus = focus.next;
	     }
	     
	     return focusHead;
	}
	
	//Using recursion
	public static ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
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
