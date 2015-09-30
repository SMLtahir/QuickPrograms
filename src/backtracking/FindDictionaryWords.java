package backtracking;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
Given a string, check whether it can be broken down into a list of words found in a dictionary.
Return the words if so.
 * @author Tahir
 *
 */
public class FindDictionaryWords {

	private static final String INPUT = "peanutbutter";
	private static final String[] WORDS = {"pea","nut","peanut","butter"};
	public static void main(String[] args) {

		setDictionary(WORDS);
		System.out.println(findWords(INPUT).toString());

	}
	
	static Map<String, Boolean> dict = new HashMap<String, Boolean>();
	private static void setDictionary(String[] words) {
		for(String w : words) {
			dict.put(w, true);
		}
	}
	
	public static List<String> findWords(String str) {
		return findWords(str, 0, str.length());
	}

	public static List<String> findWords(String str, int start, int end) {
		List<String> words = new ArrayList<String>();
		for(int i=start+1; i<= end; i++) {
			String w = str.substring(start, i);
			if(dict.containsKey(w)) {
				List<String> remWords = findWords(str, i, end); 
				if(remWords.size() != 0 || i == end) {
					words.add(w);
					words.addAll(remWords);
					return words;
				}
			}
		}
		return words;
	}
}
