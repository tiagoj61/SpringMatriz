package tiago.j61.projeto.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiago.j61.projeto.exception.MatrizNaoQuadraticaException;

@Service
public class MatrizBo {

	@Autowired
	CalculoBo calculoBo;

	public void matrizValid(int[] matriz) throws MatrizNaoQuadraticaException {
		if (calculoBo.isNumeroQuadratico(matriz.length))
			throw new MatrizNaoQuadraticaException();
	}

	public int[][] arrayToMatrix(int[] array) {
		int raizMatrix = (int) Math.sqrt(array.length);

		int[][] matrix = new int[raizMatrix][raizMatrix];

		for (int i = 0; i < raizMatrix; i++) {
			for (int j = 0; j < raizMatrix; j++) {
				matrix[i][j] = array[i * raizMatrix + j];
			}
		}

		return matrix;

	}

	public int[][] girarMatrix(int[][] matrix) {
		int[][] matrixBordas = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {

					if (j == 0) {
						matrixBordas[i][j] = matrix[i + 1][j];

					} else {
						matrixBordas[i][j] = matrix[i][j - 1];
					}

				} else if (i == matrix.length - 1) {

					if (j == matrix[0].length - 1) {
						matrixBordas[i][j] = matrix[i - 1][j];

					} else {
						matrixBordas[i][j] = matrix[i][j + 1];
					}

				} else if (j == 0 || j == matrix[0].length - 1) {

					if (j == 0) {
						matrixBordas[i][j] = matrix[i + 1][j];
					} else {
						matrixBordas[i][j] = matrix[i - 1][j];
					}

				} else {
					matrixBordas[i][j] = matrix[i][j];
				}

			}
		}
		return matrixBordas;
	}
}
