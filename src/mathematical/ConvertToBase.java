package mathematical;

/**
 * Converts to any base depending on inputs
 * @author Tahir Sousa
 *
 */
public class ConvertToBase {

	private static final int base = 5;
	private static final int input = 100;
	
	public static void main(String[] args) {
		
		String solution = convertToBaseN(input, base);
		System.out.println("Converted number to base "+ base+ " : "+ solution);
		String abc = "()";
		if(abc.contains("."))	System.out.println("Success!");

	}
	
	public static String convertToBaseN(int input, int base)	{
		if(input == 0)	return "";
		else	{
			return convertToBaseN(input/base, base) + (input%base);
		}
	}

}
