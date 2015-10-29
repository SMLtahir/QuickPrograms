package arrays;

/**
 * Given an array and a window size that is sliding along the array, find the sum of the count of unique elements in each window.
    For example, if the array were 1 2 1 3 3 and window size was three

    First window -      1 2 1 - only two unique = 1
    Second window-  2 1 3 - all unique = 3
    Third window -     1 3 3 - only one unique = 1

    Total = 1+3+1 = 5
    Which is to be returned.
 * @author Tahir
 *
 */
public class UniqueInWindow {

	public static void main(String[] args) {

		int[] input = {1,2,1,3,0};
		System.out.println(getUniqueInWindow(input, 3));

	}
	
	private static int getUniqueInWindow(int[] arr, int k) {
		int unique = 0;
		int uInWindow = 0;
		if(arr.length < k) { return 0;}
		int[] mem = new int[10];
		int i;
		for(i=0; i< k; i++) {
			mem[arr[i]]++;
			if(mem[arr[i]] == 1) { uInWindow++;}
			else { uInWindow--;}
		}
		unique = uInWindow;
		for(i=k; i< arr.length; i++) {
			mem[arr[i]]++;
			if(mem[arr[i]] == 1) { uInWindow++;}
			else if(mem[arr[i]] == 2){ uInWindow--;}
			
			mem[arr[i-k]]--;
			if(mem[arr[i-k]] == 1) { uInWindow++;}
			else if(mem[arr[i-k]] == 0){ uInWindow--;}
			
			unique += uInWindow;
		}
		return unique;
	}

}
