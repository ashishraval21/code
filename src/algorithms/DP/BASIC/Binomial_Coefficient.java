package algorithms.DP.BASIC;

import java.util.Arrays;
import java.util.Scanner;

public class Binomial_Coefficient {

	static int[][]  arr ;
			
	public int getCoefficient(int n, int k ) {
		
		if ( k == 0 || k == n)
			return 1;
		
		return getCoefficient(n-1, k-1 ) + getCoefficient(n - 1, k);
	}
	
	public int getBinomialCoefficient(int  n, int k ) {
		
		if(k == 0 || n ==k )
			return 1;
		
		if(arr[n][k] != -1)
			return arr[n][k];
		
		return arr[n][k] = getBinomialCoefficient(n-1, k-1) + 
							getBinomialCoefficient(n-1 , k);
		
		
	}
	
	
	public long getBinomialMin(int n, int k ) {
		
		int max = Math.max(k , n -k);
		int min = Math.min(k,  n-k);
		
		long computeN =1;
		long computeMin =1;
		
		for(int i = n; min > 1; i--)
		{	
			computeN *= i;
			computeMin *= min--;
		}
	return computeN / computeMin;
	}
	
	
	
	
	public static void main(String[] args) {
		int n, k;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[n+1][k+1];
		
		
		for(int  i =0; i<arr.length;i++) {
			Arrays.fill(arr[i], -1);
		}
		long startTime = System.nanoTime();
		System.out.println( new Binomial_Coefficient().getBinomialCoefficient(n, k));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(startTime+"   "+endTime+" "+ totalTime);
		startTime = System.nanoTime();
		System.out.println( new Binomial_Coefficient().getBinomialMin(n, k));
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(startTime+"   "+endTime+" "+ totalTime);
		
		System.out.println(new Binomial_Coefficient().getCoefficient(n, k));
		
	}
}
