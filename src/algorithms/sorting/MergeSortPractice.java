package algorithms.sorting;

import java.util.Arrays;

public class MergeSortPractice {

		static void merge(int[] arr,int start, int mid, int end ) {
			
			int n1 = mid - start + 1;
			int n2 = end - mid;
			
			int[] left = new int[n1];
			int[] right = new int[n2];
			
			int i =0, j =0;
			
			for(; i < n1; i++) {
				left[i] = arr[start + i];
			}
			
			for( ; j < n2; j++) {
				right[j] = arr[mid + 1 + j ];
			}
			
			i = j =0;
			int k = start;
			
			while( i < n1 && j < n2) {
				if(left[i] > right[j]) {
					arr[k] = right[j];
					j++;
				}else {
					arr[k] = left[i];
					i++;
				}
				k++;
			}
			
			
			while(i < n1) {
				arr[k] = left[i];
				i++; k++;
			}
			
			while( j < n2) {
				arr[k] = right[j];
				j++; k++;
			}
			
			
			
		}
	
	
	
	
	static void mergeSort(int[] arr, int start, int end) {
		
		if( start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
			
		}
	}
		
	
	
	
	public static void main(String[] args) {
		int[] arr = { 100, 5, 34, 52, 75, 19, 65, 53, 53 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
