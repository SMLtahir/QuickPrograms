package LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * This is a LeetCode question: https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * @author Tahir Sousa
 *
 */

  //Definition of a ListNode
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
  public class LinkedListIntersection {
	  public static void main(String[] args)	{
		  
		  //Define two LinkedLists here and find the intersection point
		  
		  
	  }
	  
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Null lists
        if(headA == null && headB == null)  { return null;}
        
        //Depending on size, give sufficient headstart to longer list
        int sizeA = getLength(headA);
        int sizeB = getLength(headB);
        ListNode focusA = headA;
        ListNode focusB = headB;
        
        if(sizeA > sizeB)   {
            for(int i=0; i< sizeA - sizeB; i++) {
                focusA = focusA.next;
            }
        }
        else if(sizeB > sizeA)   {
            for(int i=0; i< sizeB - sizeA; i++) {
                focusB = focusB.next;
            }
        }
        else    {}  //Same length. No headstart required.
        
        ListNode commonNode = null;
        boolean isCommonFound = false;
        while(focusA != null && focusB != null) {
            if(focusA != focusB)  {
                commonNode = null;
                isCommonFound = false;
            }
            else    {
                if(!isCommonFound)   {
                    isCommonFound = true;
                    commonNode = focusA;
                }
            }
            focusA = focusA.next;
            focusB = focusB.next;
        }
        return commonNode;
    }
    
    public static int getLength(ListNode node) {
        int length = 0;
        ListNode focus = node;
        while(focus !=null)  {
            focus = focus.next;
            length++;
        }
        return length;
    }
}
