package mathematical;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows
Example: convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * LeetCode question - "ZigZag Conversion" given on: https://oj.leetcode.com/problems/zigzag-conversion/
 * @author Tahir
 *
 */
public class ZigZagPattern {

	private static final String str = "PAYPALISHIRING";
	private static final int rows = 3;
	
	public static void main(String[] args) {

		System.out.println(convert(str, rows));

	}

	public static String convert(String s, int nRows) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        
        //Initialize StringBuilder
        for(int i=0; i< nRows; i++) { sb[i] = new StringBuilder();}
        
        //Store all characters
        int i =0, y= 0;
        while(i < len)  {
            //Downward motion
            for(int x= 0; x< nRows && i< len; x++, i++) {
                sb[x].append(charArray[i]);
            }
            //Diagonal motion
            for(int x= nRows -2; x> 0 && i< len; x--, i++)  {
                sb[x].append(charArray[i]);
            }
        }
        
        //Get encrypted row-wise data-points
        for(int x= 1; x< nRows; x++)    {
            sb[0].append(sb[x]);
        }
        return sb[0].toString();
    }
}
