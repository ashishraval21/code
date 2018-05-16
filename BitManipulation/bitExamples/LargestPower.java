package bitExamples;

import java.util.Scanner;

public class LargestPower {
	
	
	static long largestPower(long N) {
		N = N| (N>>1);
		System.out.println(N);
        N = N| (N>>2);
        System.out.println(N);
        N = N| (N>>4);
        System.out.println(N);
        N = N| (N>>8); 
        System.out.println(N| (N>>8));
        
		return (N+1) >> 1;
	}
	
	

	public static void main(String[] args) {
	long value = new Scanner(System.in).nextLong();
	System.out.println(   largestPower(value)  );
	
	}

}
