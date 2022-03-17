package br.com.gilson.examples.service.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BodyPostBuilderUtils {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	
	public static String buildDog() {
		Map<String, Object> dog = new HashMap<>();
		Map<String, Object> identity = new HashMap<>();
		identity.put("name", "hulk");
		identity.put("weight", 11.5);
		identity.put("color", "black");
		Map<String, Object> breed = new HashMap<>();
		breed.put("name", "german shepherd");
		dog.put("identity", identity);
		dog.put("breed", breed);
		String bodyJson = gson.toJson(dog);
		return bodyJson;
	}
}
