package arrays;

public class MoveZerosToEnd {

	private static final int[] INPUT = {1,2,3,0,4,0,5,6,0,0,7,8};
	public static void main(String[] args) {

		int[] output = moveZerosToEnd(INPUT);
		System.out.println();

	}
	
	public static int[] moveZerosToEnd(int[] array) {
		
		for(int i=0, j= array.length-1; i< j; i++) {
			if(array[i] == 0) {
				while(i< j && array[j] == 0) { j--;}
				if(i >= j) break;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		
		return array;
	}

}
