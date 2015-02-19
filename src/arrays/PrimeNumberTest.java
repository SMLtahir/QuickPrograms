package arrays;

import java.util.ArrayList;

/**
 * Find whether a given number is prime
 * @author Tahir
 *
 */
public class PrimeNumberTest {

	private static final int INPUT = 677778;
	
	public static void main(String[] args) {

		System.out.println("The number is prime: "+ isPrime(INPUT));
		System.out.println("Factors are "+ getFactors(INPUT).toString());
	}
	
	public static boolean isPrime(int n)	{
		if(n <= 1)	return false;
		if(n <= 3)	return true;
		for(int i=2; i< Math.sqrt(n); i++)	{
			if(n%i == 0)	return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> getFactors(int number)	{
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int check = 1;
		
		// Check for divisibility by 2 and 3 
		while(number%2 == 0)	{
			number = number/2;
			list.add(2);
			check *= 2;
		}
		while(number%3 == 0)	{
			number = number/3;
			list.add(3);
			check *= 3;
		}

		// Quickly find whether prime or not
		for(int i=5; i<= number;)	{
			if(number % i == 0)	{ 
				number = number/i;
				list.add(i);
				check *= i;
				continue;
			}
			if(number % (i+2) == 0)	{ 
				number = number/(i+2);
				list.add(i+2);
				check *= (i+2);
				continue;
			}	
			i= i+6;
		}
		System.out.println("Check: "+ check);
		return list;
	}

}
