package bitManipulation;

public class PalindromeBits {

	private static final int INPUT = 0b11001010011;
	public static void main(String[] args) {

		System.out.println("Binary Number "+ Integer.toBinaryString(INPUT) + " is a palindrome: "+ isPalindrome(INPUT));
	}
	
	public static boolean isPalindrome(int x) {
		int orig = x;
		int rev = 0;
		while(x != 0) {
			rev = (rev << 1) + x%2;
			x = x >> 1;
		}
		return (orig == rev);
	}

}
