package mathematical;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example,
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * @author Tahir Sousa
 *
 */
public class ExcelConvert {

	public static void main(String[] args) {

		int input = 1000000;
		
		System.out.println("By method 1: "+ convertToTitle1(input));
		System.out.println("By method 2: "+ convertToTitle2(input));
		System.out.println("By method 3: "+ convertToTitle3(input));
	}
	
	public static String convertToTitle3(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
	
	public static String convertToTitle2(int n) {
		if(n == 0)	{return "";}
		else	{
			n--;
			return convertToTitle2(n / 26) + (char) ('A' + n % 26);	
		}
		
	}
	
    public static String convertToTitle1(int n) {
        //Find number of characters needed to express the column name
        int nrOfChars = getNrChars(n);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int result = n;
        while(result !=0)    {
            int quotient = (int) (result/Math.pow(26, nrOfChars-1));
            if((int) (result - quotient*Math.pow(26, nrOfChars-1)) == 0 && nrOfChars> 1)	{
            	quotient = quotient -1;
            }
            sb.append(getExcelChar(quotient));
            result =  (int) (result - quotient*Math.pow(26, nrOfChars-1));
            nrOfChars--;
        }
        return sb.toString();
    }
    
    public static String getExcelChar(int x)   {
        return ( new Character((char)(x+64)).toString() );
    }
    
    public static int getNrChars(int n)    {
        int chars = 0;
        if(n > 0)   {chars = 1;}
        
        int exp = 0;
        while(true)  {
            int sum = 0;
            for(int i=0; i<= exp; i++)   {
                sum += 26*Math.pow(26,i);
            }    
            if(n > sum) {
                exp++;  
            }
            else {
                chars = exp+1;
                break;
            }
        }
        return chars;
    }

}