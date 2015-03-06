package miscellaneous;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordBreak {

	private static final String S = "aaaaaaa";
	public static void main(String[] args) {
		
		int ch = 'a';
		int CH = 'A';
		System.out.println(ch+ ", "+ CH);
		Set<String> dict = new TreeSet<String>();
		dict.add("aaaa");
		dict.add("aa");
		System.out.println("Wordbreak of the given string is possible: "+ wordBreak(S, dict));

	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
		
		char[] ch = s.toCharArray();
		boolean[] isInDict = new boolean[ch.length + 1];
		Arrays.fill(isInDict, false);
		isInDict[0] = true;
		
		for(int i = 1; i< ch.length; i++) {
			for(int j = 0; j< ch.length; j++) {
				if(isInDict[j] && dict.contains(s.substring(j, i))) {
					isInDict[i] = true;
					break;
				}
			}
		}
		return isInDict[ch.length];
	}
        
        

}
