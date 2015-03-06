package linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLinkedLists {

	//Make sure to put SORTED lists here
	private static final int[] listA = {1,3,5,7,9};
	private static final int[] listB = {2,4,6,8};
	private static final int[] listC = {25,44,66,88};
	private static final int[] listD = {-9,-7,-5,-1,-0,0,1,3};
	
	public static void main(String[] args) {

		ListNode headA = LinkListUtils.initializeLinkList(listA);
		System.out.println("Printing A...");
		LinkListUtils.display(headA);
		
		ListNode headB = LinkListUtils.initializeLinkList(listB);
		System.out.println("Printing B...");
		LinkListUtils.display(headB);
		
		ListNode headC = LinkListUtils.initializeLinkList(listC);
		System.out.println("Printing C...");
		LinkListUtils.display(headC);
		
		ListNode headD = LinkListUtils.initializeLinkList(listD);
		System.out.println("Printing D...");
		LinkListUtils.display(headD);
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(headA);
		lists.add(headB);
		lists.add(headC);
		lists.add(headD);
		
		ListNode modifiedHead = mergeKLists(lists);
		System.out.println("Printing merged list...");
		LinkListUtils.display(modifiedHead);

	}
	
	public static ListNode mergeKLists(List<ListNode> lists) {
		
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new NodeComparator());
		
		// Put heads of all lists in priority queue
		for(ListNode head : lists) {
			if(head != null) {
				q.add(head);
			}
		}
		
		ListNode start = new ListNode(0);
		ListNode focus = start;
		
		while(q.size() > 0) {
			// Retrieve and remove the head of the priority queue
			ListNode leastNode = q.poll();

			focus.next = leastNode;
			if(leastNode.next != null) { q.add(leastNode.next);}
			
			focus = focus.next;
		}
		return start.next;
	}

}

class NodeComparator implements Comparator<ListNode> {
	public int compare(ListNode a, ListNode b) {
		if (a.val > b.val)
			return 1;
		else if(a.val == b.val)
			return 0;
		else 
			return -1;
	}
}

