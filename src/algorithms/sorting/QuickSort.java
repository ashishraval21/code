package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
	
	
	static int partitionMine(int[] values, int low, int high) {
		
		int pivot = values[high];
		int i = low;
		int j = high;

		for (; i < high;) {
			int value = values[i];
			if( value >= pivot) {
				values[i] = values[high-1];
				values[--high] = value;
			}else {
				i++;
			}
			
			System.out.println( Arrays.toString(values));
		}
		
		int temp = values[i];
		values[i] = pivot;
		values[j] = temp;
		return i;
		
		
	}
	
	static int partition(int[] values, int low, int high) {
		int pivot = values[high];
		int i = low -1;
		for(int  j = low; j < high; j++) {
			
			if(values[j] <= pivot) {
				i+=1;
				int temp = values[i];
				values[i] = values[j]; 
				values[j] = temp;
			}
		}
		int temp = values[i+1];
		values[high] = temp;
		values[i+1] = pivot;
		
		return i+1;
	}
	
	
	
	

	static void quickSort(int[] values, int low, int high) {
		if( low < high) {
			
			int pi = partition(values, low, high);
			quickSort(values, low, pi-1);
			quickSort(values, pi+1, high);
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {8, 7, 6, 10,5, 4, 3, 2, 1};
		quickSort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

}
