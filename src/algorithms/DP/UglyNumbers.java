package algorithms.DP;

import java.util.Arrays;

/**
 * 
 * @author root Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 *         The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11
 *         ugly numbers. By convention, 1 is included.
 */
public class UglyNumbers {

	static int min = 0;
	static int a2 = 0;
	static int a3 = 0;
	static int a5 = 0;
	static int i = 1;
	static int[] arr;

	static long getNthUglyNumbers(int n, int x, int y, int z, int i) {

		if (n == i)
			return min;

		min = Math.min(x, Math.min(y, z));
		arr[i] = min;

		// here we are only multiply with those number who are present in array.
		// so be carefull while implement this.

		return getNthUglyNumbers(n, (x == min) ? arr[++a2] * 2 : x, (y == min) ? arr[++a3] * 3 : y,
				min == z ? (5 * (arr[++a5])) : z, ++i);

	}

	static int uglyNumberBottomUp(int n) {
		a2 = 0;
		a3 = 0;
		a5 = 0;
		int multiple_of_2 = 2, multiple_of_3 = 3, multiple_of_5 = 5;
		arr[0] = 1;
		int min = 1;

		for (int i = 1; i < n; i++) {
			min = Math.min(multiple_of_2, Math.min(multiple_of_3, multiple_of_5));

			arr[i] = min;
			if (min == multiple_of_2) {
				a2 += 1;
				multiple_of_2 = arr[a2] * 2;
			} 
			if (min == multiple_of_3) {
				a3 += 1;
				multiple_of_3 = arr[a3] * 3;

			}
			if (min == multiple_of_5) {
				a5 += 1;
				multiple_of_5 = arr[a5] * 5;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int n = 150;
		arr = new int[150];
		int start = 1;
	//	System.out.println(getNthUglyNumbers(n, 2, 3, 5, start));
		Arrays.fill(arr, 0);
		System.out.println(uglyNumberBottomUp(150));

	}

}
