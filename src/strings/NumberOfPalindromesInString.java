package strings;

import java.util.HashSet;
import java.util.Set;

public class NumberOfPalindromesInString {

	private static final String INPUT = "malayalam is an indian language";
	public static void main(String[] args) {
		System.out.println("Number of palindromes: "+ findDistinctPalindromes(INPUT));
	}
	
	public static int findDistinctPalindromes(String para) {
		Set<String> palindromes = new HashSet<String>();
		for(int i=0;i< para.length(); i++) {
			getPalindromes(para, i, i, palindromes);
			getPalindromes(para, i, i+1, palindromes);
		}
		return palindromes.size();
	}

	public static void getPalindromes(String s, int left, int right, Set<String> p) {
		StringBuilder sb = new StringBuilder();
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			if(left == right) { sb.append(s.charAt(left));}
			else {
				sb.insert(0, s.charAt(left));
				sb.append(s.charAt(right));
			}
			p.add(sb.toString());
			left--;
			right++;
		}
	}

}
