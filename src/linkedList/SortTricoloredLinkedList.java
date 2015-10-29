package linkedList;

/**
 * Link-list is given it contains red, blue and green balls only. Sort it in place.
 * @author Tahir
 *
 */
public class SortTricoloredLinkedList {

	public static void main(String[] args) {
		
		int[] listA = {3,3,3};
		ListNode INPUT = LinkListUtils.initializeLinkList(listA);
		System.out.println("Printing A...");
		sortTripleColoredLinkedList(INPUT);
		LinkListUtils.display(INPUT);

	}
	
	// Red = 1, Blue = 2, Green = 3
	private static ListNode sortTripleColoredLinkedList(ListNode head) {
		if(head == null || head.next == null) { return head;}
		ListNode redStart = new ListNode(0);
		ListNode redFocus = redStart;
		ListNode blueStart = new ListNode(0);
		ListNode blueFocus = blueStart;
		ListNode greenStart = new ListNode(0);
		ListNode greenFocus = greenStart;
		
		while(head != null) {
			if(head.val == 1) {
				redFocus.next = head;
				redFocus = redFocus.next;
			} else if(head.val == 2) {
				blueFocus.next = head;
				blueFocus = blueFocus.next;
			} else {
				greenFocus.next = head;
				greenFocus = greenFocus.next;
			}
			head = head.next;
		}
		
		if(greenStart.next != null) {
			blueFocus.next = greenStart.next;
		}
		if(blueStart.next != null) {
			redFocus.next = blueStart.next;
		}
		return redStart.next;
	}

}
