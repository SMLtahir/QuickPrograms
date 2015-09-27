package mathematical;

/**
 * Given an integer between 0 and 999,999, print an English phrase that describes the
integer (eg, “One Thousand, Two Hundred and Thirty Four”)
 * @author Tahir
 *
 */
public class WriteNumberInWords {

	public static void main(String[] args) {

		System.out.println(writeInWords(122244));

	}
	
	public static String writeInWords(int n) {
		// Trivial cases
		if(n == 0) { return "zero";}
		
		int lowThree = n % 1000;
		int highThree = (n/1000) % 1000;
		
		String high = (highThree != 0) ? getWords(highThree) + "thousand, " : "";
		String low = (lowThree != 0) ? getWords(lowThree) : "";
		
		return high + low;
	}
	
	public static String getWords(int n) {

		int low = n%10;
		n /= 10;
		int mid = n%10;
		n /= 10;
		int hi = n%10;
		
		String[] ones = {"", "one ", "two ", "three ", "four ", "five ",
				"six ", "seven ", "eight ", "nine "};
		
		String hiDig = (hi != 0) ? ones[hi] + "hundred and " : "";
		String midDig = "";
		
		// Special cases
		if(mid == 1) {
			String[] tens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
								"sixteen", "seventeen", "eighteen", "nineteen"};
			return hiDig + tens[low];
		} else {
			String[] midDigs = {"", "", "twenty ", "thirty ", "forty ", "fifty ", 
									"sixty ", "seventy ", "eighty ", "ninety "};
			midDig = midDigs[mid];
		}
		
		String lowDig = ones[low];
		return hiDig + midDig + lowDig;
		
	}

}
