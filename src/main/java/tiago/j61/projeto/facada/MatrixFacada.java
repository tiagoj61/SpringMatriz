package tiago.j61.projeto.facada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiago.j61.projeto.dto.MatrixRequestDto;
import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.MatrixBadRequestException;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.service.MatrixService;

@Service
public class MatrixFacada {
	@Autowired
	private MatrixService matrizBo;

	public MatrixReturnDto flipArray(MatrixRequestDto matrixRequestDto)
			throws NonQuadraticMatrixException, MatrixBadRequestException {

		if (matrixRequestDto == null)
			throw new MatrixBadRequestException();

		int[] array = matrixRequestDto.getArray();

		if (!matrizBo.matrixValid(array))
			throw new NonQuadraticMatrixException();

		MatrixReturnDto matrizReturn = new MatrixReturnDto();

		int[][] matrizGenereted = matrizBo.arrayToQuadraticMatrix(array);
		int[][] matrizFliped = matrizBo.flipMatrix(matrizGenereted);

		matrizReturn.setMatrixOriginal(matrizGenereted);
		matrizReturn.setMatrixFliped(matrizFliped);

		return matrizReturn;
	}
}
