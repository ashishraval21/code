package bitExamples;

import java.util.Scanner;

public class NumberOfOnes {
	
	static int getCountNumberOfOnes(int number) {
		int count =0;
		while( number > 0 ) {
			System.out.println( number);
			number = ( number & (number - 1));
			count++;
			
			
		}
		return count;
		
	}
	
	

	public static void main(String[] args) {
		int value = new Scanner(System.in).nextInt();
		
		System.out.println("Number of 1's in value "+ value+" -> "+getCountNumberOfOnes(value)); 

	}

}
