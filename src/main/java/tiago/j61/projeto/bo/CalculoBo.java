package tiago.j61.projeto.bo;

import org.springframework.stereotype.Service;

import tiago.j61.projeto.exception.MatrizNaoQuadraticaException;

@Service
public class CalculoBo {

	public boolean isNumeroQuadratico(int numero) {
		double raiz = Math.sqrt(numero);
		int partedecimal = (int) raiz;
		double parteFractional = raiz - partedecimal;
		return parteFractional != 0 ? true : false;
	}
}
