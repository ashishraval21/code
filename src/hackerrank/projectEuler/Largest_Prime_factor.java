package hackerrank.projectEuler;

import java.util.Scanner;

public class Largest_Prime_factor {

	public static void main(String[] args) {
				Scanner in = new Scanner(System.in);
		        int t = in.nextInt();
		        for(int a0 = 0; a0 < t; a0++){
		            long n = in.nextLong();
		            long max = 2;
		            
		            while(n % 2 ==0) {
		            	n = n/2;
		            }
		            
		            for(int i =3; i<= Math.sqrt(n); i+=2) {
		            	while(n % i ==0) {
		            		n = n/i;
		            		max = i;
		            	}
		            	
		            }
		            
		            if(n > max)
		            	max = n;
		            
		            System.out.println( max);
		            
		            
		            
		        }
		    
	
		    }
}
