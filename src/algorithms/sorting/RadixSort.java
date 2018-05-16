package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/***
 * 
 * @author ashish find max from array so we know number of digit to traverse.
 * 
 *
 */
public class RadixSort {

	static void countSort(Integer[] arr , int n , int exp) {
		int[] output = new int[n];
		int count[] = new int[10];
		
		Arrays.fill(count, 0);
		// increment count using least digit one by one.
		for(int i=0;i < n;i++)
		{
				count[(arr[i]/exp)%10]++;
				
		}
		
		
		for(int i = 1; i < 10 ; i++)
		{
			count[i]+=count[i-1];
		}
		
		
		for(int  i = n-1; i >=0; i--) {
			output[ count[(arr[i]/exp) %10] - 1] = arr[i];
			count[(arr[i]/exp) %10]--;
			
		}
		
		for(int i = 0; i <  n ; i++) {
			arr[i]= output[i];
		}
		
		
	}

	static Integer[] radixSort(Integer arr[]) {
		// find max for get number 
		List<Integer> integer = Arrays.asList(arr);
		Integer max = integer.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		for (int i = 1; max / i > 0; i *= 10) {
			countSort(arr, arr.length, i);
		}
		return arr;
	}

	public static void main(String[] args) {

		Integer[] arr = { 3, 1, 14, 123, 23, 111, 12342, 1123, 3231, 132314, 12, 1 };
		System.out.println(Arrays.toString(radixSort(arr)));
	}

}
