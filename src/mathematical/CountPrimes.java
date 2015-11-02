package mathematical;

/**
Count the number of prime numbers less than a non-negative number, n.
 * @author Tahir
 *
 */
public class CountPrimes {

	private static final int NUMBER = 100;
	public static void main(String[] args) {
		
		System.out.println("Number of primes less than "+ NUMBER+ ": "+ countPrimes(NUMBER));

	}

    public static int countPrimes(int n) {
	    if (n<=2) return 0;
	    int[] passed = new int[n];
	    System.out.println(2);
	    int sum = 1;
	    int upper = (int) Math.sqrt(n);
	    for (int i= 3; i< n; i+= 2) {
	        if (passed[i] != 1) {
	            sum++;
	            System.out.println(i);
	            //avoid overflow
	            if (i>upper) continue;
	            for (int j=i*i; j<n; j+=i) {
	                passed[j] = 1;
	                
	            }
	        }
	    }
        return sum;
    }

}
