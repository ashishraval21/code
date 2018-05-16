package basics;

import java.util.Scanner;

public class Charpattern1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
			
		while (t > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < n; j++) {
					if ((i + j) % 2 == 0) {
						System.out.print("* ");
					} else {
						System.out.print(". ");
					}
					
				}
				System.out.println();

			}
			t--;
		}

	}

}
