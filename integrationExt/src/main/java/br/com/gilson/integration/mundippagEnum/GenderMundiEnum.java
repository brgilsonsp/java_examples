package br.com.gilson.integration.mundippagEnum;

public enum GenderMundiEnum {

	male("male"), female("female");

	private String value;

	GenderMundiEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
