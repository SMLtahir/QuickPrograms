package linkedList;

public class SortList {

	private static final int[] INPUT = {7,4,0,2,8,3,2,4};
	
	public static void main(String[] args) {

		ListNode head = LinkListUtils.initializeLinkList(INPUT);
		LinkListUtils.display(head);

		ListNode sortedHead = bubbleSortList(head);
		LinkListUtils.display(sortedHead);

	}

	public static ListNode bubbleSortList(ListNode head) {
        //Trivial cases
        if(head == null || head.next == null)   return head;
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start;
        boolean isSorted = false;
        
        while(!isSorted)    {
            isSorted = true;
            while(head != null && head.next != null)   {
                if(head.val > head.next.val)  {
                    //Swap nodes
                    prev.next = head.next;
                    head.next = head.next.next;
                    prev.next.next = head;
                    isSorted = false;
                }
                head = prev.next.next;
                prev = prev.next;
            }
            prev = start;
            head = start.next;
        }
        return start.next;
    }
}
