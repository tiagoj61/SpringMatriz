package tiago.j61.projeto.dto;

import java.io.Serializable;

public class MatrixReturnDto implements Serializable {
	private int[][] matrizOriginal;
	private int[][] matrizFliped;

	public int[][] getMatrizOriginal() {
		return matrizOriginal;
	}

	public void setMatrizOriginal(int[][] matrizOriginal) {
		this.matrizOriginal = matrizOriginal;
	}

	public int[][] getMatrizFliped() {
		return matrizFliped;
	}

	public void setMatrizFliped(int[][] matrizFliped) {
		this.matrizFliped = matrizFliped;
	}

}
