package algorithms.GREEDY;

import java.util.Arrays;
import java.util.Scanner;

// Hackerrank Problem
public class GREEDY_FLOURIST {

	 static int getMinimumCost(int n, int k, int[] c){
		 
		 int sum = 0 ;
		 Arrays.sort(c);
		 int t = 0;
		
		 for(int value : c) {
			sum+= value;
		}
		 
		 if(n > k) {
			 sum+=c[t++];
			 k--;
		 }
			 
		 
		 return sum;
		 
		
		   
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] c = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        int minimumCost = getMinimumCost(n, k, c);
	        System.out.println(minimumCost);
	    

}
}