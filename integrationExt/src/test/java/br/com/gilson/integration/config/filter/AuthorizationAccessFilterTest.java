package br.com.gilson.integration.config.filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import br.com.gilson.integration.MundipaggPaymentApplication;
import br.com.gilson.integration.annotations.DefaultPropertiesTest;
import br.com.gilson.integration.entity.prop.ConfigurationApiProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MundipaggPaymentApplication.class)
@AutoConfigureMockMvc
@DefaultPropertiesTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationAccessFilterTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ConfigurationApiProperties properties;

	private final String PATH_RESOURCE = "/api";

	@Test
	public void mustBeReturnStatusBadRequestWhenRequestWhithoutValidToken() throws Exception {
		// Build scenario

		// Execute operation
		ResultActions postResult = this.mock.perform(post(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON));
		ResultActions putResult = this.mock.perform(put(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON));
		ResultActions getResult = this.mock.perform(get(this.PATH_RESOURCE));
		ResultActions deleteResult = this.mock.perform(delete(this.PATH_RESOURCE));

		// Execute test
		postResult.andExpect(status().isBadRequest());
		putResult.andExpect(status().isBadRequest());
		getResult.andExpect(status().isBadRequest());
		deleteResult.andExpect(status().isBadRequest());
	}

	@Test
	public void mustBeReturnStatusForbiddenWhenRequestWhithInvalidToken() throws Exception {
		// Build scenario
		String invalidToken = this.properties.getToken() + "_INVALID";
		
		// Execute operation
		ResultActions postResult = this.mock
				.perform(post(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), invalidToken));
		ResultActions putResult = this.mock
				.perform(put(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), invalidToken));
		ResultActions getResult = this.mock.perform(get(this.PATH_RESOURCE)
				.header(this.properties.getKey(), invalidToken));
		ResultActions deleteResult = this.mock.perform(delete(this.PATH_RESOURCE)
				.header(this.properties.getKey(), invalidToken));

		// Execute test
		postResult.andExpect(status().isForbidden());
		putResult.andExpect(status().isForbidden());
		getResult.andExpect(status().isForbidden());
		deleteResult.andExpect(status().isForbidden());
	}
	
	@Test
	public void mustBeReturnStatus200WhenRequestWhithValidToken() throws Exception {
		// Build scenario
		String token = this.properties.getToken();

		// Execute operation
		ResultActions postResult = this.mock
				.perform(post(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), token));
		ResultActions putResult = this.mock
				.perform(put(this.PATH_RESOURCE).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), token));
		ResultActions getResult = this.mock.perform(get(this.PATH_RESOURCE)
				.header(this.properties.getKey(), token));
		ResultActions deleteResult = this.mock.perform(delete(this.PATH_RESOURCE)
				.header(this.properties.getKey(), token));

		// Execute test
		postResult.andExpect(status().isOk());
		putResult.andExpect(status().isOk());
		getResult.andExpect(status().isOk());
		deleteResult.andExpect(status().isOk());
	}

}
