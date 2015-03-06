package linkedList;

/**
 * Given two lists sorted in ascending order, merge the lists maintaining the sorting.
 * @author Tahir
 *
 */
public class MergeTwoLinkedLists {

	private static final int[] listA = {0,1,2,3,5,7,9,13,19};
	private static final int[] listB = {1,2,4,6,8,10,11,11};
	public static void main(String[] args) {

		ListNode headA = LinkListUtils.initializeLinkList(listA);
		System.out.println("Printing A...");
		LinkListUtils.display(headA);
		
		ListNode headB = LinkListUtils.initializeLinkList(listB);
		System.out.println("Printing B...");
		LinkListUtils.display(headB);
		
		ListNode modifiedHead = mergeLists(headB, headA);
		System.out.println("Printing merged list...");
		LinkListUtils.display(modifiedHead);

	}
	
	public static ListNode mergeLists(ListNode headA, ListNode headB) {
		
		//Trivial cases
		if(headA == null) { return headB;}
		if(headB == null) { return headA;}
		
		ListNode start = new ListNode(0);
		ListNode focus = start;		
		
		while(headA != null && headB != null) {
			if(headB.val < headA.val) {
				focus.next = headB;
				headB = headB.next;
			} else {
				focus.next = headA;
				headA = headA.next;
			}
			focus = focus.next;
		}
		
		if(headA != null) {
			focus.next = headA;
		}
		else if(headB != null) {
			focus.next = headB;
		}
		
		return start.next;
	}

}
