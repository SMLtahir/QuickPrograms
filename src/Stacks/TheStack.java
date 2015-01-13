package stacks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TheStack {

	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	
	TheStack(int size)	{
		stackSize = size;
		stackArray = new String[stackSize];
		Arrays.fill(stackArray, "-1");
	}
	
	public static void main(String[] args) {

		TheStack theStack = new TheStack(10);
		theStack.push("10");
		theStack.push("15");
		theStack.pushMany("1 2 4 5 34 54 24 75");
		theStack.push("00");
		theStack.popAll();

	}
	
	public void push(String input)	{
		
		if(topOfStack + 1 < stackSize)	{
			topOfStack++;
			
			stackArray[topOfStack] = input;
		}
		else	{
			System.out.println("Sorry, not enough space on the stack for another push!");
			return;
		}
		displayTheStack();
		System.out.println("PUSH "+ input + " was added to the stack.");
	}
	
	public void pushMany(String multipleValues)	{
		
		String[] multipleInputs = multipleValues.split(" ");
		for(int i=0; i< multipleInputs.length; i++)	{
			push(multipleInputs[i]);
		}
		System.out.println("\nAll inputs were pushed on the stack.");
	}
	
	public void popAll()	{
		for(int i= topOfStack; i>= 0; i--)	{
			pop();
		}
	}
	
	public String pop()	{
		String elementToPop;
	
		if(topOfStack >= 0)	{
			elementToPop = stackArray[topOfStack];
			stackArray[topOfStack] = "-1";
			topOfStack--;
			System.out.println(elementToPop+ " was POPPED off the stack.");
		}
		else	{System.out.println("Sorry, there are no elements on the stack to POP.");
		return null;
		}
		
		displayTheStack();
		return elementToPop;
	}
	
	public String peek()	{
		
		displayTheStack();
		
		System.out.println(stackArray[topOfStack]+ " is at the top of the stack.");
		
		return stackArray[topOfStack];
	}
	
	public void displayTheStack(){
		 
		 
		 for(int n = 0; n < 61; n++)System.out.print("-");
		 
		 System.out.println();
		 
		 for(int n = 0; n < stackSize; n++){
		 
			 System.out.format("| %2s "+ " ", n);
		 
		 }
		 
		 System.out.println("|");
		 
		 for(int n = 0; n < 61; n++)System.out.print("-");
		 
		 System.out.println();
		 
		 for(int n = 0; n < stackSize; n++){
		 
			 if(stackArray[n].equals("-1")) System.out.print("|     ");
		 
			 else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
		 
		 }
		 
		 System.out.println("|");
		 
		 for(int n = 0; n < 61; n++)System.out.print("-");
		 
		 	System.out.println();
		 
	}
	
	
	

}
