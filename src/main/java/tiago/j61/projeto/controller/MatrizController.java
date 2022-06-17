package tiago.j61.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tiago.j61.projeto.dto.ErroMatrizMensageDto;
import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.facada.MatrixFacada;

@RestController
public class MatrizController {
	@Autowired
	private MatrixFacada matrizFacada;

	@PostMapping(path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody int[] newUser) {
		try {

			MatrixReturnDto matrizReturn = matrizFacada.flipArray(newUser);

			return new ResponseEntity<>(matrizReturn, HttpStatus.CREATED);
		} catch (NonQuadraticMatrixException e) {
			return new ResponseEntity<>(new ErroMatrizMensageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
