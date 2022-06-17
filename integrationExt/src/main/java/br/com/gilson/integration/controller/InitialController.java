package br.com.gilson.integration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class InitialController {
	
	@GetMapping
	public ResponseEntity<String> startGet() {
		return ResponseEntity.ok("Sucesso get");
	}
	
	@PutMapping
	public ResponseEntity<String> startPut() {
		return ResponseEntity.ok("Sucesso put");
	}
	
	@PostMapping
	public ResponseEntity<String> startPost() {
		return ResponseEntity.ok("Sucesso post");
	}
	
	@DeleteMapping
	public ResponseEntity<String> startDelete() {
		return ResponseEntity.ok("Sucesso delete");
	}

}
