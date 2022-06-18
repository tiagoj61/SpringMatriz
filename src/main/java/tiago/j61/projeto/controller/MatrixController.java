package tiago.j61.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tiago.j61.projeto.dto.ErroMatrixMensageDto;
import tiago.j61.projeto.dto.MatrixRequestDto;
import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.exception.MatrixBadRequestException;
import tiago.j61.projeto.exception.NonQuadraticMatrixException;
import tiago.j61.projeto.facada.MatrixFacada;

@RestController
public class MatrixController {
	@Autowired
	private MatrixFacada matrizFacada;

	@ApiOperation(value = "Generate quadratic matrix from array and rotate", response = MatrixReturnDto.class, tags = "matrix")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created|Rotated", response = MatrixReturnDto.class),
			@ApiResponse(code = 400, message = "Array cannot generate a quadratic matrix!", response = ErroMatrixMensageDto.class),
			@ApiResponse(code = 500, message = "Internal server error!") })
	@PostMapping(path = "flipMatrix", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody MatrixRequestDto request) {
		try {

			if (request == null || request.getArray() == null)
				throw new MatrixBadRequestException();

			MatrixReturnDto matrizReturn = matrizFacada.flipArray(request);
			return new ResponseEntity<>(matrizReturn, HttpStatus.CREATED);

		} catch (MatrixBadRequestException e) {
			return new ResponseEntity<>(new ErroMatrixMensageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (NonQuadraticMatrixException e) {
			return new ResponseEntity<>(new ErroMatrixMensageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
