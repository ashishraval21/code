package algorithms.DP;

public class Largest_Sum_Continues_SubArray {

	static int largestSumContinuesSubArray(int[] arr) {

			int sum_so_far = Integer.MIN_VALUE;
			int max_end_here = 0;
			 
			
			for ( int i = 0; i < arr.length; i++) {
				 max_end_here+=arr[i];
				 
				 if( sum_so_far < max_end_here) {
					 sum_so_far = max_end_here;
				 }
				 
				 if(max_end_here < 0 )
				 {
					 max_end_here =0;
				 }
				 
				 
				
			}
			
			return sum_so_far;
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println( " largest sum array : "+ largestSumContinuesSubArray(arr));
	}

}
