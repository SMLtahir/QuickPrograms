package linkedList;

/**
 * Reorder list like example below,
 * 1-2-3-4-5-6-7-8 should output
 * 1-8-2-7-3-6-4-5
 * @author Tahir
 *
 */
public class ReorderList {

	public static void main(String[] args) {

		int size = 8;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
		reorderList(head);
		LinkListUtils.display(head);

	}
	
	/**
	 * Reorder list in O(n) time and O(1) space
	 * @param head
	 */
	public static void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow = head, fast = head;
        // Find middle node
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow, cur = slow.next;
        if(cur!=null){
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        // Reverse the list from middle node to end
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = tmp;
        }
        ListNode left = head, right = mid.next;
        // Using 3 pointers, left, right and middle, prepare the final arrangement by getting all nodes right of mid-point one by one to the right of the left pointer.
        while(right!=null){
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = mid.next;
        }

    }
	
	// O(n^2) time
	public static void reorderList2(ListNode head) {
        int size = getSize(head);
        
        //Trivial cases
        if(size == 0 || size == 1) { return;}
        int count = size -2;
        
        while(count > 0) {
            int innerCount = count;
            ListNode focus = head;
            while(innerCount > 0) {
                focus = focus.next;
                innerCount--;
            }
            focus.next.next = head.next;
            head.next = focus.next;
            focus.next = null;
            head = head.next.next;
            count = count-2;
        }
    }
    
    public static int getSize(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

}
