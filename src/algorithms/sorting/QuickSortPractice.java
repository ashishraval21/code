package algorithms.sorting;

import java.util.Arrays;

public class QuickSortPractice {
	
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		
		int i = start - 1;
		
		for(int j = start ; j < end; j++) {
			
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[end];
		arr[end] = arr[i+1];
		arr[i+1] = temp;
		
		return i +1;
		
		
		
	}
	
	
	
	
	public static void quickSort(int[] arr , int start, int end) {
		
		
		if(start < end) {
			int mid = partition(arr, start, end);
			quickSort(arr, start, mid - 1);
			quickSort(arr, mid + 1, end);
		}
		
		
	}

	public static void main(String[] args) {
		int[] arr = { 100, 5, 34, 52, 75, 19, 65, 53, 53 };
		
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
	}

}
