package LinkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * @author Tahir
 *
 */
public class Rotation {

	public static void main(String[] args) {

		int size = 5;
		ListNode head = LinkListUtils.initializeLinkList(size);
		LinkListUtils.display(head);
		//ListNode rotatedHead = rotateRight2(head, 2);
		ListNode rotatedHead = rotateRight2(head, 2);
		LinkListUtils.display(rotatedHead);
		System.out.println();
	}
	
	

	public static ListNode rotateRight1(ListNode head, int n) {
        
        //Handle trivial cases
        if(head == null || head.next == null)   return head;
        
        //General case
        //Get size of LinkList
        //Nr of effective rotations(r) = n%size
        //Break and move list at k = size - r
        int size = getSize(head);
        int r = n% size;
        int breakPt = (size -1) - r;
        
        if(r == 0)  return head;
        
        int count = 0;
        ListNode focus = head;
        ListNode focusHead = head;
        boolean isRotated = false;
        while(isRotated == false)   {
            
            if(count == breakPt)    {
                ListNode temp = focus.next;
                count++;
                ListNode tempHead = focusHead;
                focusHead = temp;
                focus.next = null;
                while(count != size-1) {
                    temp = temp.next;
                    count++;
                }
                temp.next = tempHead;
                isRotated = true;
                break;
            }
            
            focus = focus.next;
            count++;
        }
        return focusHead;
    }
	
	public static ListNode rotateRight2(ListNode head, int n) {
	    if (head==null||head.next==null) return head;
	    
	    ListNode dummy=new ListNode(0);
	    dummy.next=head;
	    ListNode focus1=dummy,focus2=dummy;

	    int i;
	    for (i=0;focus1.next!=null;i++)//Get the total length 
	        focus1=focus1.next;

	    for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
	        focus2=focus2.next;

	    focus1.next=dummy.next; //Do the rotation
	    dummy.next=focus2.next;
	    focus2.next=null;

	    return dummy.next;
	}
    
    public static int getSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
