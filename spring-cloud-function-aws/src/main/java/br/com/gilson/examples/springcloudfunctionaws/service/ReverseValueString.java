package br.com.gilson.examples.springcloudfunctionaws.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseValueString {

	public String reverse(final String value) {
		return new StringBuilder(value).reverse().toString();
	}
}
