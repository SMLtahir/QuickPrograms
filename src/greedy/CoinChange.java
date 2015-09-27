package greedy;

public class CoinChange {

	private static final double MONEY = 1.4;
	public static void main(String[] args) {

		int[] change = getChange((int)(100*MONEY)); // Multiplying by 100 as double values often cause precision problems leading to erroneous results 
		
		System.out.println("Change for "+ MONEY+ ": "+ change[0]+ " quarter(s), "+ change[1]+ " dime(s), "+ change[2]+ " nickle(s), "+ change[3]+ " penn(y)(ies).");
		System.out.println(isAnagram("abba", "aabb"));
	}
	
	public static int[] getChange(int amount) {
		int[] change = new int[4];
		while(amount > 0) {
			if(amount >= 25) {
				amount -= 25;
				change[0]++;
			} else if(amount >= 10) {
				amount -= 10;
				change[1]++;
			} else if(amount >= 5) {
				amount -= 5;
				change[2]++;
			} else {
				amount -= 1;
				change[3]++;
			}
		}
		
		return change;
	}
	
	  public static boolean isAnagram(String s, String t) {
	      int[] alphabet = new int[26];
	      for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	      for (int i = 0; i < t.length(); i++) {
	        alphabet[t.charAt(i) - 'a']--;
	        if(alphabet[t.charAt(i) - 'a'] < 0) return false;
	      }
	      for (int i : alphabet) if (i != 0) return false;
	      return true;
	  }

}
