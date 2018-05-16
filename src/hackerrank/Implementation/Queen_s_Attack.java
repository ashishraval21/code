package hackerrank.Implementation;

import java.util.Scanner;

public class Queen_s_Attack {
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		if (n == 1)
			return 0;

		if (k == 0) {

		}
		int top, down, left, right, dtl, dtr, dbl, dbr;

		top = right = n;
		left = down = 1;
		dtl = dbl = 1;
		dtr = dbr = n;
		for (int i = 0; i < obstacles.length; i++) {
			if (obstacles[i][0] == r_q) {
				if (obstacles[i][1] > c_q && obstacles[i][1] < right)
					right = obstacles[i][1] + 1;
				else if (obstacles[i][1] < c_q && obstacles[i][1] > left)
					left = obstacles[i][1] + 1;
			} else if (obstacles[i][1] == c_q) {
				if (obstacles[i][0] > r_q && obstacles[i][0] < top)
					top = obstacles[i][0] + 1;
				else if (obstacles[i][0] < r_q && obstacles[i][0] > down)
					down = obstacles[i][0] + 1;
			}

			else if (Math.abs(r_q - obstacles[i][0]) == Math.abs(c_q - obstacles[i][1])) {

				if (obstacles[i][0] < r_q) {
					if (obstacles[i][1] > c_q && obstacles[i][1] < dbr)
						dbr = obstacles[i][1] + 1;
					else if (obstacles[i][1] < c_q && obstacles[i][1] > dbl) {
						dbl = obstacles[i][1] + 1;
					}
				} else if (obstacles[i][0] > r_q) {
					if (obstacles[i][1] > c_q && obstacles[i][1] < dtr)
						dtr = obstacles[i][1] + 1;
					else if (obstacles[i][1] < c_q && obstacles[i][1] > dtl) {
						dtl = obstacles[i][1];
					}
				}

			}

		}

		int diagonal1 = 0, diagonal2 = 0;

		top = Math.abs(c_q - top);
		right = Math.abs(c_q - right);
		left = Math.abs(c_q - left);
		down = Math.abs(c_q - down);

		if (c_q == r_q) {

			diagonal1 = Math.abs(dtr - r_q) + Math.abs(c_q - dbl);
			diagonal2 = 2 * Math.min((r_q - dtl), (dbr - c_q));
		} else if (r_q > c_q) {
			diagonal1 = Math.abs(dtr - r_q) + Math.abs(c_q - dbl);
			diagonal2 = Math.abs(c_q - r_q); 

		} else if (r_q < c_q) {
			diagonal1 = Math.abs(dtr - c_q) + Math.abs(r_q - dbl);
			diagonal2 = Math.abs(dtl - r_q) + Math.abs(dbr - c_q);
		}

		System.out.println(top + " " + right + " " + left + " " + down + " " + dtl + " " + dbl + " " + dtr + " " + dbr);

		return (top + right + left + down + dtl + dbl + dtr + dbr) - (8 * c_q) - 8;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int r_q = in.nextInt();
		int c_q = in.nextInt();
		int[][] obstacles = new int[k][2];
		for (int obstacles_i = 0; obstacles_i < k; obstacles_i++) {
			for (int obstacles_j = 0; obstacles_j < 2; obstacles_j++) {
				obstacles[obstacles_i][obstacles_j] = in.nextInt();
			}
		}
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println(result);
		in.close();
	}
}
