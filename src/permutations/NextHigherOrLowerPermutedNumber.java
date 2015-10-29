package permutations;

import java.util.Arrays;

/**
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
 * If x is the greatest possible number with its set of digits, then return -1.
 * @author Tahir
 *
 */
public class NextHigherOrLowerPermutedNumber {

	public static void main(String[] args) {

		System.out.println("Next higher permutation: "+ getNextHigherPermutation(-1234));

	}
	
	private static int getNextHigherPermutation(int n) {
		// Single digit numbers - not possible. Negative numbers not supported
		if(n < 9 && n >= 0) { System.out.println("Not possible!");  return -1;}
		if(n < 0) { return (-1)*getNextLowerPermutation(-n);}
		String s = Integer.toString(n);
		char[] ch = s.toCharArray();
		int i, j;
		// Find the first digit in non-increasing order
		for(i=ch.length-2; i>=0 ; i--) {
			if((int) ch[i] < (int) ch[i+1]) { break;}
		}
		if(i < 0) { System.out.println("Not possible!");  return -1;}
		
		// Find smallest digit bigger than digit at i
		int minInd = i+1;
		for(j = i+2; j < ch.length; j++) {
			if((int) ch[j] < (int) ch[minInd]) { minInd = j;}
		}
		// Swap characters
		char temp = ch[i];
		ch[i]  = ch[minInd];
		ch[minInd] = temp;
		
		// Arrange digits after i in increasing order
		char[] ch1 = Arrays.copyOfRange(ch, 0, i+1);
		char[] ch2 = Arrays.copyOfRange(ch, i+1, ch.length);
		Arrays.sort(ch2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ch1);
		sb.append(ch2);
		return Integer.parseInt(sb.toString());
	}
	
	private static int getNextLowerPermutation(int n) {
		// Single digit numbers - not possible.
		if(n < 9) { System.out.println("Not possible!");  return 1;}
		String s = Integer.toString(n);
		char[] ch = s.toCharArray();
		int i, j;
		// Find the first digit in non-increasing order
		for(i=ch.length-2; i>=0 ; i--) {
			if((int) ch[i] > (int) ch[i+1]) { break;}
		}
		if(i < 0) { System.out.println("Not possible!");  return 1;}
		
		// Find biggest digit smaller than digit at i
		int maxInd = i+1;
		for(j = i+2; j < ch.length; j++) {
			if((int) ch[j] > (int) ch[maxInd]) { maxInd = j;}
		}
		// Swap characters
		char temp = ch[i];
		ch[i]  = ch[maxInd];
		ch[maxInd] = temp;
		
		// Arrange digits after i in increasing order
		char[] ch1 = Arrays.copyOfRange(ch, 0, i+1);
		char[] ch2 = Arrays.copyOfRange(ch, i+1, ch.length);
		Arrays.sort(ch2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ch1);
		sb.append(ch2);
		return Integer.parseInt(sb.toString());
	}

}
