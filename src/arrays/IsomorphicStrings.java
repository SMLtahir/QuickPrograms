package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 * @author Tahir
 *
 */
public class IsomorphicStrings {

	private static final String S1 = "paper";
	private static final String S2 = "title";
	public static void main(String[] args) {

		System.out.println("Strings \""+ S1+ "\" and \""+ S2+ "\" are Isomorphic: "+ isIsomorphic2(S1, S2));

	}
	
    public static boolean isIsomorphic(String s, String t) {
        //Trivial cases
        if(s.length() != t.length()) { return false;}
        
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Character> morphDict = new HashMap<Character, Character>();
        List<Character> usedChars = new ArrayList<Character>();
        
        int len = s.length();
        while(len != 0) {
            if(!morphDict.containsKey(sChar[len-1])) {
                if(!usedChars.contains(tChar[len-1])) {
                    morphDict.put(sChar[len-1], tChar[len-1]);
                    usedChars.add(tChar[len-1]);
                }
                else { return false;}
            }
            else {
                if(tChar[len-1] != morphDict.get(sChar[len-1]))
                    return false;
            }
            len--;
        }
        return true;
    }
    
    
    public static boolean isIsomorphic2(String s, String t) {
        int[] m1 = new int[256], m2 =  new int[256];
        int n = s.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (m1[sChar[i]] != m2[tChar[i]]) return false;
            m1[sChar[i]] = i + 1;
            m2[tChar[i]] = i + 1;
        }
        return true;
    }

}
