package br.com.gilson.examples.services;

import br.com.gilson.examples.config.SqsConfiguration;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

public class SendMessageQueue {
	
	public String sendMessageToQeue(String message) {
		
		SqsClient sqsClient = new SqsConfiguration().buildSqsClient();
		String URL_QUEUE = SqsConfiguration.getUrlQueueOfTheSystemVariable(sqsClient);
		
		SendMessageRequest sendMessageRequest = SendMessageRequest
													.builder()
													.queueUrl(URL_QUEUE)
													.messageBody(message)
													.build();
		
		SendMessageResponse sendMessageResponse = sqsClient.sendMessage(sendMessageRequest);
		sqsClient.close();
		return sendMessageResponse.messageId();
	}
}
