package bitExamples;

public class GenerateSubSet {

	
	static long possibleSubSets(int[] arr, int N) {
		long sum = 0;
		for(int i = 0; i < ( 1 << N); i++) {
			long temp = 0;
			for(int j = 0; j< N; j++) {
				
				// getting position of 1 from i, one by one.
				if((i & (1 << j)) > 0 ) {
					System.out.print(arr[j] +"  ");
				}
				
			}
			System.out.println();
			sum+=temp;
			
		}
		return sum;
		
		
	}
	
	
	
	public static void main(String[] args) {
		int value = 3; 
		int[] arr = {1,2,3};
		System.out.println(possibleSubSets(arr, value));

	}

}
