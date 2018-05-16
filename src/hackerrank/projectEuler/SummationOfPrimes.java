package hackerrank.projectEuler;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SummationOfPrimes {

	static long[] values = new long[1000000 + 1];

	public static void updateValuesIndex(long n) {

		long sum = 0;

		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (values[i] == -1) {
				sum += i;
				values[i] = sum;
			} else {
				values[i] = sum;
				continue;
			}

			int k = i * 2;
			while (k <= n) {
				values[k] = sum;
				k += i;
			}

		}

		for (int i = (int) (Math.sqrt(n)); i <= n; i++) {
			if (values[i] == -1) {
				sum += i;
				values[i] = sum;
			} else {
				values[i] = sum;
			}

		}

		System.out.println(Arrays.toString(Arrays.copyOfRange(values, 0, 500)));

	}

	static long getwSolutionOfSummationOfPrimes(int n) {

		return values[n];
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Arrays.fill(values, -1);
		updateValuesIndex(t);

		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(getwSolutionOfSummationOfPrimes(n));
		}

	}
}
