package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the Kth permuatation of numbers from 0 to N.
 * N can be a maximum of 9
 * @author Tahir
 *
 */
public class KthPermutation {

	public static int[] fact;
	public static void main(String[] args) {

		int N = 3;
		int K = 24;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=N;i++) {
			list.add(i);
		}
		fact = new int[N+2];	// Since numbers are starting from 0
		getKthPerm(N, K, list, 0);
	}
	
	public static void getKthPerm(int N, int K, List<Integer> list, int start) {
		if(list.size() == 0) { return;}
		int max = factorial(list.size());
		if(K > start + max) { return;}  // Not possible
		for(int i=0;i< list.size(); i++) {
			int nextCombos = fact[list.size()-1];
			if(start+nextCombos < K) {
				start += nextCombos;
				continue;
			}
			System.out.println(list.get(i));
			list.remove(i);
			getKthPerm(N, K, list, start);
			break;
		}
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
