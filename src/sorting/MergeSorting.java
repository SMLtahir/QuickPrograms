package sorting;

import java.util.Scanner;

/**
 * Performs the merge-sort algorithm on a given list
 * @author Tahir
 *
 */
public class MergeSorting {

	public static void main(String[] args) {
		int length_of_array;
		System.out.println("Enter length of array to sort. A random array of this length will be created.");
		Scanner in = new Scanner(System.in);
		length_of_array = in.nextInt();
		int A []=new int[length_of_array],i;
		
		for(i=0;i<length_of_array;++i) {
			A[i]=(int)(Math.random()*100);
			System.out.print(A[i]+" ");
		}
		
		A=MergeSort(A);
		System.out.println();
		
		for(i=0;i<length_of_array;++i)
		{
			System.out.print(A[i]+" ");
		}
	}
	
	//Merge two sorted arrays in place. Assume nums1 has space = m+n-1 where m, n are spaces of the two arrays.
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
	
	//Perform the mergesort algorithm
	public static int[] MergeSort(int [] A)	{
		if(A.length==1)	{ return A;}
		
		else {
			int n=(int) A.length/2;
			int[] B = new int[n];
			int[] C = new int[A.length-n];
			int i;
			
			for(i=0; i<A.length; i++) {
				if(i<n)
					B[i]=A[i];
				else
					C[i-n]=A[i];
			}
			B=MergeSort(B);
			C=MergeSort(C);
			A=Merge(B,C);
			return A;
		}
	}
	
	//Merge both sub-lists in sorted order
	public static int [] Merge(int [] A,int [] B)	{
		int C []=new int [A.length+B.length];
		int i,a=0,b=0;
		for(i=0;i<A.length+B.length;++i)
		{
			if(a==A.length)
			{
				C[i]=B[b];
				b++;
			}
			else if(b==B.length) {
				C[i]=A[a];
				a++;
			}
			
			else {
				if(A[a]>B[b])
				{
					C[i]=B[b];
					b++;
				}
				else {
					C[i]=A[a];
					a++;
				}				
			}

		}
		return C;		
	}

}
