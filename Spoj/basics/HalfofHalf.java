package basics;

import java.util.Scanner;

public class HalfofHalf {

	
		public static void main (String[] args) throws java.lang.Exception
		{
			Scanner  sc = new Scanner(System.in);
			int n = sc.nextInt();
			while( n > 0 ){
				String str = sc.next();
				int size = str.length();
				String temp ="";
				
				for(int  i=0; i < size/2; i+=2){
					temp+=str.charAt(i);	
				}
				
				System.out.println(temp);
				
				
				n--;
			}
			
			
			
		
	}
}
