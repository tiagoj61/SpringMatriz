package tiago.j61.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrizController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Sprasd!";
	}
	
}
