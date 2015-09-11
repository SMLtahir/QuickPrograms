package strings;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Tahir
 *
 */
public class LongestSubstringNoRepeatingChars {

	private static final String INPUT = "adbabcabdbaccddbaadcdb";
	public static void main(String[] args) {

		System.out.println("Length of longest substring without repeating characters: "+ lengthOfLongestSubstring(INPUT));

	}
	
	public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i=0, j=0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, 1+ i-j);
        }
        return max;
    }

}
