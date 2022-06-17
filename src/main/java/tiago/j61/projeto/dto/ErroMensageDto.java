package tiago.j61.projeto.dto;

import java.io.Serializable;

public class ErroMensageDto implements Serializable {
	private String mensagem;

	public ErroMensageDto(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
