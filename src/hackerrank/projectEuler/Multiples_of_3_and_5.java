package hackerrank.projectEuler;

import java.util.Scanner;

public class Multiples_of_3_and_5 {

	
	
	
	public static void main(String[] args) {
		int t, value;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t > 0 ) {
			value = sc.nextInt() - 1;
			long sum = 0;
			 if( value >= 3 ) { 
				 int n = ( value  % 3 == 0)? value/3 : (value - (value %3)) / 3;
				 System.out.println( n );
				 sum += (( n )*(2*(3) + (n - 1)*3))/2;
			 }
			 
			 if( value >= 5 ) { 
				 int n = ( value  % 5 == 0)? value/5 : (value - (value % 5)) / 5;
				 System.out.println( n );
				 sum += (( n )*(2*(5) + (n - 1)*5))/2;
			 }
			 
			 if( value >= 15 ) { 
				 int n = ( value  % 15 == 0)? value/15 : (value - (value % 15)) / 15;
				 System.out.println( n );
				 sum -= (( n )*(2*(15) + (n - 1)*15))/2;
			 }
			 
			 
			 System.out.println(sum);
			t--;
		}
		
		
	}
	
}
