package br.com.gilson.examples.springcloudfunctionaws.service;

import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FunctionImplementation implements Function<Map<String, Object>, String> {

	private static Logger logger = LoggerFactory.getLogger(FunctionImplementation.class);
	
	@Autowired
	private ReverseValueString reverseValueString;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public String apply(Map<String, Object> value) {
		try {
			String valueAsJson = this.objectMapper.writeValueAsString(value);
			logger.info("Entry value: {}", valueAsJson);
			String valueAsJsonReserve =  this.reverseValueString.reverse(valueAsJson);
			logger.info("Result value: {}", valueAsJsonReserve);
			return valueAsJsonReserve;
		} catch (JsonProcessingException e) {
			logger.error("Deu pau....", e);
		}
		
		return "Deu problema aqui";
	}

}
