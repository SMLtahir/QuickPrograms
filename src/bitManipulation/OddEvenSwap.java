package bitManipulation;
import bitManipulation.SampleUsage;

/**
Write a program to swap odd and even bits in an integer with as few instructions as
possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
 * @author Tahir
 *
 */
public class OddEvenSwap {

	private static final int INPUT = 0b1110101101100;
	
	public static void main(String[] args) {

		System.out.println("Original Number: "+ SampleUsage.getBinary(INPUT)+ "\nSwapped Number: "+ SampleUsage.getBinary(swapBits(INPUT)));

	}
	
	private static int swapBits(int number)	{
		int oddMask = 0b010101010101010101010101010101010;
		int evenMask = 0b01010101010101010101010101010101;
		
		return (oddMask&number)>>1 | (evenMask&number)<<1;
	}

}
