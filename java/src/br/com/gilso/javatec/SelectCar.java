package br.com.gilso.javatec;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.naming.CompositeName;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.spi.NamingManager;

public class SelectCar {
	
	public void printCarByPredicate(List<CarPojo> cars, Predicate<CarPojo> formSelect, Consumer<CarPojo> consumer) throws NamingException {
		
		
		CompositeName composite = new CompositeName("./");
		boolean empty = composite.isEmpty();
		Enumeration<String> all = composite.getAll();
		
		//Object doLookup = InitialContext.doLookup(composite);
		//doLookup.get
		InitialDirContext dir = new InitialDirContext();
		boolean hasInitialContextFactoryBuilder = NamingManager.hasInitialContextFactoryBuilder();
		dir.bind("one_bind", new CarPojo("fusca", "79"));
		final CarPojo carBind = dir.doLookup("one_bind");
		
		
		String nameInNamespace2 = dir.getNameInNamespace();
		
		InitialContext initialContext = new InitialContext();
		Object lookup = initialContext.lookup("br.com.gilso.javatec.person");
		Hashtable<?,?> environment = initialContext.getEnvironment();
		String nameInNamespace = initialContext.getNameInNamespace();
		
		cars.stream().filter(formSelect).forEach(consumer);
		
	}

}
