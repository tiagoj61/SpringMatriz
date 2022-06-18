package tiago.j61.projeto.exception;

public class NonQuadraticMatrixException extends Exception {
	public NonQuadraticMatrixException() {
		super("A matriz processada não é quadratica, não valida para essa aplicação.");
	}
}
