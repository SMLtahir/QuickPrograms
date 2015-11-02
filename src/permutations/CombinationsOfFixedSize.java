package permutations;

public class CombinationsOfFixedSize {

	public static void main(String[] args) {

		String input = "1234";
		int fixedSize = 2;
		printAllCombinations(input, fixedSize, "");

	}
	
	private static void printAllCombinations(String input, int r, String result) {
		if(result.length() == r) { 
			System.out.println(result);
			return;
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			printAllCombinations(input.substring(i+1,input.length()), r, result+ch);
		}
	}

}
