package br.com.gilson.examples.service.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;

public class HttpClientBuilder {

	public static HttpClient buildHttpClient() {
		return HttpClient.newBuilder().version(Version.HTTP_2).connectTimeout(Duration.ofMillis(30000))
				.followRedirects(Redirect.NORMAL).build();
	}

	public static HttpRequest builHttpRequest(String pathResource, String bodyJson) {
		return HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/" + pathResource))
				.timeout(Duration.ofMillis(30000)).header("oneHeader", "valueOneHeader")
				.header("twoHeader", "valueTwoHeader").header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(bodyJson)).build();
	}
}
