package br.com.gilson.learning.beanexemplify.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gilson.learning.beanexemplify.service.Calculadora;

@SpringBootTest
public class CalculadoraTest {
	
	@Autowired
	private Calculadora calculadora;
	
	@Test
	public void deveSomarDoisNumeros() {
		BigDecimal first = new BigDecimal("12");
		BigDecimal second = new BigDecimal("10");
		
		BigDecimal expected = first.add(second);
		
		BigDecimal result = this.calculadora.somaDoisNumeros(first, second);
		
		assertEquals(expected, result, "Result equals 22");
	}

}
