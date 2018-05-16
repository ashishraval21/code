package algorithms.DP.BASIC;

import java.util.Arrays;

/**
 * 
 * Given 3 numbers {1, 3, 5}, we need to tell
the total number of ways we can form a number 'N' 
using the sum of the given three numbers.
 * @author root
 *
 */
public class SumOfNumbers {
	static int[] cache;
	
	//memoization or top down
	static int solveDP(int n) {
		System.out.println( n  +" -- - - --- - -- > "+Arrays.toString(cache) );
		if(n < 0 )
			return 0;
		if(n == 0)
			return 1;
		
		if(cache[n] != -1)
			return cache[n];
		
		return cache[n] = solveDP(n -1 ) + solveDP(n - 3);
	}
	
	
	// recursion
	static int solve(int n)
	{ 
	   // base case
	   if (n < 0) 
	      return 0;
	   if (n == 0)  
	      return 1;  
	 
	   return solve(n-1) + solve(n-3) + solve(n-5);
	}   

	public static void main(String[] args) {
		
		int val = 5 ;
		cache = new int[val + 1];
		Arrays.fill(cache, -1);
		System.out.println( solveDP(val));
		
		
		System.out.println(" -- - - --- - -- > "+Arrays.toString(cache) );
		
	}

}
