package basics;

import java.util.*;

public class PrimeGenerator {
	static boolean[] primeFlag;
	
	static boolean[] getPrimeNumbers() {
		int n = 1000000000;
		primeFlag = new boolean[n+1];
		Arrays.fill(primeFlag, false);
		primeFlag[0] = primeFlag[1] = true;
		int prime = 2;
		for(int i = 2; i<= Math.sqrt(n); i++) {
			if( primeFlag[i] == true)
				continue;
			
			int k = i * 2;
			while( k <= n) {
				primeFlag[k] = true;
				k+=i;
			}
			
		}
		
		return primeFlag;
	}

	public static void main(String[] args) {
		
		boolean[] value = getPrimeNumbers();
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while ( t > 0 ){
			int i,j;
			i = sc.nextInt();
			j = sc.nextInt();
			for(int k = i; k <= j; k++){
				if(!value[k])
					System.out.println(k);
			}
			
			
			t--;
		}

	}

}
