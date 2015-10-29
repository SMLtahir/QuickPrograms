package linkedList;

/**
 * Given a linked list, determine if it has a cycle in it.
Solve it without using extra space.  
 * @author Tahir
 *
 */
public class ContainsCycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null)    return false;
        
        ListNode slowRunner = head;
        ListNode fastRunner = head.next;
        
        while(fastRunner != null && fastRunner.next != null) {
            if(slowRunner == fastRunner)    return true;    //They have caught up at a common node
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return false;
    }
}