package linkedList;

public class SortList {

	private static final int[] INPUT = {3,2,5,4,3,1};
	
	public static void main(String[] args) {

		ListNode head = LinkListUtils.initializeLinkList(INPUT);
		LinkListUtils.display(head);

//		ListNode sortedHead = bubbleSortList(head);
		ListNode sortedHead = insertionSortList(head);
		LinkListUtils.display(sortedHead);

	}

	/**
	 * Bubble sort algorithm
	 * @param head head node of list
	 * @return the head of the list sorted by the Bubble sort algorithm 
	 */
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
	
	/**
	 * Insertion sort algorithm 
	 * @param head head node of list
	 * @return the head of the list sorted by the Insertion sort algorithm 
	 */
    public static ListNode insertionSortList(ListNode head) {
        //Trivial cases
        if(head == null || head.next == null)   { return head;}
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode focus = head;
        
        while(focus != null && focus.next != null) {
            
            if(focus.val > focus.next.val)    {
                //Check where to insert focus.next
                ListNode temp = focus.next;
                focus.next = focus.next.next;
                insert(temp, start);
                continue;
            }
            focus = focus.next;
        }
        return start.next;
    }
    
    /**
     * Helper method for insertionSortList
     * @param node node that needs to be inserted
     * @param start start node
     */
    public static void insert(ListNode node, ListNode start) {
        ListNode head = start.next;
        
        while(head != null) {
            if(head.val > node.val) {
                node.next = head;
                start.next = node;
                return;
            }
            head = head.next;
            start = start.next;
        }
    }
}
