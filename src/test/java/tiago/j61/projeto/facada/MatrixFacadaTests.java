package tiago.j61.projeto.facada;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.helper.MatrixHelper;

@SpringBootTest
class MatrixFacadaTests {

	@Autowired
	private MatrixFacada matrixFacada;

	@Test
	@DisplayName("Teste facada dosent throw")
	void arrayNotQuadratic() throws NonQuadraticMatrixException {
		int[] array = MatrixHelper.generateRandomArray(1);
		assertDoesNotThrow(() -> matrixFacada.flipArray(array));
	}

	@Test
	@DisplayName("Teste facada throw")
	void arrayQuadratic() throws NonQuadraticMatrixException {
		int[] array = MatrixHelper.generateRandomArray(2);
		assertThrows(NonQuadraticMatrixException.class, () -> matrixFacada.flipArray(array));
	}

	@Test
	@DisplayName("Teste facada flip smaller array")
	void flipSmallerArray() throws NonQuadraticMatrixException {
		int[] array = MatrixHelper.generateRandomArray(1);

		MatrixReturnDto matrixReturnDto = matrixFacada.flipArray(array);

		assertNotNull(matrixReturnDto);
		assertNotEquals(matrixReturnDto.getMatrizOriginal().length, 0);
		assertNotEquals(matrixReturnDto.getMatrizOriginal()[0].length, 0);
		assertNotEquals(matrixReturnDto.getMatrizFliped().length, 0);
		assertNotEquals(matrixReturnDto.getMatrizFliped()[0].length, 0);
	}

	@Test
	@DisplayName("Teste facada flip array")
	void flipArray() throws NonQuadraticMatrixException {
		int[] array = MatrixHelper.generateRandomArray(100);

		MatrixReturnDto matrixReturnDto = matrixFacada.flipArray(array);

		assertNotNull(matrixReturnDto);
		assertNotEquals(matrixReturnDto.getMatrizOriginal().length, 0);
		assertNotEquals(matrixReturnDto.getMatrizOriginal()[0].length, 0);
		assertNotEquals(matrixReturnDto.getMatrizFliped().length, 0);
		assertNotEquals(matrixReturnDto.getMatrizFliped()[0].length, 0);
	}

}
