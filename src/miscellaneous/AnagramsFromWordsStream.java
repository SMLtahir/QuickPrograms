package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Stream of words are coming : ate, geek, tea, for, sam, eat. Build a data structure to store these such that, 
 * if a query was made to search a word: sat tea, it should return all the anagrams : tea, ate, eat present 
 * in the store.
 * @author Tahir
 *
 */
public class AnagramsFromWordsStream {

	public static void main(String[] args) {
		
		addWords("ate");
		addWords("tea");
		addWords("for");
		addWords("sam");
		addWords("eat");
		System.out.println(getWords("sat tea"));

	}
	
	private static Set<String> words = new HashSet<String>();
	private static void addWords(String word) {
		words.add(word);
	}

	private static List<String> getWords(String str) {
		List<String> result = new ArrayList<String>();
		if(str.length() == 0) { return result;}
		// Populate an array with character counts
		int[] arr = new int[256];
		for(int i=0; i< str.length(); i++) {
			int val = (int) str.charAt(i);
			arr[val]++;
		}
		
		// Get all anagrams
		for(String word : words) {
			int[] checkArr = Arrays.copyOfRange(arr, 0, arr.length);
			if(checkWord(checkArr, word)) { result.add(word);}
		}
		return result;
	}

	private static boolean checkWord(int[] checkArr, String str) {
		for(int i=0; i< str.length(); i++) {
			checkArr[str.charAt(i)]--;
			if(checkArr[str.charAt(i)] < 0) { return false;}
		}
		return true;
	}

}
