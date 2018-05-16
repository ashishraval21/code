package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int[] values) {
		for (int i = 0; i < values.length - 1; i++) {
				boolean flag = false;
			for (int j = 0; j < values.length - i -1; j++) {
				
				if (values[j] > values[j + 1]) {
					int temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
					flag = true;
				}
				
				System.out.println(Arrays.toString(values));
			}
			if(!flag )
				break;
			
			

		}

		return values;
	}

	public static void main(String[] args) {

		int[] values = { 5, 1, 4, 2, 9, 7, 8};
		bubbleSort(values);
	}

}
