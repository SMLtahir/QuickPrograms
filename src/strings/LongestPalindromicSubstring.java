package strings;

/**
 * Finding the longest palindromic substring of a string
 * @author Tahir
 *
 */
public class LongestPalindromicSubstring {

	private static final String INPUT = "abbbebbbbbbcbbbbbbebbbbbba";
	public static void main(String[] args) {

		System.out.println(findLongestPalindrome(INPUT));

	}
	
	public static String findLongestPalindrome(String s) {
		// Trivial cases
		if(s.length() <= 1) { return s;}
		
		// Base case
		String longest = s.substring(0,1);
		
		for(int i=0; i< s.length(); i++) {
			// Handle odd-length strings with i,i as center
			String tempLong = palindromeHelper(s, i, i);
			if(tempLong.length() > longest.length()) { longest = tempLong;}
			
			// Handle odd-length strings with i,i+1 as center
			tempLong = palindromeHelper(s, i, i+1);
			if(tempLong.length() > longest.length()) { longest = tempLong;}
		}
		return longest;
	}
	
	public static String palindromeHelper(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		// Think about what happens if the whole string is a palindrome. start = -1 and end = s.length() after the above loop
		return s.substring(start+1, end);   
	}

}
