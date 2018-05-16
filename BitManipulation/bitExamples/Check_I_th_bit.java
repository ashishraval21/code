package bitExamples;

import java.util.Scanner;

/**
 * Check if the ith bit is set in the binary form of the given number.
 * 
 * @author ashish
 * 
 * Let’s say N = 20 = {10100}2. Now let’s check if it’s 2nd bit is set or not(starting from 0). 
 * For that, we have to AND it with 22 = 1<<2 = {100}2 .
	{10100} & {100} = {100} = 22 = 4(non-zero number), which means it’s 2nd bit is set. 
 *
 */
public class Check_I_th_bit {

	
	static boolean checkIthBit(int n , int i) {
		int check = n & (1 << i );
		System.out.println(" check value "+ check);
		if(check > 0)
			return true;
		else
			return false;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println( checkIthBit(sc.nextInt(), 1));

	}

}
