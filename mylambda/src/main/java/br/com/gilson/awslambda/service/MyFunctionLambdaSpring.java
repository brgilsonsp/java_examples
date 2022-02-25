package br.com.gilson.awslambda.service;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gilson.awslambda.model.ModelRequest;

@Component
public class MyFunctionLambdaSpring {

	public Function<ModelRequest, ModelRequest> myHandler(){
		return value -> {
			value.setCode(UUID.randomUUID().toString());
			System.out.println(value.toString());
			return value;
		};
	}
}
