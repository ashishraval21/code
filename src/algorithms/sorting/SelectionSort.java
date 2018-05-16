/**
 * 
 */
package algorithms.sorting;

import java.util.Arrays;

/**
 * @author ashish
 * 			 The selection sort algorithm sorts an array by repeatedly
 *         finding the minimum element (considering ascending order) from
 *         unsorted part and putting it at the beginning. The algorithm
 *         maintains two subarrays in a given array.
 *
 */
public class SelectionSort {

	static int[] selectionSort(int[] values) {

		for (int i = 0; i < values.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < values.length; j++) {
				if( values[min] > values[j]) {
					min = j;
				}
			}
			int temp = values[min];
			values[min] = values[i];
			values[i] = temp;
			
		}

		return values;
	}

	public static void main(String[] args) {

		int[] values = { 1, 5, 6, 2, 6, 7, 2, 4, 3, 1};
		
		System.out.println( Arrays.toString(selectionSort(values)));
		
	}

}
