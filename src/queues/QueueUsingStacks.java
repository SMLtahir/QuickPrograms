package queues;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 * @author Tahir
 *
 */
public class QueueUsingStacks {

	public static void main(String[] args) {

	}
	
	Stack<Integer> front, back;
	
	//Constructor
	public QueueUsingStacks() {
		front = new Stack<Integer>();
		back = new Stack<Integer>();
	}
	
	public void add(int n) {
		front.push(n);
	}
	
	public int peek() {
		if(!back.empty()) { return back.peek();}
		while(!front.empty()) {
			back.push(front.pop());
		}
		return back.peek();
	}
	
	public int remove() {
		if(!back.empty()) { return back.pop();}
		while(!front.empty()) {
			back.push(front.pop());
		}
		return back.pop();
	}

	public int size() {
		return front.size() + back.size();
	}
}
