package br.com.gilson.learning.beanexemplify.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gilson.learning.beanexemplify.service.CalculadoraComNome;

@SpringBootTest
public class CalculadoraComNomeTest {

	@Autowired
	@Qualifier("HP")
	private CalculadoraComNome calculadoraHP;
	
	@Autowired
	@Qualifier("Generic")
	private CalculadoraComNome calculadoraGeneric;
	
	@Test
	public void calculadoraDevePossuirUmNome() {
		
		assertThat("Calculador não pode ter nome nulo ou vazio", this.calculadoraHP.getNome(), not(blankOrNullString()));
	}
	
	@Test
	public void calculadoraDevePossuirNomeHP() {
		
		assertEquals("HP", this.calculadoraHP.getNome(), "Calculadora HP");
	}
	
	@Test
	public void calculadoraDevePossuirNomeGeneric() {
		
		assertEquals("Genérico", this.calculadoraGeneric.getNome(), "Calculadora Genérica");
	}

}
