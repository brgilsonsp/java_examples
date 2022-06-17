package br.com.gilson.integration.mundippagEnum;

public enum StatusItemMundiEnum {
	
	active("active"), deleted("deleted");

	private String value;

	StatusItemMundiEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
