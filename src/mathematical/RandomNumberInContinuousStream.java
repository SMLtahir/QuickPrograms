package mathematical;

/**
Given a stream of numbers, generate a random number from the stream. You are allowed to use only O(1) space and the input is in the form of stream, so can’t store the 
previously seen numbers.
Explanation of logic used here: http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
 * @author Tahir
 *
 */
public class RandomNumberInContinuousStream {

	static int count;
	static int result;
	public static void main(String[] args) {

		int stream[] = {1, 2, 3, 4};
	    int n = stream.length;
	 
	    for (int i = 0; i < n; i++)
	        System.out.printf("Random number from first %d numbers is %d \n", i+1, generateRandom(stream[i]));
	}
	
	public static int generateRandom(int x) {
		count++;
		if(count == 1) { result = x;}
		else {
			int i = (int) (Math.random()*((double)(count)));
			if(i == count-1) { result = x;}
		}
		return result;
	}

}
