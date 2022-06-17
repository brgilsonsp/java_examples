package br.com.gilson.integration.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gilson.integration.MundipaggPaymentApplication;
import br.com.gilson.integration.annotations.DefaultPropertiesTest;
import br.com.gilson.integration.entity.OrderMund;
import br.com.gilson.integration.repository.objects.OrderMundObjectTest;
import br.com.gilson.integration.services.OrderMundiService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MundipaggPaymentApplication.class)
@DefaultPropertiesTest
public class OrderMundiServiceTest {

	@Autowired
	private OrderMundiService service;
	
	@Autowired
	private OrderMundObjectTest objectTest;
	
	@Test
	public void mustBeReturnObjectManagedWhenSaveOrUpdateValidOrderMundi() throws Exception {
		//Build scenario
		OrderMund orderMundTransient = this.objectTest.mustBeReturnObjectManagedWhenSaveOrUpdateValidOrderMundi();
		Exception exception = null;
		OrderMund orderMundiManaged = null;
		
		//Execute operation
		try {
			orderMundiManaged = this.service.saveOrUpate(orderMundTransient);
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiManaged).isNotNull();
		assertThat(orderMundiManaged.getId()).isPositive();
		assertEquals(orderMundTransient.getIdVanrooy(), orderMundiManaged.getIdVanrooy());
	}
	
	
	@Test
	public void mustBeReturnObjectManagedWhenFoundRecordByIdVanrooy() throws Exception {
		//Build scenario
		OrderMund orderMundTransient = this.objectTest.mustBeReturnObjectManagedWhenFoundRecordByIdVanrooy();
		OrderMund orderMundiManaged = this.service.saveOrUpate(orderMundTransient);
		Exception exception = null;
		OrderMund orderMundiManagedFound = null;
		
		//Execute operation
		try {
			orderMundiManagedFound = this.service.findByIdVanrooy(orderMundiManaged.getIdVanrooy());
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiManagedFound).isNotNull();
		assertEquals(orderMundiManaged.getId(), orderMundiManagedFound.getId());
		assertEquals(orderMundiManaged.getIdVanrooy(), orderMundiManagedFound.getIdVanrooy());
	}
	
	@Test
	public void mustBeReturnObjectTransientWhenNotFoundRecordByIdVanrooy() {
		//Build scenario
		Exception exception = null;
		OrderMund orderMundiTransientFound = null;
		
		//Execute operation
		try {
			orderMundiTransientFound = this.service.findByIdVanrooy(null);
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiTransientFound).isNotNull();
		assertThat(orderMundiTransientFound.getId()).isNull();
		assertEquals(null, orderMundiTransientFound.getIdVanrooy());
	}
	
	@Test
	public void mustBeReturnObjectManagedWhenFoundRecordById() throws Exception {
		//Build scenario
		OrderMund orderMundTransient = this.objectTest.mustBeReturnObjectManagedWhenFoundRecordById();
		OrderMund orderMundiManaged = this.service.saveOrUpate(orderMundTransient);
		Exception exception = null;
		OrderMund orderMundiManagedFound = null;
		
		//Execute operation
		try {
			orderMundiManagedFound = this.service.findById(orderMundiManaged.getId());
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiManagedFound).isNotNull();
		assertEquals(orderMundiManaged.getId(), orderMundiManagedFound.getId());
		assertEquals(orderMundiManaged.getIdVanrooy(), orderMundiManagedFound.getIdVanrooy());
	}
	
	@Test
	public void mustBeReturnObjectTransientWhenNotFoundRecordById() {
		//Build scenario
		Exception exception = null;
		OrderMund orderMundiTransientFound = null;
		
		//Execute operation
		try {
			orderMundiTransientFound = this.service.findById(null);
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiTransientFound).isNotNull();
		assertThat(orderMundiTransientFound.getId()).isNull();
		assertEquals(null, orderMundiTransientFound.getIdVanrooy());
	}
	
	@Test
	public void mustBeDeleteObjectManaged() throws IOException {
		//Build scenario
		Exception exception = null;
		OrderMund orderMundiTransientFound = null;
		OrderMund orderMundTransient = this.objectTest.mustBeDeleteObjectManaged();
		OrderMund orderMundManaged = this.service.saveOrUpate(orderMundTransient);
		Long idManaged = orderMundManaged.getId();
		
		//Execute operation
		try {
			this.service.delete(orderMundManaged);
			orderMundiTransientFound = this.service.findById(idManaged);
		}catch(Exception e) {
			exception = e;
		}
		
		//Execute tests
		assertThat(exception).isNull();
		assertThat(orderMundiTransientFound).isNotNull();
		assertThat(orderMundiTransientFound.getId()).isNull();
		assertEquals(null, orderMundiTransientFound.getIdVanrooy());
	}
	
	
}
