package br.com.gilson.integration.utils;

import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import br.com.gilson.integration.entity.OrderMund;

@Component
public class BuildErrorsValidator {
	
	private final String DEFAULT_FIELD = "ERROR";	
	
	/**
	 * Make the StringBuilder with the list errors
	 * 
	 * @param errors List<ObjectErrors>. The list with the all errors
	 * @return Object StringBuild with the errors formatted
	 */
	public StringBuilder buildMessageValidation(List<ObjectError> errors) {
		return this.buildMessageValidation(errors, null);
	}
	
	/**
	 * Make the StringBuilder with the list errors and the errors built on the object orderMundi
	 * 
	 * @param errors List<ObjectErrors>. The list with the all errors
	 * @param orderMundi Object OrderMundi
	 * @return Object StringBuild with the errors formatted
	 */
	public StringBuilder buildMessageValidation(List<ObjectError> errors, OrderMund orderMundi) {
		StringBuilder builder = new StringBuilder();
		int indexError = 0;
		builder.append("Errors: [");
		for (ObjectError error : errors) {
			indexError++;
			String fieldName = buildFieldName(error.getArguments(), indexError);
			builder.append("{");
			builder.append(fieldName);
			builder.append(" ");
			builder.append(error.getDefaultMessage());
			builder.append("}");

			if (indexError < errors.size())
				builder.append(", ");
		}
		
		if(orderMundi != null && orderMundi.hasErrorNotNoted()) {
			if(errors.size() > 0)
				builder.append(",");
			
			builder.append(orderMundi.getErrorValidationNotNoted());
		}
		
		builder.append("]");
		return builder;
	}

	private String buildFieldName(Object[] arguments, int step) {
		try {
			DefaultMessageSourceResolvable message = (DefaultMessageSourceResolvable)arguments[0];
			return message.getDefaultMessage();
		}catch(Exception e) {
			return DEFAULT_FIELD + " " + step;
		}
	}
	
	
}
