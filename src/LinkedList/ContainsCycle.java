package LinkedList;

/**
 * Given a linked list, determine if it has a cycle in it.
Solve it without using extra space.  
 * @author Tahir
 *
 */
public class ContainsCycle {
    public static boolean hasCycle(LListNode head) {
        if(head == null)    return false;
        
        LListNode slowRunner = head;
        LListNode fastRunner = head.next;
        
        while(fastRunner != null && fastRunner.next != null) {
            if(slowRunner == fastRunner)    return true;    //They have caught up at a common node
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return false;
    }
}

//Definition for singly-linked list.
class LListNode {
    int val;
    LListNode next;
    LListNode(int x) {
        val = x;
        next = null;
    }
}