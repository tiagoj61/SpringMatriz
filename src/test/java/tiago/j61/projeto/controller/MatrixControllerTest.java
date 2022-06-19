package tiago.j61.projeto.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import tiago.j61.projeto.dto.ErroMatrixMensageDto;
import tiago.j61.projeto.dto.MatrixReturnDto;
import tiago.j61.projeto.helper.MatrixHelper;
import tiago.j61.projeto.helper.ReflectionHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MatrixControllerTest {

	private String url;
	private String port = "8080";

	@BeforeEach
	void asd() throws Exception {
		url = "http://localhost:" + port + "/";
	}

	@Test
	@DisplayName("Test correct body")
	void correctBodyFlipMatrix() {
		assertNotNull(url);

		String path = ReflectionHelper.getPathFromMethod(MatrixController.class, 0);

		assertNotNull(path);

		boolean isMatrixQuadratic = true;

		ResponseEntity<MatrixReturnDto> response = new RestTemplate().postForEntity(url + path,
				MatrixHelper.generateMatrixRequestDto(isMatrixQuadratic), MatrixReturnDto.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getMatrixOriginal());
		assertNotNull(response.getBody().getMatrixFliped());
	}

	@Test
	@DisplayName("Test non correct body")
	void nonCorrectBodyFlipMatrix() {
		String path = ReflectionHelper.getPathFromMethod(MatrixController.class, 0);
		boolean isMatrixQuadratic = false;
		try {
			ResponseEntity<ErroMatrixMensageDto> response = new RestTemplate().postForEntity(url + path,
					MatrixHelper.generateMatrixRequestDto(isMatrixQuadratic), ErroMatrixMensageDto.class);

		} catch (RestClientResponseException response) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), response.getRawStatusCode());
			assertNotNull(response.getResponseBodyAsString());

			JSONObject responseBody = assertDoesNotThrow(() -> new JSONObject(response.getResponseBodyAsString()));

			String fieldNameMatrix = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 1);

			JSONArray jsMatrixResponse = (JSONArray) assertDoesNotThrow(() -> responseBody.get(fieldNameMatrix));

			assertNotNull(jsMatrixResponse);

			assertEquals(jsMatrixResponse.length(), 0);

			String fieldNameMensage = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 0);

			assertNotNull(assertDoesNotThrow(() -> responseBody.get(fieldNameMensage)));
		}
	}

	@Test
	@DisplayName("Test without array body")
	void withoutArrayBodyFlipMatrix() {
		String path = ReflectionHelper.getPathFromMethod(MatrixController.class, 0);
		boolean isMatrixQuadratic = false;
		try {
			ResponseEntity<ErroMatrixMensageDto> response = new RestTemplate().postForEntity(url + path,
					MatrixHelper.generateMatrixRequestWithoutArrrayDto(), ErroMatrixMensageDto.class);

		} catch (RestClientResponseException response) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), response.getRawStatusCode());
			assertNotNull(response.getResponseBodyAsString());

			JSONObject responseBody = assertDoesNotThrow(() -> new JSONObject(response.getResponseBodyAsString()));

			String fieldNameMatrix = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 1);

			JSONArray jsMatrixResponse = (JSONArray) assertDoesNotThrow(() -> responseBody.get(fieldNameMatrix));

			assertNotNull(jsMatrixResponse);

			assertEquals(jsMatrixResponse.length(), 0);

			String fieldNameMensage = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 0);

			assertNotNull(assertDoesNotThrow(() -> responseBody.get(fieldNameMensage)));
		}
	}

}