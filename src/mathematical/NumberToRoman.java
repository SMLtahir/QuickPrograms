package mathematical;

import java.util.LinkedHashMap;
import java.util.Set;

/**
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
Solution1 uses a LinkedHashMap.
Solution2 which is actually better uses instead simple if... else statements 
 * @author Tahir
 *
 */
public class NumberToRoman {

	private static LinkedHashMap<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();
    static {
        numToRoman.put(1000, "M");
        numToRoman.put(900, "CM");
        numToRoman.put(500, "D");
        numToRoman.put(400, "CD");
        numToRoman.put(100, "C");
        numToRoman.put(90, "XC");
        numToRoman.put(50, "L");
        numToRoman.put(40, "XL");
        numToRoman.put(10, "X");
        numToRoman.put(9, "IX");
        numToRoman.put(5, "V");
        numToRoman.put(4, "IV");
        numToRoman.put(1, "I");
    }

    private static final int INPUT = 1945;

	public static void main(String[] args) {

		NumberToRoman ntr = new NumberToRoman();
		System.out.println(ntr.intToRoman2(INPUT));

	}
	
    public String intToRoman1(int num) {
        Set<Integer> keys = numToRoman.keySet();
        for(int key : keys) {
            if(num >= key) {
                return numToRoman.get(key) + intToRoman1(num-key);
            }
        }
        return "";
    }
    
    public String intToRoman2(int num) {
        if(num>=1000) return "M"+intToRoman2(num-1000);
        if(num>=900) return "CM"+intToRoman2(num-900);
        if(num>=500) return "D"+intToRoman2(num-500);
        if(num>=400) return "CD"+intToRoman2(num-400);
        if(num>=100) return "C"+intToRoman2(num-100);
        if(num>=90) return "XC"+intToRoman2(num-90);
        if(num>=50) return "L"+intToRoman2(num-50);
        if(num>=40) return "XL"+intToRoman2(num-40);
        if(num>=10) return "X"+intToRoman2(num-10);
        if(num>=9) return "IX"+intToRoman2(num-9);
        if(num>=5) return "V"+intToRoman2(num-5);
        if(num>=4) return "IV"+intToRoman2(num-4);
        if(num>=1) return "I"+intToRoman2(num-1);
        return "";
    }

}
