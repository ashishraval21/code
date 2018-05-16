package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	static void merge(int[] arr, int l, int mid, int r) {

		int n1 = mid - l + 1; // count left array elements including mid.

		int n2 = r - mid; // count right array elements.

		int[] lArray = new int[n1]; // left array elements will be stored to lArray.
		int[] rArray = new int[n2]; // right array elements will be stored to rArray.

		int i = 0, j = 0;
		// copy arr elements to lArray.
		for (; i < n1; i++) {
			lArray[i] = arr[l + i];
		}
		// copy arr elements to rArray.
		for (; j < n2; j++) {
			rArray[j] = arr[mid + 1 + j];
		}
		i = 0;
		j = 0;
		int k = l;
		while (i < n1 && j < n2) {

			if (lArray[i] < rArray[j]) {
				arr[k] = lArray[i];
				i++;
			} else {
				arr[k] = rArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = lArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rArray[j];
			j++;
			k++;
		}

	}

	static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 39, 20, 54, 35, 90, 60, 70, 50, 20, 40 };
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
