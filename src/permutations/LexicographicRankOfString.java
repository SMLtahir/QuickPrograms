package permutations;

/**
 * Given a string, find its rank among all its permutations sorted lexicographically. 
 * For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.
Assume that the string does not contain any duplicated characters.

Note: The above programs don’t work for duplicate characters. To make them work for duplicate characters, find all the characters that are 
smaller (include equal this time also), do the same as above but, this time divide the rank so formed by p! where p is the count of 
occurrences of the repeating character. [http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/]
 * @author Tahir
 *
 */
public class LexicographicRankOfString {

	private static int[] fact;
	public static void main(String[] args) {

		String input = "string";
		fact = new int[input.length()+1];
		System.out.println("Rank is: "+ lexoRank(input));
		
	}
	
	private static int lexoRank(String s) {
		int rank = 0;
		if(s.length() == 0) { return 0;}
		for(int index=0;index<s.length()-1;index++) {
			int ch = s.charAt(index);
			int lowerRanks = 0;
			for(int i=index+1;i<s.length();i++) {
				if((int) s.charAt(i) < ch) { lowerRanks++;}
			}
			rank += lowerRanks*factorial(s.length()-index-1);
		}
		return rank+1;
	}

	public static int factorial(int n) {
		if(fact[n] != 0) { return fact[n];}  // If already calculated
		if(n == 0) {
			fact[0] = 1;
			return fact[0];
		}
		if(n == 1) {
			fact[1] = 1;
			return fact[1];
		}
		fact[0] = 1;
		fact[1] = 1;
		for(int i=2;i<= n;i++) {
			fact[i] = fact[i-1]*i;
		}
		return fact[n];
	}
}
