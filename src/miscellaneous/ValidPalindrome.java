package miscellaneous;

/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 * @author Tahir
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
        
        int start = 0;
        int end = s.length() -1;
        
        while(start <= end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) { start++;}
            else if(!Character.isLetterOrDigit(s.charAt(end))) { end--;}
            else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) { return false;}
            else {
                start++;
                end--;
            }
        }
        return true;
    }
	
}
