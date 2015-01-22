package arrays;

/**
 * Find whether a given number is prime
 * @author Tahir
 *
 */
public class PrimeNumberTest {

	private static final int INPUT = 6777898;
	
	public static void main(String[] args) {

		System.out.println("The number is prime: "+ isPrime(INPUT));

	}
	
	public static boolean isPrime(int n)	{
		if(n <= 1)	return false;
		if(n <= 3)	return true;
		for(int i=2; i< Math.sqrt(n); i++)	{
			if(n%i == 0)	return false;
		}
		return true;
	}

}
