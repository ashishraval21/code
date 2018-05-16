package algorithms.DP;

/**
 * 
 * @author root
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 */
public class Longest_Increasing_Subsequence {

	
	static int getLIS(int arr[]) {
		int[] LIS = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			LIS[i] =1;
		}
		
		
		for(int i = 1; i < arr.length; i++) {
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j]+1)
				{
					LIS[i] = LIS[j]+1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i ++)
		{
			if(max < LIS[i])
				max = LIS[i];
		}
		
		
		
		return max;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {  5, 6, 7, 0, 5, 2, 4, 5, 6, 7};
		System.out.println( getLIS(arr));
	}
}
