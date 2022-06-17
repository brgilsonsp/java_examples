package br.com.gilson.integration.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartConference {
	
	public StartConference() {
	}

	public StartConference(Boolean isStartConference) {
		this.isStartConference = isStartConference;
	}

	@JsonProperty("isStartConference")
	private Boolean isStartConference;

	public Boolean getIsStartConference() {
		return isStartConference;
	}
}
