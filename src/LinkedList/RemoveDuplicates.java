package linkedList;

public class RemoveDuplicates {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

		int[] valueArray = {1,1,2,2,3};
		ListNode head = LinkListUtils.initializeLinkList(valueArray);
		LinkListUtils.display(head);
		//All elements appear only once
//		ListNode changedHead = deleteDuplicates1(head);
		//Only distinct elements are selected
		ListNode changedHead = deleteDuplicates2(head);
		LinkListUtils.display(changedHead);
	}

	/**
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates1(ListNode head) {
        //Handle trivial cases
        if(head == null || head.next == null)   return head;
        
        ListNode start = head, focus = head;
        while(focus != null) {
            if(focus.next != null)  {
                if(focus.val == focus.next.val) {
                    focus.next = focus.next.next;
                    continue;       //This is a very important line to handle multiple duplicates
                }
            }
            focus = focus.next;
        }
        return start;
    }
	
	/**
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
        //Handle trivial cases
        if(head == null || head.next == null)    return head;
        
        ListNode start = new ListNode(0);
        ListNode preFocus = start;
        ListNode focus = head;
        start.next = head;
        boolean isDuplicate = false;

        while(focus != null && focus.next != null)    {
            if(focus.val == focus.next.val) {
                focus.next = focus.next.next;
                isDuplicate = true;
                continue;
            }
            
            if(isDuplicate) { 
                preFocus.next = focus.next;
                isDuplicate = false;
            }
            else    { preFocus = preFocus.next;}
            focus = focus.next;
        }
        if(isDuplicate) { preFocus.next = focus.next;}
            
        return start.next;
    }

}
