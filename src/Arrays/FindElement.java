package Arrays;

import java.util.Random;

public class FindElement {

	private static int TIME_COMP_CONSTANT = 0;
	
	public static void main(String[] args) {

		/////
		//Find min element in a sorted rotated array
		//A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2  How would you find the minimum element?
		/*int[] sortedRotatedArray = {4,5,6,7,8,9,10,11,12,13,14,15,1,2,3};
		int minElement = sortedRotatedArray[getMinElement(sortedRotatedArray)];
		System.out.println("\nMin Element: "+ minElement);
		System.out.println("\nTime Complexity factor for this run: "+ TIME_COMP_CONSTANT);*/
		/////
		
		/////
		//Rotate image by 90 degrees
		double[][] image = new double[3][3];
		image[0][0] = 10;
		image[0][1] = 11;
		image[0][2] = 12;
		image[1][0] = 20;
		image[1][1] = 21;
		image[1][2] = 22;
		image[2][0] = 30;
		image[2][1] = 31;
		image[2][2] = 32;
		
		rotateImage(image);
		/////
		
		
		String str = "abc";
		
		Character ch = str.charAt(0);
		System.out.println("Test complete");

	}

	private static void rotateImage(double[][] image)	{
		for(int i=0; i< image.length; i++)	{
			for(int j=i; j< image.length; j++)	{
				double temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
			System.out.println("Testing...");
		}
	}
	
	private static int getMinElement(int[] sortedRotatedArray)	{
		int minIndex = 0;
		int maxIndex = sortedRotatedArray.length - 1;
		
		System.out.println("Array size: "+ sortedRotatedArray.length+ "\n");
		for(;maxIndex != minIndex + 1;)	{
			TIME_COMP_CONSTANT++;
			int rand = new Random().nextInt(maxIndex - minIndex);
			int randIndex = rand == 0? minIndex+ 1: minIndex + rand;

			if(sortedRotatedArray[randIndex] > sortedRotatedArray[minIndex])	minIndex = randIndex;
			else if(sortedRotatedArray[randIndex] < sortedRotatedArray[maxIndex])	maxIndex = randIndex;
			System.out.print("Min: "+ minIndex+"\t");
			System.out.println("Max: "+ maxIndex);
		}
		
		//Handle test case where sorted array is not rotated: 
		if (sortedRotatedArray[minIndex] < sortedRotatedArray[maxIndex])	{
			System.out.println("Array not rotated!");
			return(0);
		}
		return(maxIndex);
	}
}
