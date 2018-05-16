package algorithms.DP.BASIC;

public class Factorial {
	
	public long getFactorial(int value) {
		if(value == 1)
			return 1;
		System.out.println( value );
		return  getFactorial(value - 1) * value;
	}
	

	public static void main(String[] args) {
		
		int val = 5;
		System.out.println(new Factorial().getFactorial(val));
		

	}

}
