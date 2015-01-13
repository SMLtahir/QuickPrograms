package mathematical;

/**
 * Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. The test cases are the main part of this problem.
LeetCode Question: https://oj.leetcode.com/problems/string-to-integer-atoi/
 * @author Tahir Sousa
 *
 */
public class AToI {
	
	private static final int INT_MAX = 2147483647;
    private static final int INT_MIN = -2147483648;
    
    private static final String INPUT = "9223372036854775809";
    
	public static void main(String[] args) {

		System.out.println("Input: "+ INPUT+ "\nOutput: "+ atoi(INPUT));

	}

public static int atoi(String str) {
        
        //Handle empty string
        if(str.equals(""))    return 0;
        
        char[] chArr = str.trim().toCharArray();   //Trims leading/ trailing spaces but not spaces in between
        boolean negFlag = false;
        int len = 0;
        
        int ch = chArr[0];
        long longNr = 0L;
        if(ch == '-')    {                                   //ASCII for - = 45
            negFlag = true;
            len = chArr.length;
        }
        else if(ch == '+')   { len = chArr.length;}          //ASCII for + = 43
        else if(ch< '0' || ch > '9')  return 0;               //Normal: chars 0-9: ASCII 48-57
        else    {
            len = chArr.length -1;
            longNr = (long)(ch - '0');
        }
        
        /*This is to stop checking after the INT overflow limits are reached. If this is not done, then long limits will also have to   checked, etc. which becomes very complicated.*/
        for(int i=1; i< chArr.length && -longNr > INT_MIN; i++)  {
            ch = chArr[i];
            if((ch < '0') || (ch > '9'))   break;   //Break and return whatever is stored
            else    {
                longNr = longNr*10 + (long)(ch - '0');
            }
        }
        if(negFlag)	longNr = -longNr;
        
        //Check for int overflows - Return INT_MIN/MAX in case of overflows
        if(longNr < INT_MIN)    return INT_MIN;
        else if(longNr > INT_MAX)    return INT_MAX;
        else    { 
            return((int)longNr);
        }
    }
}
