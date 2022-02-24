package br.com.gilson.beanvalidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.gilson.beanvalidation.model.ResponseValidation;


public class ValidatorProgramatic<T> {

	public List<ResponseValidation> validModel(T user) {
		Validator validator = buildValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(user);
		
		List<ResponseValidation> responses = new ArrayList<>();
		
		violations.stream().forEach(constraint -> {
			ResponseValidation response = ResponseValidation.builder()
			.property(constraint.getPropertyPath().toString())
			.message(constraint.getMessage())
			.build();
			
			responses.add(response);
		});
		
		return responses;
	}
	
	private Validator buildValidator() {
    	ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        return validationFactory.getValidator();
    }
	
	
}
