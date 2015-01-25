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

}
