package hackerrank.projectEuler;

import java.util.Arrays;
import java.util.Scanner;

public class Nth_Prime_Number {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		long t = sc.nextLong();
		long[] arr = new long[10001];
		Arrays.fill(arr, 0);
		 int count = 1;
		 arr[count] = 2;
		for (int i =0; i < t; i++) {
			long n = sc.nextLong();
			
			if(arr[(int) n] == 0) {
				long j = Math.max(arr[count], 3);
				for( ; count < n; j+=2) {
				
					int temp = 1;
					while(temp <= count && arr[temp] != 0 ) {
						if(j % arr[temp] == 0) {
							break;
						}
						temp++;
					}
					
					
					if(temp > count) {
						arr[++count] =  j;
					}
					
					
					
				}
			}
			
			
			
			System.out.println(arr[(int)n]);
		}
		

	}

}
