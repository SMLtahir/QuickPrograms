package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * @author Tahir
 *
 */
public class LargestNumberString {

	private static final int[] INPUT = {0,90,56,75,23,1,2,23333};
	
	public static void main(String[] args) {

		System.out.println("Largest Number String is: "+ largestNumber(INPUT));

	}

	
    public static String largestNumber(int[] num) {
        StringBuffer sbuf = new StringBuffer();
        ArrayList<String> numstrings = new ArrayList<String>(num.length);

        for (int i : num) numstrings.add(String.valueOf(i));
        Collections.sort(numstrings,  new StringComparator());

        for (String s : numstrings) sbuf.append(s);

        String res = sbuf.toString();
        if (res.length() > 0 && res.charAt(0) == '0') return "0";

        return res;
    }

}

class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        if (a.length() == b.length()) {
            return b.compareTo(a);
        } else {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    }
}