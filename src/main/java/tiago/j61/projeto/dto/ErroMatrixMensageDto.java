package tiago.j61.projeto.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErroMatrixMensageDto implements Serializable {
	private String mensagem;
	private List<Integer> matrix;

	public ErroMatrixMensageDto(String mensagem) {
		super();
		this.mensagem = mensagem;
		matrix = new ArrayList();
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Integer> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<Integer> matrix) {
		this.matrix = matrix;
	}

}
