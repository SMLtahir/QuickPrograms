package bitManipulation;

/**
 * Represent a given decimal number in its binary form
 * @author Tahir
 *
 */
public class BinaryRepresentation {

	private static String INPUT = "245.625";
	public static void main(String[] args) {


		System.out.println("Decimal: "+ INPUT+ "\nBinary: "+ printBinary(INPUT));

	}
	
	private static String printBinary(String n)	{
		//Divide the number into the integer part and the decimal part
		int intPart = Integer.parseInt(n.substring(0,n.indexOf(".")));
		double decPart = Double.parseDouble(n.substring(n.indexOf("."), n.length()));
		
		String intString = "";
		while(intPart != 0)	{
			int r = intPart%2;
			intPart = intPart>>1;
			intString = r + intString;
		}
		
		StringBuilder decSb = new StringBuilder();
		while(decPart != 0)	{
			if(decSb.length() > 32)	return "Error!";
			if(decPart == 1)	{
				decSb.append(1);
				break;
			}
			
			double r = decPart*2;
			if(r >= 1)	{
				decPart = r-1;
				decSb.append(1);
			}
			else	{
				decPart = r;
				decSb.append(0);
			}
		}
		
		return intString + "." + decSb.toString();
	}

}
