package algorithms.DP;

public class Maximum_Size_Square_Sub_Matrix_with_all_1s {

	static int getSquareSubMatrixSize(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		
		// copy first column from arr.
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = arr[i][0];
		}
		// copy first row from arr.
		for (int i = 0; i < arr[0].length; i++) {
			dp[0][i] = arr[0][i];
		}
		// compute here for previous 3 element for making sqaure.
		// like i-1:j  and i-1:j-1 and  i:j-1 get min from this and update i:j with + 1 value.
		for (int i = 1; i < arr.length; i++) {

			for (int j = 1; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;

				} else {
					dp[i][j] = 0;
				}

			}
		}

		// find maximum entry for find max square sub array.
		int  max_value = dp[0][0], max_i =0, max_j =0;
		for (int i = 1; i < arr.length; i++) {

			for (int j = 1; j < arr[0].length; j++) {
				
				if(max_value < dp[i][j]) {
					max_value = dp[i][j];
					max_i = i; // row index stored
					max_j = j; // column index stored
				}

			}
		}
		
		
		for(int i = max_i; i > max_i - max_value; i--) {
			for(int j = max_j; j > max_j - max_value; j--) {
				System.out.print( arr[i][j]+"  ");
			}
			System.out.println();
		}
		

		return max_value;
	}

	public static void main(String[] args) {
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		System.out.println(getSquareSubMatrixSize(M));
		System.out.println("ava".compareTo("wel"));

	}

}
