package linkedList;

public class MergeSortLinkedList {

	private static final int[] listA = {1,4,3,1,5,0,7,2,9};
	public static void main(String[] args) {

		ListNode headA = LinkListUtils.initializeLinkList(listA);
		LinkListUtils.display(headA);
		System.out.println("Sorted A...");
		LinkListUtils.display(sortList(headA));

	}
	
    public static ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) { return head;}
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head), head2);
    }
    
    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode start = new ListNode(0);
        ListNode head = start;
        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                head.next = h1;
                h1 = h1.next;
            } else {
                head.next = h2;
                h2 = h2.next;
            }
            head = head.next;
        }
        if(h1 == null) { head.next = h2;}
        else { head.next = h1;}
        return start.next;
    }

}
