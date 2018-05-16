package hackerrank.BitManipulation;

import java.util.Scanner;

public class CounterGame {
	static String counterGame(long n) {
	       int count = 0;
	       long temp = n;
	        while(n > 1){
	            
	            if(( n & ( n - 1)) == 0){
	                  n = (n >> 1); // half n value;
	               
	            }else{
	                n = n | n >> 1;
	                n = n | n >> 2;
	                n = n | n >> 4;
	                n = n | n >> 8;
	                System.out.println( (n +1 ) >> 1);
	                temp -= ( ( n + 1 ) >> 1); 
	                n =temp;
	            }
	            
	            
	            count++;
	            
	        }

	        return (count % 2 == 1)?"Louise":"Richard";
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            long n = in.nextLong();
	            String result = counterGame(n);
	            System.out.println(result);
	        }
	        in.close();
	    }
}
