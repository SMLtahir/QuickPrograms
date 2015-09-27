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
		String revInput = "BA";
		
		System.out.println("TitleToNumber: "+ titleToNumber(revInput));
//		System.out.println("By method 1: "+ convertToTitle1(input));
//		System.out.println("By method 2: "+ convertToTitle2(input));
//		System.out.println("By method 3: "+ convertToTitle3(input));
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
    
    /**
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        int result = 0;
        // val(ch[i]) = 1+ int(ch[0]) - int('a')
        // len = 1
        // val(ch[0])*26^0
        
        // len = 2
        // 26^1 + ( val(ch[1]) - 1 )*26^1 + val(ch[0])*26^0
        
        // len = 3
        // 26^2 + 26^1 + (val(ch[2]) - 1)*26^2 + ( val(ch[1]) - 1 )*26^1 + val(ch[0])*26^0
        int i = len;
        while(i > 1) {
            result += Math.pow(26, i-1);
            if((int) ch[len- i] != 'a' && (int) ch[len- i] != 'A')
                result += (value(ch[len- i])-1)*Math.pow(26, i-1);
            i--;
        }
        result += value(ch[len- i]);
        return result;
    }
    
    public static int value(char n) {
        int val = 0;
        if((int) n <= 90)
            val = 1+ (int) n - 'A';
        else
            val = 1+ (int) n - 'a';
        return val;
    }

}