package mix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class KthLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n > 0) {
			
			String str = sc.next();
			int k = sc.nextInt();
			int[] alphabet = new int[26];
			
			for(char c : str.toCharArray()) {
				int index = c - 97;
				if(index >=0 && index < 26) {
					alphabet[index]++;
				}
				
			}
			TreeSet<Integer> trs = new TreeSet<>();
			
			for(int i=0; i<26;i++) {
				int nonZero = alphabet[i];
				if(nonZero == 0)
					continue;
				trs.add(nonZero);
			}
			
			int size = trs.size();
			if(k > size) {
				System.out.println( -1);
			} else {
				int count = 1;
				Iterator<Integer> iterator = trs.descendingIterator();
				while (iterator.hasNext()) {
					int value = iterator.next();
					if (count == k) {
						count = value;
						break;
					}
					count++;
				}
				for (int i = 0; i < 26; i++) {
					if (alphabet[i] == count) {
						System.out.println(((char)(97 + i)));
						break;
					}
				}
			}
			
			
			
			
			
			n--;
		}
	}

}
