package br.com.gilso.javatec.service;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;

public class InitialContextFactoryBuilderImpl implements InitialContextFactoryBuilder {

	@Override
	public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
		return new InitialContextFactoryImpl();
	}

}
