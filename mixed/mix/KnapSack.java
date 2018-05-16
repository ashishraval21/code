package mix;

import java.util.Arrays;

public class KnapSack {

	static long knapsackProbllem(int[][] arr, int maxWeight) {

		long sum = 0;
		for (int i = 0; i < (1 << arr.length - 1); i++) {
			long temp = 0;
			long tempSum = 0;
			for (int j = 0; j < arr.length - 1; j++) {

				// getting position of 1 from i, one by one.
				if ((i & (1 << j)) > 0 && temp + arr[j][0] <= maxWeight) {
					temp += arr[j][0];
					tempSum += arr[j][1];
					// System.out.print(j+" "+arr[j][0] + " --- "+arr[j][1]+" ");

				}

			}

			// System.out.println(tempSum +"\n \n \n");
			if (tempSum > sum)
				sum = tempSum;

		}
		return sum;

	}

	static int knapSackUsingBottomUpManner(int[][] arr, int maxWeight) {
		int knapSack[][] = new int[arr.length + 1][maxWeight + 1];

		for (int i = 0; i <= arr.length; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				if (i == 0 || j == 0)
					knapSack[i][j] = 0;
				else if (arr[i - 1][0] <= j) {
					knapSack[i][j] = Math.max(knapSack[i - 1][j], arr[i - 1][1] + knapSack[i - 1][j - arr[i - 1][0]]);
				} else
					knapSack[i][j] = knapSack[i - 1][j];

			}
			System.out.println( Arrays.toString(knapSack[i]));
		}
		return knapSack[arr.length][maxWeight];
	}

	public static void main(String[] args) {
		int[][] items = { { 2, 4 }, { 1, 3 }, { 2, 7 }, { 3, 9 }, { 4, 5 }, { 5, 9 } };

		int maxWeight = 7;
		System.out.println(knapsackProbllem(items, maxWeight));
		System.out.println(knapSackUsingBottomUpManner(items, maxWeight));
		System.out.println(getKnapsackProblem(items, maxWeight));
	}
	
	
	
	
	
	
	
	static int getKnapsackProblem(int[][] arr , int maxheight) {
		
		int[][] knapSack = new int[arr.length + 1][maxheight + 1];
		
		for(int i =0; i <= arr.length; i++) {
			
			for(int j = 0; j <= maxheight; j++) {
				if(i == 0 || j ==0)
					 knapSack[i][j] = 0;
				else if( arr[i-1][0] <= j) {
					knapSack[i][j] = Math.max(knapSack[i-1][j],  arr[i-1][1] + knapSack[i-1][j - arr[i-1][0]]);
				}
				else {
					knapSack[i][j] = knapSack[i-1][j];
				}
			}
			
		}
		
		
		
		return knapSack[arr.length][maxheight];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
