package tiago.j61.projeto.bo;

import org.springframework.stereotype.Service;

import tiago.j61.projeto.exception.MatrizNaoQuadraticaException;

@Service
public class MatrizBo {

	public void matrizValida(int[] matriz) throws MatrizNaoQuadraticaException {
		if(matriz.length%2 !=0 ) {
			throw new MatrizNaoQuadraticaException();
		}
	}
}
