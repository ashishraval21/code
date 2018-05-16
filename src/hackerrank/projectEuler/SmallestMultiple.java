package hackerrank.projectEuler;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SmallestMultiple {

	
	
	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	          java.util.List<Integer> list = new ArrayList<Integer>();
	            int value = 2;
	            int pow =1;
	            int sum =1;
	            while(n >= Math.pow(value, pow)){
	                list.add((int) Math.pow(value, pow));
	                 ++pow;
	            }
	            sum *= Math.pow(value, --pow);
	            for(int i= 3; i <= n ; i+=2){
	                if(list.contains(i))
	                    continue;
	                value = i;
	                pow =1 ;
	                while(n >= Math.pow(value, pow)){
	                    list.add((int)Math.pow(value, pow));
	                    ++pow;
	                }
	               sum *=  Math.pow(value, --pow);
	                
	            }
	            
	            System.out.println(sum);
	            
	        }
	}
	
}


