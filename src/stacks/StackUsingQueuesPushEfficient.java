package stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a push efficient stack using 2 queues
 * @author Tahir
 *
 */
public class StackUsingQueuesPushEfficient {

	public static void main(String[] args) {

//		StackUsingQueuesPushEfficient stack = new StackUsingQueuesPushEfficient();
		StackUsingQueuesPopEfficient stack = new StackUsingQueuesPopEfficient();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Stack:\n"+ stack.toString());
		
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("Stack:\n"+ stack.toString());
	}
	
	Queue<Integer> queue1, queue2;
	
	//Constructor
	public StackUsingQueuesPushEfficient() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	public void push(int n) {
		queue1.add(n);
	}
	
	public int pop() {
		if(queue1.size() == 0) return -1;
		while(queue1.size() > 1) {
			queue2.add(queue1.remove());
		}
		int result = queue1.remove();
		Queue<Integer> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
		return result;
	}
	
	public String toString() {
		String result = "";
		while(queue1.size() > 0) {
			int value = queue1.remove();
			result = "Value: " + value+ "\n" + result;
			queue2.add(value);
		}
		Queue<Integer> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
		return result;
	}

}

class StackUsingQueuesPopEfficient {
	
	Queue<Integer> queue1, queue2;
	
	//Constructor
	public StackUsingQueuesPopEfficient() {

		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	public void push(int n) {
		queue2.add(n);
		while(queue1.size() > 0) {
			queue2.add(queue1.remove());
		}
		Queue<Integer> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
	}
	
	public int pop() {
		return queue1.remove();
	}
	
	public String toString() {
		String result = "";
		while(queue1.size() > 0) {
			int value = queue1.remove();
			result = result + "Value: " + value+ "\n";
			queue2.add(value);
		}
		Queue<Integer> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
		return result;
	}
}
