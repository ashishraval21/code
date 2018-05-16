package algorithms.sorting;

import java.util.Arrays;

public class HeapSort {

	public static void heapSort(int[] arr, int n) {

		for (int i = (n / 2) + 1; i >= 0; i--) {
			heapify(arr, i, n);
		}
		System.out.println(Arrays.toString(arr));

		for (int i = n-1; i >= 0 ; i--) {
			int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
			heapify(arr, 0, i);
			
		}
		
		System.out.println(Arrays.toString(arr));

	}

	static void heapify(int[] arr, int index, int n) {
		int left = 2 * index;
		int right = (2 * index) + 1;
		int largest = index;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != index) {
			int temp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = temp;
			System.out.println(Arrays.toString(arr)+" "+largest+"  "+n);
			heapify(arr, largest, n );
		}

	}

	public static void main(String[] args) {
		int[] arr = { 12, 23, 11, 14, 123, 32, 132, 45, 76, 43, 65, 40 };

		heapSort(arr, arr.length);

	}

}
