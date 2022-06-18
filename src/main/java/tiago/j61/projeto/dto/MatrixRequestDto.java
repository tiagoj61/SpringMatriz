package tiago.j61.projeto.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class MatrixRequestDto implements Serializable {
	@ApiModelProperty(notes = "Array to be rotated", name = "array", required = true, value = "[1]")
	private int[] array;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

}
