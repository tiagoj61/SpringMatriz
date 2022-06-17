package tiago.j61.projeto.facada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.service.MatrixService;

@Service
public class MatrixFacada {
	@Autowired
	private MatrixService matrizBo;

	public MatrixReturnDto flipArray(int[] array) throws NonQuadraticMatrixException {
		if (!matrizBo.matrixValid(array))
			throw new NonQuadraticMatrixException();

		MatrixReturnDto matrizReturn = new MatrixReturnDto();

		if (array.length == 1) {
			int[][] matrizGenereted = new int[1][1];
			matrizGenereted[0][0] = array[0];

			matrizReturn.setMatrizOriginal(matrizGenereted);
			matrizReturn.setMatrizFliped(matrizGenereted);
		} else {

			int[][] matrizGenereted = matrizBo.arrayToQuadraticMatrix(array);
			int[][] matrizFliped = matrizBo.flipMatrix(matrizGenereted);

			matrizReturn.setMatrizOriginal(matrizGenereted);
			matrizReturn.setMatrizFliped(matrizFliped);
		}
		
		return matrizReturn;
	}
}
