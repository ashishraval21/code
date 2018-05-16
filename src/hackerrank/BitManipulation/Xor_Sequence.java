package hackerrank.BitManipulation;

import java.util.Scanner;

public class Xor_Sequence {
	
	static long getSequenceNumber(long n ) {
		int value =(int) n % 4;
		switch(value) {
		case 0: 
			return n;
			
		case 1:
			return 1;
		
		case 2:
			return n +1;
			
		}
		return 0;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
           long value = 0;
           
           
        }
	}

}
