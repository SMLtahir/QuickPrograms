package bitManipulation;

/**
 * Multiply 2 numbers without using the * operator.
 * @author Tahir
 *
 */
public class Multiplication {

	
	private static final int X = 8;
	private static final int Y = -2;
	public static void main(String[] args) {

		System.out.println(X+ " x "+ Y+ " = "+ bitMultiply(X,Y)+ " = "+ X*Y+ "?");
	}
	
	public static int bitMultiply(int x, int y) {
		
		//Trivial cases
		if(x ==0 || y == 0) return 0;
		if(x == 1) return y;
		if(y == 1) return x;
		boolean isNegative = false;
		if(x < 0 && y < 0) { isNegative = false;}
		else if(x < 0 || y < 0) { isNegative = true;}
		
		int small = (x < y)? x: y;
		int big = (x > y)? x: y;
		int result = 0;
		int timeSteps = 0;
		
		while(Math.abs(small) != 1) {
			timeSteps++;
			if(small%2 == 0) {
				small = small/2;
				big = big << 1;
			} else {
				small--;
				result = result + big;
			}
		}
		System.out.println("Timesteps taken: "+ timeSteps);
		result = result + big;
		return !isNegative? result: -result;
	}

}
