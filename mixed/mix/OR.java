package mix;

import java.util.HashMap;
import java.util.Scanner;

public class OR {
	static int counttt =0;
	static int getMaxSubsetSum(int[] arr, int n, int max, int count) {
		if( n < 0)
			return count;
		System.out.println( ""+(counttt+= arr[n]) +"    "+arr[n] ) ;
		
		return Math.min(getMaxSubsetSum(arr, n-1, max, count),
					getMaxSubsetSum(arr, n, max -  (max | arr[n]), count));
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		while( n > 0 ) {
			int size = sc.nextInt();
			int[] array = new int[size];
			for(int i =0; i<size; i++) {
				array[i] = sc.nextInt();
			}
			
			System.out.println(getMaxSubsetSum(array, size-1, 0, 0) +"  "+counttt);
			
			n--;
		}

	}

}
