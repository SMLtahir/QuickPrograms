package linkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * This is a LeetCode question: https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * @author Tahir Sousa
 *
 */
  public class LinkedListIntersection {
	
		public static void main(String[] args) {
		  //Define two LinkedLists here and find the intersection point
		}
	  
		public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        //Null lists
	        if(headA == null || headB == null)  { return null;}
	        
	        boolean endAReached = false;
	        boolean endBReached = false;
	        ListNode focusA = headA;
	        ListNode focusB = headB;
	        
	        while(true) {
	        	
	        	if(focusA == null)	{ 
	        		if(endAReached) { return null;}
	        		focusA = headB;
	        		endAReached = true;
	        	}
	        	if(focusB == null)	{ 
	        		if(endBReached) { return null;}
	        		focusB = headA;
	        		endBReached = true;
	        	}
	        	if(focusA == focusB)    { break;}
	        	
	        	focusA = focusA.next;
	        	focusB = focusB.next;
	        }
	        
	        if(focusA == focusB)	{ return focusA;}
	        else	{ return null;}
	    }
  }
