package queues;

import java.util.Arrays;

public class TheQueue {

	private String[] queueArray;
	private int queueSize;
	private int front, rear, numberOfItems = 0;
	
	TheQueue(int size)	{
		queueSize = size;
		queueArray = new String[queueSize];
		Arrays.fill(queueArray, "-1");
	}

	public static void main(String[] args) {

		TheQueue theQueue = new TheQueue(10);
		theQueue.insert("10");
		theQueue.insert("15");
		
		theQueue.displayTheQueue();
		
		theQueue.remove();
		theQueue.remove();
		theQueue.displayTheQueue();
		
		theQueue.priorityInsert("20");
		theQueue.priorityInsert("28");
		theQueue.priorityInsert("32");
		theQueue.priorityInsert("24");
		theQueue.priorityInsert("20");
		theQueue.priorityInsert("28");
		theQueue.priorityInsert("32");
		theQueue.priorityInsert("24");
		theQueue.priorityInsert("20");
		theQueue.priorityInsert("28");
		theQueue.priorityInsert("32");
		theQueue.priorityInsert("24");
		
		theQueue.displayTheQueue();
		
		theQueue.peek();
		System.out.println("Rear "+ theQueue.rear);
	}
	
	public void insert(String input)	{
		if(numberOfItems + 1 <= queueSize)	{
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			
			System.out.println(input+ " was PUSHed to the queue.");
		}
		else	{
			System.out.println("Sorry, but there is not enough space for another insert into this queue.");
		}
		
	}
	
	public void priorityInsert(String input)	{
		if(numberOfItems + 1 <= queueSize)	{
			int i;
			for(i= numberOfItems- 1; i>= 0; i--)	{
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i]))	{
					queueArray[i+1] = queueArray[i];
				}
				else
					break;
				
			}

			queueArray[i+1] = input;
			rear++;
			numberOfItems++;
			
		}	else	{
			System.out.println("Sorry, but there is not enough space for another insert into this queue.");
		}
	}
	
	public void remove()	{
		if(numberOfItems > 0)	{
			String elementToRemove = queueArray[front]; 
			queueArray[front] = "-1";
			
			front++;
			numberOfItems--;
			
			System.out.println(elementToRemove+ " was removed from the queue.");
		}
		else	{System.out.println("Sorry, there are no elements left in the queue for further removal.");}
		
	}
	
	public String peek()	{
		if(numberOfItems > 0)	{
			System.out.println(queueArray[front]+ " is at the front of this queue.");
			return queueArray[front];
		}
		else	{
			System.out.println("There are no elements in this queue.");
			return null;
		}
	}
	
	
	public void displayTheQueue(){
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
		
		System.out.format("| %2s "+ " ", n);
		
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
		
		
		if(queueArray[n].equals("-1")) System.out.print("|     ");
		
		else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
		
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		// Number of spaces to put before the F
		
		int spacesBeforeFront = 3*(2*(front+1)-1);
		
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		
		System.out.print("F");
		
		// Number of spaces to put before the R
		
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
		
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		
		System.out.print("R");
		
		System.out.println("\n");
		
		}
		

	}
