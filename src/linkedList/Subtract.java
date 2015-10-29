package linkedList;

public class Subtract {

	public static void main(String[] args) {

		int[] firstNum = {0,9};
		int[] secondNum = {5,5};
		ListNode first = LinkListUtils.initializeLinkList(firstNum);
		LinkListUtils.display(first);
		ListNode second = LinkListUtils.initializeLinkList(secondNum);
		LinkListUtils.display(second);
		LinkListUtils.display(subtract(first, second));
	}
	
	public static ListNode subtract(ListNode first, ListNode second) {
		ListNode start = new ListNode(0);
		start.next = first;
		int firstVal = 0;
		int secondVal = 0;
		boolean borrow = false;
		while(first != null) {
			firstVal = first.val;
			if(second == null) {
				first = first.next;
				continue;
			}
			secondVal = second.val;
			if(first.val < secondVal) { 
				borrow = borrow(first.next);
				if(!borrow) {
					System.out.println("First is smaller than second number");
					System.exit(1);
				}
				first.val = (10+first.val) - second.val;
			} else {
				first.val = firstVal - secondVal;
			}
			first = first.next;
			second = second.next;
		}
		return start.next;
	}

	public static boolean borrow(ListNode head) {
		if(head == null) { return false;}
		if(head.val > 0) {
			head.val--;
			return true;
		} else {
			head.val = (10+head.val) -1;
			return borrow(head.next);
		}
	}
}
