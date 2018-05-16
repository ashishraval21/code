package hackerrank.projectEuler;

import java.util.Scanner;

public class Largest_Palindrone_Product {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int maxPalindrome = Integer.MIN_VALUE;
	            for(int i= 101; i< 1000; i++) {
	            	for(int j = i +1; j < 1000 && i * j <n; j++) {
	            		int num = i*j;
	            		if(i % 10 ==0 || j %10 ==0 || num < maxPalindrome)
	            			continue;
	            		
	            		String check = ""+num;
	            		String reverse = new StringBuilder().append(check).reverse().toString();
	            		if(check.equals(reverse)) {
	            			maxPalindrome = num;
	            		}
	            		
	            		
	            		
	            		
	            	}
	            }
	            
	            
	            System.out.println( maxPalindrome);
	            
	        	}
	}

}
