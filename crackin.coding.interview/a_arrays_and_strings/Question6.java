package a_arrays_and_strings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0
 * 
 * @author ashish
 *
 */
public class Question6 {

	static int[][] setRowandColumnToZero(int[][] arr) {
		int[] row = new int[arr.length];
		int[] column = new int[arr[0].length];

		System.out.println(row.length +"    "+column.length);
		
		
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < column.length; j++) {

				if (arr[i][j] == 0) {
					row[i] = 1;
					column[i] = 1;

				}
			}
		}
		System.out.println(row.length +"    "+column.length);
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < column.length; j++) {

				if (row[i] == 1 || column[j] == 1) {
					arr[i][j] = 0;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
				int[][] arr = { { 1, 2, 3, 4}, { 5, 6, 7, 8 },{ 9, 0, 1, 2}};
				arr = setRowandColumnToZero(arr);
				System.out.println(
					    Arrays.stream(arr)
					        .map(a -> String.join(" ", Arrays.toString(a)))
					            .collect(Collectors.joining("\n"))
					);
	}

}
