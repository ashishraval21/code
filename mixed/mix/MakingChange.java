package mix;

import java.util.Arrays;

public class MakingChange {
	static int[] coins = { 2, 8, 1 };

	// bottom-Up
	static int getMakeChangeBottomUp(int n) {
		int[] c = new int[n + 1];
		System.out.println(Arrays.toString(c));
		for (int i = 1; i <= n; i++) {
			int mincount = Integer.MAX_VALUE;
			for (int coin : coins) {
				if( i - coin >= 0 ) {
				int currentCoins = c[i -coin] + 1;
				if(currentCoins < mincount)
					mincount = currentCoins;
				
				}
			}
			c[i] = mincount;
			System.out.println(Arrays.toString(c));
			
		}
return c[n];
	}

	// top down
	static int makeChange(int n) {
		int[] c = new int[n + 1];
		for (int i = 1; i < c.length; i++)
			c[i] = -1;

		return makeChange(n, c);

	}

	static int makeChange(int n, int[] memoize) {

		if (memoize[n] >= 0)
			return memoize[n];

		int minCoins = Integer.MAX_VALUE;

		for (int coin : coins) {
			if (n - coin >= 0) {
				int currentMin = makeChange(n - coin, memoize);
				if (currentMin < minCoins)
					minCoins = currentMin;
			}
		}

		memoize[n] = minCoins + 1;
		System.out.println(Arrays.toString(memoize));
		return memoize[n];

	}

	// recursive
	static int getMinCoinsForNumber(int n) {
		if (n == 0)
			return 0;

		int minCoins = Integer.MAX_VALUE;

		for (int coin : coins) {
			if (n - coin >= 0) {
				int coinsResult = getMinCoinsForNumber(n - coin);
				if (minCoins > coinsResult) {
					minCoins = coinsResult;
				}
			}

		}

		return minCoins + 1;
	}

	public static void main(String[] args) {

		System.out.println(getMinCoinsForNumber(15));
		System.out.println(makeChange(15));
		System.out.println(getMakeChangeBottomUp(15));

	}

}
