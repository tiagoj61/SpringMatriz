package tiago.j61.projeto.exception;

public class MatrixBadRequestException extends Exception {
	public MatrixBadRequestException() {
		super("The request cannot generate a marix!");
	}
}
