package tiago.j61.projeto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	void matrizQuadratica() throws MatrizNaoQuadraticaException {
		int[] matriz = { 1, 2 };
		matrizBo.matrizValida(matriz);
	}

	@Test
	void matrizNaoQuadratica() {
		int[] matriz = { 1, 2, 3 };

		MatrizNaoQuadraticaException thrown = assertThrows(MatrizNaoQuadraticaException.class,
				() -> matrizBo.matrizValida(matriz), "Expected doThing() to throw, but it didn't");

	}
}
