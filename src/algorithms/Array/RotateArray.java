package algorithms.Array;

import java.util.Collection;
import java.util.Collections;

import javax.security.auth.callback.ChoiceCallback;

public class RotateArray {

	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	static int getGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return getGCD(b, a % b);
	}

	static void rotateArray(int arrsize, int rotateTimes) {

		for (int i = 0; i < getGCD(rotateTimes, arrsize); i++) {
			int temp = arr[i];
			int j = i;
			while (true) {
				int k = j + rotateTimes;
				if(k >= arrsize )
					k= k - arrsize;
				if(k == i)
					break;
				arr[j] = arr[k];
				j = k;

			}
			arr[j] = temp;

			
		}

	}

	static void printArray() {
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}
	
	public static void reverseArray(int start, int end ) {
		int temp;
		while(start < end) {
			temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
		
		
	}
	
	
	

	public static void main(String[] args) {
		/*printArray();
		rotateArray(arr.length, 3);
		System.out.println();*/
		printArray();
		 // 3 time rotation
		int d =3;
		reverseArray(0, d -1);
		reverseArray(d, arr.length - 1);
		reverseArray(0, arr.length-1);
		System.out.println();
		printArray();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
