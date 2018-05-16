package algorithms.DP.BASIC;

import java.util.Arrays;

public class fibonnaci {

	static int[] dp;
	
	// Recursive Call
	public int getFibbonaci (int n ) {
		
		if(n <= 0)
			return 0;
		
		if( n == 1 )
			return 1;
		
		return getFibbonaci(n - 1 ) + getFibbonaci(n - 2);
		
	}
	
	// DP method
	public int getFibonacciUsingDp(int val) {
		
		dp[0] = 0; dp[1] = 1;
		
		for(int i = 2; i <= val; i++) {
			dp[i] = dp[i -1] + dp[i-2];
		}
		
		return dp[val];
	}
	
	public static void main(String[] args) {
		int val = 10;
		dp = new int[val + 1];
		System.out.println(new fibonnaci().getFibbonaci(val)); 
		System.out.println(new fibonnaci().getFibonacciUsingDp(val)); 
		System.out.println(Arrays.toString(dp));
		

	}

}
