package linkedList;

public class RemoveNthFromEnd {

	public static void main(String[] args) {

		int size = 5;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
//		ListNode changedHead = removeNthFromEnd1(head, 5);
		ListNode changedHead = removeNthFromEnd2(head, 4);
		LinkListUtils.display(changedHead);

	}
	
	// Better method
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
        
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
	}
	
	public static ListNode removeNthFromEnd1(ListNode head, int n) {
        //Handle trivial cases
        if(head == null) return null;
        
        int size = getSize(head);
        if(n>size || n<1)  return null;
        
        int k = size-n+1;
        if(k==1) return head.next;
        
        ListNode focus = head;
        for(int i=1; i<k-1; i++)   {
            focus = focus.next;
        }
        focus.next = focus.next.next;
        return head;
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
