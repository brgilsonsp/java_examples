package br.com.d2st.exportacao.model;

import java.io.Serializable;

public enum MessageNumber implements Serializable{

	One("1"), Two("2"), Three("3"), Four("4"), Five("5");
	
	private String messageNumber;  
	
	MessageNumber(String number){
		messageNumber = number;
	}

	public String getMessageNumber() {
		return messageNumber;
	}
}
