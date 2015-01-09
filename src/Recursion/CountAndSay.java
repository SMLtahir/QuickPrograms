package Recursion;

/**
 * LeetCode question- CountAndSay
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * @author Tahir Sousa
 */
public class CountAndSay {

	public static void main(String[] args) {

		int n = 2;
		String s = new Character((char) 65).toString();
		System.out.println(s);
		
		System.out.println("CountAndSay number for "+ n+ " is: "+ countAndSay(n));

	}

	public static String countAndSay(int n) {
        if(n < 1)   {return "";}
        else if(n == 1)  {return "1";}
        
        String previous = countAndSay(n-1);
        char[] charArray = previous.toCharArray();
        
        StringBuilder current = new StringBuilder();
        current.append("");
        int count = 1;
        char c1 = charArray[0];
        for(int i=1; i< charArray.length; i++)  {
            char c2 = charArray[i];
            if(c1 == c2)    {count++;}
            else    {
                current.append(count).append(c1);
                c1 = c2;
                count = 1;
            }
        }
        current.append(count).append(c1);
        return current.toString();
    }
}