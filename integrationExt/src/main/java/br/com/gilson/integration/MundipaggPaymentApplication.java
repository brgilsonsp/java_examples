package br.com.gilson.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MundipaggPaymentApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MundipaggPaymentApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MundipaggPaymentApplication.class);
	}
}
