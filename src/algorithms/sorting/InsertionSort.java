package algorithms.sorting;


public class InsertionSort {
	
	static int[] insertionSort(int[] values) {
		
		for( int i = 1; i < values.length; i++) {
			int value = values[i];
			
			int j = i -1;
			
			while( j >= 0 && values[j] > value) {
				values[j+1]= values[j];
				j-=1;
			}
			
			values[j + 1] = value;
		}
		
		
		
		return values;
	}

	public static void main(String[] args) {
		int[]  values = {1 , 4, 5, 2, 8, 0,};
		insertionSort(values);
	}

}
