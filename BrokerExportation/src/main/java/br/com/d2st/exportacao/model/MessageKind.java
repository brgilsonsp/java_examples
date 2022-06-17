package br.com.d2st.exportacao.model;

import java.io.Serializable;

public enum MessageKind implements Serializable{

	Exportation("Exportação"), Importation("Importação");
	
	private String messageKing;
	
	MessageKind(String kind){
		this.messageKing = kind;
	}

	public String getMessageKing() {
		return messageKing;
	}
}

