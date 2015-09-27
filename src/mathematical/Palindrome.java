package mathematical;

public class Palindrome {

	private static final int number = 123454321;
	
	public static void main(String[] args) {

		System.out.println("--By method where extra space is used--");
		System.out.println(number+ " is a Palindrome: "+ isPalindrome1(number));

		System.out.println("\n\n--By method where extra space is not used--");
		System.out.println(number+ " is a Palindrome: "+ isPalindrome2(number));
	}
	
	public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        char[] c = str.toCharArray();
        for(int i=0; i< (c.length/2)+ 1; i++)   {
            if(c[i] != c[c.length-1-i]) return false;  
        }
        return true;
    }

	public static boolean isPalindrome2(int x) {
        if(x< 0)    return false;
        if(x>=0 && x< 10)   return true;
        
        int PalinX = 0;
        int tempX = x;
        while(tempX != 0)   {
            PalinX = PalinX*10 + tempX%10;
            tempX = tempX/10;
        }
        return (x == PalinX);
    }
}
