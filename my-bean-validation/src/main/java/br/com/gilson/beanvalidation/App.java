package br.com.gilson.beanvalidation;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gilson.beanvalidation.model.ResponseValidation;
import br.com.gilson.beanvalidation.model.User;

/**
 * 
 * @author Gilson Souza
 * @version 1.0.0
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws JsonProcessingException
    {
    	User user = new User();
        user.setName("Um nome");
        
        List<ResponseValidation> validations = new ValidatorProgramatic<User>().validModel(user);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String validationsJson = objectMapper.writeValueAsString(validations);
        
        System.out.println(validationsJson);
    }
    
    
}
