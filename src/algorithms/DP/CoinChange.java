package algorithms.DP;

import java.util.Arrays;

public class CoinChange {

	static int getCountWays(int[] coins, int N, int size) {

		if (N < 0 || size < 0)
			return 0;

		if (N == 0)
			return 1;

		return getCountWays(coins, N, size - 1) + getCountWays(coins, N - coins[size], size);
	}

	static int getCountWays(int[] coins, int N) {
		int[][] values = new int[N + 1][coins.length];

		for (int i = 0; i < coins.length; i++) {
			values[0][i] = 1;
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j < coins.length; j++) {
				int x = (i - coins[j] >= 0) ? values[i - coins[j]][j] : 0;
				int y = (j >= 1) ? values[i][j - 1] : 0;

				values[i][j] = x + y;
			}

		}

		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(values[i]));
		}

		return values[N][coins.length - 1];
	}

	public static void main(String[] args) {
		int[] coins = { 4, 2, 1 };
		int N = 5;
		System.out.println(getCountWays(coins, N, coins.length - 1));
		System.out.println(getCountWays(coins, N));
	}

}
