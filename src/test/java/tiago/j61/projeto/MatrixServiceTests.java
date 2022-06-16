package tiago.j61.projeto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.projeto.bo.MatrizBo;
import tiago.j61.projeto.exception.MatrizNaoQuadraticaException;

@SpringBootTest
class MatrixServiceTests {

	@Autowired
	private MatrizBo matrizBo;

	@Test
	@DisplayName("Matriz Quadratica")
	void matrizQuadratica() throws MatrizNaoQuadraticaException {
		int[] matriz = { 1, 2, 3, 4 };
		assertDoesNotThrow(() -> matrizBo.matrizValid(matriz));
	}

	@Test
	@DisplayName("Matrix não Quadratica")
	void matrizNaoQuadratica() {
		int[] matriz = { 1, 2, 3 };
		MatrizNaoQuadraticaException thrown = assertThrows(MatrizNaoQuadraticaException.class,
				() -> matrizBo.matrizValid(matriz));
	}

	@Test
	@DisplayName("Coverter array para matrix")
	void arrayToMatrix() {
		int[] matriz = { 1, 2, 3, 4 };
		matrizBo.arrayToMatrix(matriz);
	}

	@Test
	@DisplayName("Bordas da matrix")
	void extrairBordasMatrix() {
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] returne = matrizBo.girarMatrix(matriz);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");
		System.out.println(returne.length);
		System.out.println(returne[0].length);
		for (int i = 0; i < returne.length; i++) {
			for (int j = 0; j < returne[i].length; j++) {
				System.out.print(returne[i][j] + " ");
			}
			System.out.println();
		}
	}
}
