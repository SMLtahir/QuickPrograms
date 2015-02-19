package bitManipulation;

/**
Given an integer, print the next smallest and next largest number that have the same
number of 1 bits in their binary representation
 * @author Tahir
 *
 */
public class SameBitNumbers {

	private static int INPUT = 1234;
	
	public static void main(String[] args) {

		int[] neighbours = getNeighbouringSameBitNumbers(INPUT);
		System.out.println("Higher: "+ neighbours[0]+ " Lower: "+ neighbours[1]);

	}
	
	/**
	 * Returns the next smallest and next highest numbers having the same number
	 * of bits as the original input number. This does not handle negative numbers.
	 * @param n
	 * @return
	 */
	private static int[] getNeighbouringSameBitNumbers(int n)	{
		int[] neighbours = new int[2];
		if(n == Integer.MAX_VALUE || n<=0)	return neighbours;
		
		int thisBits = getBits(n);
		
		//Find next highest with same number of bits
		int high = n+1;
		while(true && high < Integer.MAX_VALUE)	{
			if(getBits(high) == thisBits)	{
				break;
			}
			high++;
		}
		neighbours[0] = (high == Integer.MAX_VALUE)? 0: high;
		
		//Find previous number with same number of bits
		int low = n-1;
		while(true && low > 0)	{
			if(getBits(low) == thisBits)	{
				break;
			}
			low--;
		}
		neighbours[1] = (low == Integer.MIN_VALUE)? 0: low;	
	
	
		return neighbours;
	}
	
	/**
	 * Returns number of bits in the input binary number
	 * @param number
	 * @return
	 */
	private static int getBits(int number)	{
		int nrBits = 0;
		while(number>0 && nrBits<=32)	{
			nrBits += number%2;
			number = number>>1;
		}
		return nrBits;
	}

}
