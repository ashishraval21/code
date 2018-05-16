package mix;

public class PrintPascal {

	static void printPascal(int n) {
		
		int[][] temp = new int[n][n];
		
		for (int line = 0; line < n; line++) {

			for (int i = 0; i <= line; i++) {

				if(i == line || i == 0)
					temp[line][i] = 1;
				else {
				
					temp[line][i] = temp[line -1][i-1] + temp[line - 1][i];
					
				}
				
				System.out.print(temp[line][i]+" ");
				
			}
			System.out.println();
		}
	}
	
	
	

	public static void main(String[] args) {
		printPascal(5);

	}

}
