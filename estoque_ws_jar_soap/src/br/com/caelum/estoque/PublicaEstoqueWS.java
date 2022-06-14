package br.com.caelum.estoque;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {

		final EstoqueWS service = new EstoqueWS();
		final String address = "http://localhost:9999/estoque_ws";
		Endpoint.publish(address, service);
	}
}
