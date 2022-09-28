package br.com.gilson.examples.serverrest.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.gilson.examples.serverrest.model.ObjectReturn;

@RestController
public class ServerFreeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/wspr/pedidosub")
	public List<ObjectReturn> getObjects(){
		ObjectReturn object = new ObjectReturn();
		ObjectReturn objectII = new ObjectReturn();
		List<ObjectReturn> list = new ArrayList<>();
		list.add(object);
		list.add(objectII);
		return list;
	}

	@GetMapping("/test")
	public Map<String, Object> getAnyBody(){
		Map<String, Object> response = new HashMap<>();
		response.put("field_one", "value_one");
		response.put("field_two", "value_two)");

		return response;
	}
	
	@PostMapping("/test")
	public String invokeMap(@RequestBody Map<String, Object> in) {
		String bodyJson;
		
		
		try {
			bodyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(in);
			File file = new File("cidade.json");
			try(OutputStreamWriter oustream = new FileWriter(file)){
				oustream.write(bodyJson);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			bodyJson = "deu erro";
		}
		System.out.println(bodyJson);
		logger.info(bodyJson);
		
		return bodyJson;
	}
}
