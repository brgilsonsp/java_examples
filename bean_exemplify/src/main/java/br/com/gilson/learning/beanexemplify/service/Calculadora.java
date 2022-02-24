package br.com.gilson.learning.beanexemplify.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
	
	public BigDecimal somaDoisNumeros(BigDecimal firstNumber, BigDecimal secondNumber) {
		return firstNumber.add(secondNumber);
	}
}