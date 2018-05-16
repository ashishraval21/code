package algorithms.DP;

public class Longest_Common_Subsequence {
	
	// complexity O(2^n)
	static int getLCSusingRecursion(char[] x, char[] y, int m , int n  ) {
		
		if(m == 0 || n==0 )
			return 0;
		if(x[m-1] == y[n - 1])
			return 1 + getLCSusingRecursion(x, y, m-1, n-1);
		else
			return Math.max(getLCSusingRecursion(x, y, m-1, n), getLCSusingRecursion(x, y, m, n-1));
	}
	
	
	static int getLCSwithoutRecursion(char[] x, char[] y, int m , int n) {
		int[][] lcs = new int[m+1][n+1];
		// note : L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
		for(int i = 0; i <=m; i++) {
			
			for (int j =0; j <=n; j++) {
				
				if(i == 0 || j ==0)
					lcs[i][j] = 0;
				else if( x[i-1] == y[j-1])
					lcs[i][j] = lcs[i-1][j-1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
			
		}
		
		for (int i =0; i <=m; i++)	{
			for(int j=0;j<=n;j++) {
				System.out.print(" "+lcs[i][j]);
			}
			System.out.println();
		}
		
		
		return lcs[m][n];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		
		System.out.println( getLCSusingRecursion(str1.toCharArray(), str2.toCharArray(),str1.length(), str2.length()));
		
		System.out.println( getLCSwithoutRecursion(str1.toCharArray(), str2.toCharArray(),str1.length(), str2.length()));
		
	}

}
