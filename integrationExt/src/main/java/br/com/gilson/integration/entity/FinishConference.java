package br.com.gilson.integration.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinishConference {

	public FinishConference() {
	}

	public FinishConference(Boolean isFinishConference) {
		this.isFinishConference = isFinishConference;
	}

	@JsonProperty("isFinishConference")
	private Boolean isFinishConference;

	public Boolean getIsFinishConference() {
		return isFinishConference;
	}

}
