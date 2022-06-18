package tiago.j61.projeto.dto;

import java.io.Serializable;

public class MatrixReturnDto implements Serializable {
	private int[][] matrixOriginal;
	private int[][] matrixFliped;

	public int[][] getMatrixOriginal() {
		return matrixOriginal;
	}

	public void setMatrixOriginal(int[][] matrixOriginal) {
		this.matrixOriginal = matrixOriginal;
	}

	public int[][] getMatrixFliped() {
		return matrixFliped;
	}

	public void setMatrixFliped(int[][] matrixFliped) {
		this.matrixFliped = matrixFliped;
	}

}
