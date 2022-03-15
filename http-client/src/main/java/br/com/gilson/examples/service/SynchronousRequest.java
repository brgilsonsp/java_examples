package br.com.gilson.examples.service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.gilson.examples.service.util.BodyPostBuilderUtils;
import br.com.gilson.examples.service.util.HttpClientBuilder;

public class SynchronousRequest {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	
	public static void main(String[] args) throws Exception {
		new SynchronousRequest().requestSync();
	}

	public void requestSync() throws Exception {
		String bodyJson = BodyPostBuilderUtils.buildDog();
		
		HttpClient httpClient = HttpClientBuilder.buildHttpClient();
		HttpRequest httpRequest = HttpClientBuilder.builHttpRequest("test", bodyJson);
		HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
		System.out.println("BodyResponse: " + httpResponse.body());
		System.out.println("HeadersResponse: " + gson.toJson(httpResponse.headers().map()));
		System.out.println("statusCodeResponse: " + httpResponse.statusCode());
		System.out.println("uri: " + httpResponse.uri());
		httpResponse.sslSession().ifPresent(ssl -> System.out.println(gson.toJson(ssl.getValueNames())));
		System.out.println("verionResponse: " + httpResponse.version());
			
	}

}
