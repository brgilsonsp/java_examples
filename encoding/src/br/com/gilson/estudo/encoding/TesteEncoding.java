package br.com.gilson.estudo.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {

		System.out.println(String.format("Default encondig: %s" , Charset.defaultCharset()));
		
		final String valor = "é";
		System.out.println(String.format("codePoint table UNICODE to '%s' is: %d", valor, valor.codePointAt(0)));
		
		transformEncoding(valor, "windows-1252", StandardCharsets.UTF_8.displayName());
		transformEncoding(valor, StandardCharsets.ISO_8859_1.displayName(), "windows-1252");
		transformEncoding(valor, StandardCharsets.US_ASCII.displayName(), StandardCharsets.ISO_8859_1.displayName());
		transformEncoding(valor, StandardCharsets.UTF_16.displayName(), StandardCharsets.US_ASCII.displayName());
		transformEncoding(valor, StandardCharsets.UTF_16BE.displayName(), StandardCharsets.UTF_16.displayName());
		transformEncoding(valor, StandardCharsets.UTF_16LE.displayName(), StandardCharsets.UTF_16BE.displayName());
		transformEncoding(valor, StandardCharsets.UTF_8.displayName(), StandardCharsets.UTF_16LE.displayName());
	}
	
	private static void transformEncoding(final String valor, final String encoding, final String otherEncoding) throws UnsupportedEncodingException {

		System.out.println();
		
		System.out.println(String.format("Using correct encondig %s and incorrect encoding %s", encoding, otherEncoding));
		byte[] bytes = valor.getBytes(encoding);
		System.out.println(
				String.format("size of the bytes: %d  -  bytes to string correct encoding: %s, or incorrect encoding %s", 
								bytes.length, 
								new String(bytes, encoding),
								new String(bytes, otherEncoding)));
		
	}
	
	

}
