package tiago.j61.projeto.facada;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.projeto.dto.MatrixRequestDto;
import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.MatrixBadRequestException;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.helper.MatrixHelper;

@SpringBootTest
class MatrixFacadaTests {

	@Autowired
	private MatrixFacada matrixFacada;

	@Test
	@DisplayName("Teste facada null")
	void nullDto() {

		MatrixRequestDto dto = null;

		assertThrows(MatrixBadRequestException.class, () -> matrixFacada.flipArray(dto));
	}

	@Test
	@DisplayName("Teste facada dosent throw")
	void arrayNotQuadratic() {
		int[] array = MatrixHelper.generateRandomArray(1);

		MatrixRequestDto dto = new MatrixRequestDto();
		dto.setArray(array);

		assertDoesNotThrow(() -> matrixFacada.flipArray(dto));
	}

	@Test
	@DisplayName("Teste facada throw for non quadratic")
	void arrayNonQuadratic() {
		int[] array = MatrixHelper.generateRandomArray(2);

		MatrixRequestDto dto = new MatrixRequestDto();
		dto.setArray(array);

		assertThrows(NonQuadraticMatrixException.class, () -> matrixFacada.flipArray(dto));
	}

	@Test
	@DisplayName("Teste facada throw for 0")
	void arrayZero() {
		int[] array = MatrixHelper.generateRandomArray(0);

		MatrixRequestDto dto = new MatrixRequestDto();
		dto.setArray(array);

		assertThrows(NonQuadraticMatrixException.class, () -> matrixFacada.flipArray(dto));
	}

	@Test
	@DisplayName("Teste facada flip smaller array")
	void flipSmallerArray() {
		int[] array = MatrixHelper.generateRandomArray(1);

		MatrixRequestDto dto = new MatrixRequestDto();
		dto.setArray(array);

		MatrixReturnDto matrixReturnDto = assertDoesNotThrow(() -> matrixFacada.flipArray(dto));

		assertNotNull(matrixReturnDto);
		assertNotEquals(matrixReturnDto.getMatrixOriginal().length, 0);
		assertNotEquals(matrixReturnDto.getMatrixOriginal()[0].length, 0);
		assertNotEquals(matrixReturnDto.getMatrixFliped().length, 0);
		assertNotEquals(matrixReturnDto.getMatrixFliped()[0].length, 0);
	}

	@Test
	@DisplayName("Teste facada flip array")
	void flipArray() {
		int[] array = MatrixHelper.generateRandomArray(100);

		MatrixRequestDto dto = new MatrixRequestDto();
		dto.setArray(array);

		MatrixReturnDto matrixReturnDto = assertDoesNotThrow(() -> matrixFacada.flipArray(dto));

		assertNotNull(matrixReturnDto);
		assertNotEquals(matrixReturnDto.getMatrixOriginal().length, 0);
		assertNotEquals(matrixReturnDto.getMatrixOriginal()[0].length, 0);
		assertNotEquals(matrixReturnDto.getMatrixFliped().length, 0);
		assertNotEquals(matrixReturnDto.getMatrixFliped()[0].length, 0);
	}

}
