package algorithms.DP;

import java.util.Arrays;

public class Equal {

	static int count = 0;
	static int[] values = { 1, 3, 5 };
	static long[] temp = new long[100];

	static long check(long temp) {
		long x = 0;
		if (temp >= 5) {
			x = temp / 5;
			temp = temp % 5;
		}
		if (temp >= 2) {
			x += temp / 2;
			temp = temp % 2;
		}
		x += temp;
		return x;

	}

	static long equal(int[] arr) {
		int n = arr.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		long[] sum = new long[6];
		for (int j = 0; j <= 5; j++) {
			sum[j] = 0;
			for (int i = 0; i < n; i++) {
				if(min == arr[i])
					continue;
				long temp = Math.abs(arr[i] - (min - j));
				sum[j] = sum[j] + check(temp);
			}
			System.out.println(Arrays.toString(sum));
		}
		long minn = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			if (minn > sum[i])
				minn = sum[i];
		}
		System.out.println(Arrays.toString(sum));
		return minn;
	}
	

	public static void main(String[] args) {
		int[] arr = { 2, 2, 3, 7 };
		System.out.println(equal(arr));

	}

}
