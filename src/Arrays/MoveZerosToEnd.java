package arrays;

public class MoveZerosToEnd {

	private static final int[] INPUT = {1,2,3,0,4,0,5,6,0,0,7,8};
	public static void main(String[] args) {

		int[] output = moveZerosToEnd(INPUT);
		System.out.println();

	}
	
	public static int[] moveZerosToEnd(int[] array) {
		
		for(int i=0; i< array.length; i++) {
			if(array[i] == 0) {
				for(int j = i+1; j< array.length; j++) {
					if(array[j] != 0) {
						array[i] = array[j];
						array[j] = 0;
						break;
					}
					if(j == array.length -1)	
						i = j;
				}
			}
		}
		
		return array;
	}

}
