package br.com.gilson.examples.config;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;

public class SqsConfiguration {

	
	public SqsClient buildSqsClient() {
		return SqsClient
			.builder()
			.region(Region.US_EAST_1)
			.build();
	}
	
	public static String getUrlQueueOfTheSystemVariable(SqsClient sqsClient) {
		String queueName = System.getenv("NAME_QUEUE_ENTRADA_REGAR_PLANTA");
		GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
		
		GetQueueUrlResponse getQueueUrlResponse = sqsClient.getQueueUrl(getQueueUrlRequest);
		
		return getQueueUrlResponse.queueUrl();
	}
}
