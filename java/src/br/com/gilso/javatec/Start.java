package br.com.gilso.javatec;

import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;

public class Start {

	public static void main(String[] args) throws NamingException {
		List<CarPojo> cars = Arrays.asList(new CarPojo("fusca", "79"), new CarPojo("brasilia", "01"), new CarPojo("camaro", "10"));
		
		new SelectCar().printCarByPredicate(cars, (p) -> p.getName().equals("fusca"), p -> p.print());

	}

}
