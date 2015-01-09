package LinkedList;

public class LinkListUtils {

	public static void display(ListNode head) {

		ListNode focus = head;
		System.out.println("Printing...");
		while(focus != null)	{
			System.out.println(focus.val);
			focus = focus.next;
		}
	}

	public static ListNode initializeLinkList(int size) {

		ListNode focus = new ListNode(0);
		ListNode head = focus;
		for(int i=1; i<= size; i++)	{
			ListNode temp = new ListNode(i);
			focus.next = temp;
			focus = focus.next;
		}
		return head.next;
	}
	
}
