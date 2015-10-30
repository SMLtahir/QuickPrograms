package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all permutations of a string
 * @author Tahir
 *
 */
public class PrintAllPermutationsOfString {

	public static void main(String[] args) {

		String str = "abcde";
		System.out.println("Using printPerms method...");
		printPerms(str, "");
		List<String> result = getPerms(str, "");
		System.out.println("There are "+ result.size()+ " permutations in total.");
		System.out.println(result);
	}
	
	public static void printPerms(String s, String stem) {
		if(s.length() == 0) { return;}
		if(s.length() == 1) { // Print only when it reaches last character
			System.out.println(stem+s.charAt(0));
		}
		for(int i=0;i<s.length();i++) {
			String newS = s.substring(0, i) + s.substring(i+1, s.length());
			printPerms(newS, stem + s.charAt(i));
		}
	}
	
	public static List<String> getPerms(String s, String stem) {
		List<String> result = new ArrayList<String>();
		if(s.length() == 0) { return result;}
		if(s.length() == 1) { 
			result.add(stem+s.charAt(0));
			return result;
		}
		for(int i=0;i<s.length();i++) {
			String newS = s.substring(0, i) + s.substring(i+1, s.length());
			result.addAll(getPerms(newS, stem + s.charAt(i)));
		}
		return result;
	}

}
