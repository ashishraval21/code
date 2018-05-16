package hackerrank.projectEuler;

import java.util.HashMap;
import java.util.Scanner;

public class Special_Pythagorean_Triplet {
	static HashMap<Long, Long> map;
	static HashMap<Long, Long> valueMap;

	static long getTripletProduct(int n) {
		long max = -1;
		
		for(int i = n/2; i >= n/4; i--) {
			for(int j = n /2; j >= n/4; j--) {
				if( i == j )
					continue;
				long key = Math.abs(((i*i) - (j*j)));
				Long value = map.get(key);
				if (value != null &&  i + j + value == n) {
					long multiply = i * j * value;
					if (max < multiply) {
						max = multiply;
						System.out.println(n +" --> "+i+"   "+j+"   "+value + "  "+max);
					}
				}

			}
		}
		
		
		
		/*for(int i= n/2 , j = n/4 ; i > j && i > 0; j++) {
			int m = j;
			while(m < i ) {
				long key = ((i*i) + (m*m));
				Long value = map.get(key);
				if (value != null &&  i + m + value == n) {
					long multiply = i * m * value;
					if (max < multiply) {
						max = multiply;
						System.out.println(n +" --> "+i+"   "+m+"   "+value + "  "+max);
					}
				}

				m++;
			}
			
			
		}*/
		
		
		return max;

	}

	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		map = new HashMap<>();
		valueMap = new HashMap<>();
		for (long i = 2; i <= 3000; i++) {
			map.put(i * i, i);
		}
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			for(int i = 1; i <= 3000; i++) {
			getTripletProduct(i);
		}
		}
	}

}
