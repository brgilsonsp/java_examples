package br.com.gilson.learning.beanexemplify.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gilson.learning.beanexemplify.service.CalculadoraComNome;

@Configuration
public class ConfigurationExemplify {
	
	@Bean(name = "HP")
	public CalculadoraComNome getCalculadoraComNomeHP() {
		return new CalculadoraComNome("HP");
	}
	
	@Bean
	@Qualifier("Generic")
	public CalculadoraComNome getCalculadoraComNomeGeneric() {
		return new CalculadoraComNome("Genérico");
	}
}
