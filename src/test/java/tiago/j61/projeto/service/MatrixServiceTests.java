package tiago.j61.projeto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.helper.MatrixHelper;

@SpringBootTest
class MatrixServiceTests {

	@Autowired
	private MatrixService matrixService;

	@Test
	@DisplayName("Teste array for smaller quadratic matrix")
	void canGenerateSmallerQuadraticMatrix() throws NonQuadraticMatrixException {
		
		int[] array = MatrixHelper.generateRandomArray(1);
		boolean isMatrixValid = matrixService.matrixValid(array);
		assertTrue(isMatrixValid);
	}

	@Test
	@DisplayName("Teste array for quadratic matrix")
	void canGenerateQuadraticMatrix() throws NonQuadraticMatrixException {
		int[] array = MatrixHelper.generateRandomArray(10000);
		boolean isMatrixValid = matrixService.matrixValid(array);
		assertTrue(isMatrixValid);
	}

	@Test
	@DisplayName("Teste array for non quadratic matrix")
	void cannotGenerateQuadraticMatrix() {
		int[] array = MatrixHelper.generateRandomArray(3);
		boolean isMatrizValid = matrixService.matrixValid(array);
		assertFalse(isMatrizValid);
	}

	@Test
	@DisplayName("Teste convert array to smaller matrix")
	void arrayToSmallerMatrix() {
		int[] array = MatrixHelper.generateRandomArray(1);
		int[][] matrizOriginal = matrixService.arrayToQuadraticMatrix(array);

		int matrizRowColLength = (int) Math.sqrt(array.length);

		for (int row = 0; row < matrizRowColLength; row++) {
			for (int col = 0; col < matrizRowColLength; col++) {
				int arrayPosition = row * matrizRowColLength + col;

				assertEquals(matrizOriginal[row][col], array[arrayPosition]);
			}
		}

	}

	@Test
	@DisplayName("Teste convert array to matrix")
	void arrayToMatrix() {
		int[] array = MatrixHelper.generateRandomArray(10000);
		int[][] matrizOriginal = matrixService.arrayToQuadraticMatrix(array);

		int matrizRowColLength = (int) Math.sqrt(array.length);

		for (int row = 0; row < matrizRowColLength; row++) {
			for (int col = 0; col < matrizRowColLength; col++) {
				int arrayPosition = row * matrizRowColLength + col;

				assertEquals(matrizOriginal[row][col], array[arrayPosition]);
			}
		}

	}

	@Test
	@DisplayName("Test flip matrix")
	void extrairBordasMatrix() {
		int rowLength = 4;
		int colLength = 4;

		int[][] matrizOriginal = MatrixHelper.generateRandomMatrix(rowLength, colLength);
		int[][] matrixFliped = matrixService.flipMatrix(matrizOriginal);

		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {

				if (row == 0) {

					if (col == 0) {
						assertEquals(matrixFliped[row][col], matrizOriginal[row + 1][col]);
					} else {
						assertEquals(matrixFliped[row][col], matrizOriginal[row][col - 1]);
					}

				} else if (row == rowLength - 1) {

					if (col == colLength - 1) {
						assertEquals(matrixFliped[row][col], matrizOriginal[row - 1][col]);

					} else {
						assertEquals(matrixFliped[row][col], matrizOriginal[row][col + 1]);
					}

				} else if (col == 0 || col == colLength - 1) {

					if (col == 0) {
						assertEquals(matrixFliped[row][col], matrizOriginal[row + 1][col]);
					} else {
						assertEquals(matrixFliped[row][col], matrizOriginal[row - 1][col]);
					}

				} else {
					assertEquals(matrixFliped[row][col], matrizOriginal[row][col]);
				}
			}
		}
		MatrixHelper.printMatrix(matrizOriginal);
		MatrixHelper.printMatrix(matrixFliped);
	}
}
