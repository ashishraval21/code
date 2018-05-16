package mix;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
	static int[] values;
	static int[] temp;

	static int find(int[] temp, int i) {

		if (temp[i] == -1)
			return i;

		return find(temp, temp[i]);
	}

	static void union(int[] temp, int i, int j) {
		int x = find(temp, i);
		int y = find(temp, j);
		temp[x] = y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		values = new int[n];
		temp = new int[n];
		Arrays.fill(temp, -1);

		for (int i = 0; i < n; i++) {
			values[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int x = find(temp, u - 1);
			int y = find(temp, v - 1);
			union(temp, x, y);
			System.out.println(Arrays.toString(temp));
		}
System.out.println( "abc");
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			if (temp[i] != -1 && values[i] == 1) {
				flag = true;
				int t = temp[i];
				int v = values[i] & values[t];
				while (temp[t] != -1) {
					if (v == 0) {
						flag = false;
						break;
					}
					t = temp[t];
					v = v & values[t];
				}
			}

			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

}
