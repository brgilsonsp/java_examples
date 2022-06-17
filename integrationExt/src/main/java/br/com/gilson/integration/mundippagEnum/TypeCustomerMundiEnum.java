package br.com.gilson.integration.mundippagEnum;

public enum TypeCustomerMundiEnum {
	individual("individual"), company("company");

	private String value;

	TypeCustomerMundiEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
