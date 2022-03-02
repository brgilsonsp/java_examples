package br.com.gilson.examples;

import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.gilson.examples.model.RegadorPlanta;
import br.com.gilson.examples.services.SendMessageQueue;

public class StartRegarPlanta implements RequestHandler<Map<String, Object>, RegadorPlanta> 
{
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static SendMessageQueue sendMessageQueue = new SendMessageQueue();
	
	
	@Override
	public RegadorPlanta handleRequest(Map<String, Object> event, Context context) {
		LambdaLogger logger = context.getLogger();
		
		String eventJson = gson.toJson(event);
		logger.log("Event received: " + eventJson);
		
		String messageId = sendMessageQueue.sendMessageToQeue(eventJson);
		logger.log("Messade ID: " + messageId);
		
		RegadorPlanta regadorPlanta = RegadorPlanta.builder().id(UUID.randomUUID().toString()).build();
		return regadorPlanta;
	}
}
