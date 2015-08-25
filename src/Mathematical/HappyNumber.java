package mathematical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 * @author Tahir
 *
 */
public class HappyNumber {

	private static final int NUMBER = 19;
	public static void main(String[] args) {

		System.out.println(NUMBER+ " is a happy number: "+ isHappy(NUMBER));

	}

	/*
	 * This uses the Floyd cycle detection algorithm involving a fast runner and a slow runner
	 */
	public static boolean isHappy(int n) {
	    int slow, fast;
	    slow = fast = n;
	    do {
	        slow = digitSquareSum(slow);
	        fast = digitSquareSum(fast);
	        fast = digitSquareSum(fast);
	    } while(slow != fast);
	    if (slow == 1) return true;
	    else return false;
	}

	
	public static int digitSquareSum(int n) {
	    int sum = 0, tmp;
	    while (n != 0) {
	        tmp = n % 10;
	        sum += tmp * tmp;
	        n /= 10;
	    }
	    return sum;
	}

	public static boolean isHappy2(int n) {
        
        //Trivial case
        if(n == 0) { return false;}
        
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(n > 1) {
            int m = n;
            n = 0;
            while(m != 0) {
                n += Math.pow(m%10, 2);
                m = m/10;
            }
            if(map.containsKey(n)) { return false;}
            else {
                map.put(n, 1);
            }
        }
        
        return true;
    }

}
