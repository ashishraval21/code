package mix;

public class SquareMatrix {

	public static int squareSubMatrix(boolean[][] matrix) {
		int[][] cache = new int[matrix.length][matrix[0].length];

		int max = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {

				if (i == 0 || j == 0)
					cache[i][j] = 0;
				else if (matrix[i][j]) {
					cache[i][j] = Math.min(Math.min(cache[i][j - 1], cache[i - 1][j - 1]), cache[i - 1][j]) + 1;
				}

				if (cache[i][j] > max)
					max = cache[i][j];
			}
		}

		return max;

	}

	public static int squareMatrixTopDOWN(boolean[][] arr) {
		int max = 0;
		int[][] cache = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j])
					max = Math.max(max, squareSubmatrixTopDOWN(arr, i, j, cache));

			}
		}

		return max;
	}

	static int squareSubmatrixTopDOWN(boolean[][] arr, int i, int j, int[][] cache) {

		if (i == arr.length || j == arr[0].length || !arr[i][j])
			return 0;

		if (cache[i][j] > 0)
			return cache[i][j];

		cache[i][j] = 1 + Math.min(Math.min(squareSubmatrixTopDOWN(arr, i + 1, j + 1, cache),
				squareSubmatrixTopDOWN(arr, i + 1, j, cache)), squareSubmatrixTopDOWN(arr, i, j + 1, cache));

		return cache[i][j];
	}

	public static int squareMatrix(boolean[][] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j])
					max = Math.max(max, squareSubmatrix(arr, i, j));

			}
		}

		return max;
	}

	static int squareSubmatrix(boolean[][] arr, int i, int j) {

		if (i == arr.length || j == arr[0].length || !arr[i][j])
			return 0;

		return 1 + Math.min(Math.min(squareSubmatrix(arr, i + 1, j + 1), squareSubmatrix(arr, i + 1, j)),
				squareSubmatrix(arr, i, j + 1));

	}

	public static void main(String[] args) {
		boolean arr[][] = { { true, false, false, false, false }, { true, true, true, true, true },
				{ true, true, true, true, true }, { true, true, true, true, true },
				{ true, false, false, true, true } };

		System.out.println(squareMatrix(arr));
		System.out.println(squareMatrixTopDOWN(arr));
		System.out.println(squareSubMatrix(arr));

	}

}
