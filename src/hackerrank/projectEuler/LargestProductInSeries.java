package hackerrank.projectEuler;

import java.util.Scanner;

public class LargestProductInSeries {

	public static void main(String[] args) {
		String str ="123", st1 = "123";
		System.out.println(str.compareTo(st1));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String num = in.next();
			int zeroIndex = 0;
			long max_so_far = 1;
			long max = 0;
			for (int i = 0; i < n; i++) {
				max_so_far *= Integer.parseInt(num.charAt(i)+"");
				if (num.charAt(i) == '0') {
					zeroIndex = i;
					if (i < k) {
						max = 0;
						max_so_far = 1;
					}

				} else if ((i) >= (k+zeroIndex)) {
					max_so_far = max_so_far / Integer.parseInt(num.charAt(i-k)+"");
					if(max < max_so_far)
						max = max_so_far;
					
						
				}
			}
			System.out.println(max);
			
			
		

		}

	}

}
