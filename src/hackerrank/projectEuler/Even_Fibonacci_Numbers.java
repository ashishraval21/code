package hackerrank.projectEuler;

import java.util.Scanner;

public class Even_Fibonacci_Numbers {

	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while( t > 0 ) {
			n = sc.nextInt();
			long a =1, b =1;
			long temp = 0;
			long sum =0;
			while(true) {
				
				temp = a + b;
				if(temp > n)
					break;
				if(temp%2 ==0)
					sum+=temp;
				a=b;
				b=temp;
				
				
			}
			System.out.println(sum);
			t--;
		}

	}

}
