package algorithms.DP;

import java.util.Arrays;

public class Longest_Repeated_Subsequence {

	static int dp[][];
	
	static int getRepeatedString(String str) {
		
		
		for(int i = 1 ; i <= str.length(); i++) {
			
			for (int j = 1; j <= str.length(); j++) {
				
				if(str.charAt(i-1) == str.charAt(j-1) && i != j)
						dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		
		
		return dp[str.length()][str.length()];
	
	}
	
	
	static int recursion(String str, String check, int i, int j ) {
		if( i == 0  || j == 0)
			return 0;
		if(str.charAt(i - 1) == check.charAt(j - 1) && i !=j )
			return 1 + recursion(str, check, i-1, j-1);
		
		return Math.max(recursion(str, check , i-1, j) , recursion(str, check, i, j-1));
	}
	
	static int getRepeatedStringRecursion(String str) {
		return recursion(str, str, str.length(), str.length());
		
	}
	
	
	
	public static void main(String[] args) {
		String str = "AABEBCDD";
		dp = new int[str.length()+1][str.length()+1];
		for(int i = 0; i< dp.length; i++)
			Arrays.fill(dp[i], 0);
		System.out.println( getRepeatedString(str));
		System.out.println(getRepeatedStringRecursion(str));
	}

}
