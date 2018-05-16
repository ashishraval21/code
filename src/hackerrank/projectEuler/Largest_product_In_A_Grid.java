package hackerrank.projectEuler;

import java.util.Scanner;

public class Largest_product_In_A_Grid {
	
	static long max = Integer.MIN_VALUE;
	
	
	static int getValue(int[][] grid, int i, int j) {
		return Math.max(Math.max(grid[i][j] * grid[i][j-1] * grid[i][j -2 ]* grid[i][j - 3] , 
				Math.max(
				grid[j][i] * grid[j - 1][i] * grid[j - 2][i]* grid[j - 3][i],
				Math.max(grid[i][j] * grid[i+1][j+1] * grid[i+2][j + 2 ]* grid[i + 3][j +3], 
						grid[i][j] * grid[i-1][j-1] * grid[i-2][j - 2 ]* grid[i - 3][j -3])
				)),
		(i - 3 > 0 || j + 3 > 19)? 0: grid[i][j] * grid[i-1][j+1]* grid[i -2][j +2] * grid[ i-3][j+3]); 
		
	}
	
	 static long getMaximum(int[][] grid)
	    {
		 for(int i = 0; i < 17; i++) {
			 
			 for(int j = 0; j < 17 ; j++) {
				 
				 int temp = getValue(grid, i, j);
				 if(temp > max)
					 max = temp;
			 }
		 }
		 
	        
		 return max;
	    }
	
	

	public static void main(String[] args) {
	

		  Scanner in = new Scanner(System.in);
	        int[][] grid = new int[20][20];
	        for(int grid_i=0; grid_i < 20; grid_i++){
	            for(int grid_j=0; grid_j < 20; grid_j++){
	                grid[grid_i][grid_j] = in.nextInt();
	            }
	        }
	        
	        System.out.println(getMaximum(grid));
		
		
	}

}
