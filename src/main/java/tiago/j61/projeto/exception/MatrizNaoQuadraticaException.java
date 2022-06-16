package tiago.j61.projeto.exception;

public class MatrizNaoQuadraticaException extends Exception {
	public MatrizNaoQuadraticaException() {
		super("A matriz processada não é quadratica");
	}
}
