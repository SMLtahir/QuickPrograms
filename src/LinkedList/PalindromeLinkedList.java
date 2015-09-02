package linkedList;

/**
Given a singly linked list, determine if it is a palindrome.
Could you do it in O(n) time and O(1) space?
 * @author Tahir
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {

		int[] input = {1,2,1,2,1};
		ListNode head = LinkListUtils.initializeLinkList(input);
		LinkListUtils.display(head);
		System.out.println("LinkedList is Palindrome: "+ isPalindrome(head));

	}
	
    public static boolean isPalindrome1(ListNode head) {
        // Trivial case
        if(head == null || head.next == null) { return true;}
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode firstHalfStart = head;
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse to mid node and Reverse the First half of the LinkedList in the same run
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            
            start.next = slow.next;
            slow.next = slow.next.next;
            start.next.next = firstHalfStart;
            
            firstHalfStart = start.next;
        }
        
        // Offset for odd number of elements
        // As the mid node is common to both halves, this should be skipped
        if(fast.next == null) { 
            firstHalfStart = firstHalfStart.next;
        }
        // SecondHalf pointer will be one after where the slow pointer stopped
        ListNode secondHalfStart = slow.next;

        while(slow != null) {
            if(firstHalfStart.val != secondHalfStart.val) { return false;}
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }
        return true;
    }
    
    public static boolean isPalindrome(ListNode head) {
        // Trivial case
        if(head == null || head.next == null) { return true;}
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode firstHalfStart = head;
        ListNode secondHalfStart = head;
        ListNode fast = head;
        
        // Traverse to mid node and Reverse the First half of the LinkedList in the same run
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            
            start.next = secondHalfStart.next;
            secondHalfStart.next = secondHalfStart.next.next;
            start.next.next = firstHalfStart;
            
            firstHalfStart = start.next;
        }
        
        // Offset for odd number of elements
        // As the mid node is common to both halves, this should be skipped
        if(fast.next == null) {
            firstHalfStart = firstHalfStart.next;
        }
        // SecondHalf pointer will be one after where the slow pointer stopped
        secondHalfStart = secondHalfStart.next;
        
        while(secondHalfStart != null) {
            if(firstHalfStart.val != secondHalfStart.val) { return false;}
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }
        return true;
    }

}
