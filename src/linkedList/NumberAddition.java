package linkedList;

public class NumberAddition {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Both numbers are null
        if(l1 == null && l2 == null)    return null;
        if(l1 == null && l2 != null)    return l2;
        if(l1 != null && l2 == null)    return l1;
        
        //General case
        int carry = 0;
        ListNode l3 = new ListNode(-1);
        ListNode focus1 = l1;
        ListNode focus2 = l2;
        ListNode resultHead = l3;
        
        while(focus1 != null || focus2 != null || carry != 0) {
            
            int x1 = 0, x2 = 0;
            if(focus1 != null)  x1 = focus1.val;
            if(focus2 != null)  x2 = focus2.val;
            
            l3.next = new ListNode((carry+ x1 + x2)%10);
            l3 = l3.next;
                
            //Carry over
            carry = (carry + x1 + x2)/10 >= 1 ? 1: 0;
            
            if(focus1 != null)  focus1 = focus1.next;
            if(focus2 != null)  focus2 = focus2.next;
        }
        
        return resultHead.next;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */