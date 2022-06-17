package br.com.gilson.integration.entity.prop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gilson.integration.MundipaggPaymentApplication;
import br.com.gilson.integration.annotations.DefaultPropertiesTest;
import br.com.gilson.integration.entity.prop.ConfigurationApiProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MundipaggPaymentApplication.class)
@DefaultPropertiesTest
public class ConfigurationApiPropertiesTest {
	
	@Autowired
	private ConfigurationApiProperties properties;
	
	@Test
	public void mustBeReturnKeyAndTokenToAuthorizationAccess() {
		//Build scenario
		String key = "tokenapi";
		String value = "432#$)9+21*76kippay";
		
		//Execute test
		assertThat(this.properties.getKey()).isEqualTo(key);
		assertThat(this.properties.getToken()).isEqualTo(value);
	}

}
