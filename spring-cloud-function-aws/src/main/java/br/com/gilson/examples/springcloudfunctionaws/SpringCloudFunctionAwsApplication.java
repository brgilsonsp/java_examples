package br.com.gilson.examples.springcloudfunctionaws;

import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.gilson.examples.springcloudfunctionaws.service.FunctionImplementation;

@SpringBootApplication
public class SpringCloudFunctionAwsApplication {
	

	private static Logger logger = LoggerFactory.getLogger(SpringCloudFunctionAwsApplication.class);
	/*	
	@Autowired
	private FunctionImplementation functionImplementation;
*/
	public static void main(String[] args) {
		//SpringApplication.run(SpringCloudFunctionAwsApplication.class, args);
	}
	
	@Bean
	public Function<String, String> uppercase() {
		logger.info("Entrou no logger.info");
		return value -> {
			if (value.equals("exception")) {
				throw new RuntimeException("Intentional exception");
			}
			else {
				return value.toUpperCase();
			}
		};
	}
	
	/*
	@Bean
	public Function<Map<String, Object>, String> functionImplementation(){
		System.out.println("Entrou no syso");
		logger.info("Entrou no logger.info");
		return this.functionImplementation;
	}
	
	
	@Bean
	public Function<Map<String, Object>, String> reverseString(){
		System.out.println("Entrou no syso");
		logger.info("Entrou no logger.info");
		return value -> {
			String valueAsJson;
			try {
				valueAsJson = this.objectMapper.writeValueAsString(value);
				logger.info("Entry value: {}", valueAsJson);
				String valueAsJsonReserve =  this.reverseValueString.reverse(valueAsJson);
				logger.info("Result value: {}", valueAsJsonReserve);
				return valueAsJsonReserve;
			} catch (JsonProcessingException e) {
				logger.error("Deu pau....", e);
			}
			
			return "Deu problema aqui";
		};
	}
	*/
}
