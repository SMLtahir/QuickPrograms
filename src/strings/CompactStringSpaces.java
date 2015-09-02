package strings;

public class CompactStringSpaces {

	private static final String INPUT = "The fox     jumped over    the    moon!";
	public static void main(String[] args) {

		System.out.println("Original String: "+ INPUT+ "\n"+ compactSpaces(INPUT));

	}
	
	public static String compactSpaces(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == ' ') {
				sb.append(ch);
				while(str.charAt(i) == ' ' && i < str.length()) {
					i++;
				}
			}
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

}
