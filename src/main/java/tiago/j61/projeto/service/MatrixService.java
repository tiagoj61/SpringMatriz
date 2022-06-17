package tiago.j61.projeto.service;

import org.springframework.stereotype.Service;

@Service
public class MatrixService {

	public boolean matrixValid(int[] matriz) {
		double sqrt = Math.sqrt(matriz.length);
		int decimal = (int) sqrt;
		double fraction = sqrt - decimal;
		if (fraction != 0)
			return false;
		return true;
	}

	public int[][] arrayToQuadraticMatrix(int[] array) {
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
		int rowLength = matrizOriginal.length;
		int colLength = matrizOriginal[0].length;

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
