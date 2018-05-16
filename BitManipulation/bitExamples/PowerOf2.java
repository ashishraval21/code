package bitExamples;

import java.util.Scanner;

/**
 * check if number is power of 2 or not.
 *  
 * @author ashish
 *
 */
public class PowerOf2 {
	
	
	static boolean isPowerOf2(int x) {
		return x != 0 && (x & (x-1)) == 0;
	}

	public static void main(String[] args) {
		int value = new Scanner(System.in).nextInt();
		System.out.println(isPowerOf2(value)); 
			

	}

}
