package algorithms.sorting;

import java.util.Arrays;

public class HeapSort_Practice {

	public static void HeapSort(int[] arr, int size) {

		for(int i = (size/2) + 1; i >=0 ; i--) {
			heapify(arr, i, size);
		}
		
		System.out.println(Arrays.toString(arr));
		
		for(int i = size - 1; i >= 0; i--) {
			int temp = arr[i]; 
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, 0, i);
			System.out.println(Arrays.toString(arr));
			
		}
		
		
	}
	
	public static void heapify(int[] arr, int i, int size) {
		int left = i *2 ;
		int right = (i * 2) + 1;
		int largest = i ;
		
		if( left < size && arr[largest] < arr[left]) {
			largest = left;
		}
		
		if(right < size && arr[largest] < arr[right])
			largest = right;
		
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, largest, size);
		}
	}
	

	public static void main(String[] args) {
		int[] arr = { 100, 5, 34, 52, 75, 19, 65, 53, 53 };

		HeapSort(arr, arr.length);
	}

}
