package tiago.j61.projeto.service;

import org.springframework.stereotype.Service;

@Service
public class MatrixService {

	public boolean matrixValid(int[] matriz) {
		if (matriz == null || matriz.length < 1)
			return false;

		double sqrt = Math.sqrt(matriz.length);
		int decimal = (int) sqrt;
		double fraction = sqrt - decimal;

		if (fraction != 0)
			return false;

		return true;
	}

	public int[][] arrayToQuadraticMatrix(int[] array) {

		if (array == null) {
			return null;
		}

		if (array.length == 1) {
			int[][] matrizGenereted = new int[1][1];
			matrizGenereted[0][0] = array[0];
			return matrizGenereted;
		}

		int matrizRowColLength = (int) Math.sqrt(array.length);

		int[][] matrizGenereted = new int[matrizRowColLength][matrizRowColLength];

		for (int row = 0; row < matrizRowColLength; row++) {
			for (int col = 0; col < matrizRowColLength; col++) {
				int arrayPosition = row * matrizRowColLength + col;
				matrizGenereted[row][col] = array[arrayPosition];
			}
		}

		return matrizGenereted;

	}

	public int[][] flipMatrix(int[][] matrizOriginal) {

		if (matrizOriginal == null) {
			return null;
		}

		int rowLength = matrizOriginal.length;
		int colLength = matrizOriginal[0].length;

		if (rowLength == 1 && colLength == 1) {
			int[][] matrizGenereted = new int[1][1];
			matrizGenereted[0][0] = matrizOriginal[0][0];
			return matrizGenereted;
		}

		int[][] matrizFliped = new int[rowLength][colLength];

		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				if (row == 0) {

					if (col == 0) {
						matrizFliped[row][col] = matrizOriginal[row + 1][col];

					} else {
						matrizFliped[row][col] = matrizOriginal[row][col - 1];
					}

				} else if (row == rowLength - 1) {

					if (col == colLength - 1) {
						matrizFliped[row][col] = matrizOriginal[row - 1][col];

					} else {
						matrizFliped[row][col] = matrizOriginal[row][col + 1];
					}

				} else if (col == 0 || col == colLength - 1) {

					if (col == 0) {
						matrizFliped[row][col] = matrizOriginal[row + 1][col];
					} else {
						matrizFliped[row][col] = matrizOriginal[row - 1][col];
					}

				} else {
					matrizFliped[row][col] = matrizOriginal[row][col];
				}

			}
		}
		return matrizFliped;
	}
}
