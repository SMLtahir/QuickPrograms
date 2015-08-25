package bitManipulation;

public class SampleUsage {

	public static void main(String[] args) {

		int number1 = 1024;
		int number2 = -1;
		
		//Display numbers in bit representation
		System.out.println("Number1: "+ Integer.toBinaryString(number1));
		System.out.println("Number2: "+ Integer.toBinaryString(number2));
		
		//Count nr of different bits
		int nrDiffBits = countBits(number1^number2);
		System.out.println("Nr of different bits: "+ nrDiffBits);
		
		//Check if ith bit is set
		int i = 3;
		System.out.println("Bit "+ i + " in "+ Integer.toBinaryString(number1)+ " is set: "+ ( ((number1>>i)&1)==1? true: false ));
		
		//Check if number is a power of 2
		System.out.println(getBinary(number1)+ " is a power of two: "+ ( (number1 & (number1 -1))==0? true: false) );
		
		//Find number with only the most significant digit set
		int x = 0b101110001100011000100;
		System.out.println("Number where only the most significant digit of "+ getBinary(x)+ " is set: "+ getBinary(getMostSignificant(x)));
		
		//Testing...		
		System.out.println("Test: "+ Integer.toBinaryString(1));
		
		//Get Hamming weight
		int h = 2147483647;
		System.out.println("Hamming weight for "+ h+ " is: "+ hammingWeight(h));
		
		//Get reverse bit number
		x = 1;
		System.out.println("Reverse bit number for "+ Integer.toBinaryString(x) + " is: "+ reverseBits(x) );
		
		//Add Two binary strings
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println("Addition of "+ a + " and "+ b + " is: "+  addBinary(a, b));
	}
	
	/**
	 * Displays in binary form
	 * @param number
	 * @return
	 */
	public static String getBinary(int number)	{
		return Integer.toBinaryString(number);
	}
	
	private static int getMostSignificant(int y) {

		y = y | ( y >>1 ) ;        
		y = y  | ( y >>2 );            
		y = y  | ( y >>4 );            
		y = y  | ( y >>8 );            
		y = y  |  ( y >>16 );
		return ((y+1) >>1);
	}

	private static int countBits(int number)	{
		boolean negFlag = false;
		if(number < 0)	{ 
			negFlag = true;
			number = ~number;
		}
		
		int result = 0;
		while(number != 0)	{
			result += number & 1;
			number = number >> 1;
		}
		return negFlag? (32-result): result;
	}
	
	/**
	 * Returns the number of bits in an unsigned integer represented in binary form
	 */
	public static int hammingWeight(int n) {
		// Treat n as an unsigned value
		int ones = 0;
        while(n != 0) {
            if((n & 1) == 1) { ones++;}
            n = n>>>1;
        }
        return ones;
    }
	
	/**
	 * Returns a 32-bit integer with bits reverse to the unsigned integer input
	 */
	public static int reverseBits(int n) {
        
        int bits = 32;
        int m = 0;
        while(bits != 0 && n != 0) {
            if((n & 1) == 1) {
                m = m | 1;
            }
            if(bits >= 1) {
            	n = n>>>1;
                m = m<<1;	
            }
            bits--;
        }
        return (m << (bits-1));
    }
	
	/**
	 * Add 2 binary strings and outputs result in string form too
	 */
	public static String addBinary(String a, String b) {
        
        //Trivial cases
        if(a == null || a.isEmpty()) 
            return b;
        if(b == null || b.isEmpty()) 
            return a;
        
        int indA = a.length() - 1;
        int indB = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(indA >= 0 || indB >= 0 || carry == 1) {
            int resA = (indA >= 0) ? Character.getNumericValue(a.charAt(indA--)) : 0;
            int resB = (indB >= 0) ? Character.getNumericValue(b.charAt(indB--)) : 0;
            int digit = resA ^ resB ^ carry;
            carry = ((resA + resB + carry) >= 2) ? 1 : 0;
            sb.append(digit);
        }
        return sb.reverse().toString();
    }

}
