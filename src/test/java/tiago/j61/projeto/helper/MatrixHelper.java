package tiago.j61.projeto.helper;

public class MatrixHelper {

	public static int[] generateRandomArray(int length) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	public static int[][] generateRandomMatrix(int rowLength, int colLength) {
		int[][] matriz = new int[rowLength][colLength];
		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				matriz[row][col] = (int) (Math.random() * 100);
			}
		}
		return matriz;
	}

	public static void printMatrix(int[][] matrix) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;

		for (int i = 0; i < colLength; i++) {
			System.out.print("-");
		}
		System.out.println();

		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}
