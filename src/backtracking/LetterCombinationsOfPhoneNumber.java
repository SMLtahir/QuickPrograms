package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is to be used.
For example,
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * @author Tahir
 *
 */
public class LetterCombinationsOfPhoneNumber {

	private static final String INPUT = "2345"; 
	public static void main(String[] args) {
		System.out.println(letterCombinations(INPUT).toString());
	}
	
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> combos = new LinkedList<String>();
        if(digits.length() == 0) { return combos;}
        String[] codes = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combos.add("");
        for(int i=0; i< digits.length(); i++) {
            int n = Character.getNumericValue(digits.charAt(i));
            while(combos.peek().length() == i) {
                String old = combos.remove();
                for(int j=0; j< codes[n].length(); j++) {
                    combos.add(old + codes[n].charAt(j));
                }    
            }
        }
        return combos;
    }

}
