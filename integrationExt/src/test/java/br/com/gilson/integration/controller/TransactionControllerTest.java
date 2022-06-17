package br.com.gilson.integration.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gilson.integration.MundipaggPaymentApplication;
import br.com.gilson.integration.annotations.DefaultPropertiesTest;
import br.com.gilson.integration.entity.FinishConference;
import br.com.gilson.integration.entity.OrderMund;
import br.com.gilson.integration.entity.OrderStatus;
import br.com.gilson.integration.entity.ResponseApi;
import br.com.gilson.integration.entity.StartConference;
import br.com.gilson.integration.entity.prop.ConfigurationApiProperties;
import br.com.gilson.integration.repository.objects.OrderMundObjectTest;
import br.com.gilson.integration.services.OrderMundiService;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MundipaggPaymentApplication.class)
@AutoConfigureMockMvc
@DefaultPropertiesTest
public class TransactionControllerTest {
	
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private OrderMundiService orderService;
	
	@Autowired
	private ConfigurationApiProperties properties;
	
	@Autowired
	private OrderMundObjectTest objectOrder;
	
	private final String PATH_RESOURCE = "/api/transaction";
	private final String PATH_SAVE_ORDER = PATH_RESOURCE + "/order";
	private final String PATH_START_CONFERENCE = PATH_RESOURCE + "/startConference";
	private final String PATH_FINISH_CONFERENCE = PATH_RESOURCE + "/finishConference";
	private final String PATH_RESULT_ORDER = PATH_RESOURCE + "/result";
	private final String PATH_RESULT_STATE = PATH_RESOURCE + "/state";
	private final String PATH_DELETE = PATH_RESOURCE + "/order/delete/inter/";
	
	@Test
	public void musBeReturnStatus417WhenRequestSaveInvalidOrderMundi() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus417WhenRequestSaveInvalidOrderMundi();
		String orderMundiJson = this.mapper.writeValueAsString(orderMundi);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions postResult = this.mock
				.perform(post(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = postResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		postResult.andExpect(status().isExpectationFailed());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("errors");
		assertThat(response.getMessage()).containsIgnoringCase("items");
		assertThat(response.getMessage()).containsIgnoringCase("payments");
		assertThat(response.getMessage()).containsIgnoringCase("it's necessary");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
	}
	
	@Test
	public void musBeReturnStatus409WhenRequestSaveOrderMundiRecorded() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus409WhenRequestSaveOrderMundiRecorded();
		this.orderService.saveOrUpate(orderMundi);
		String orderMundiJson = this.mapper.writeValueAsString(orderMundi);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions postResult = this.mock
				.perform(post(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = postResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		postResult.andExpect(status().isConflict());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("is already saved");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
	}
	
	@Test
	public void musBeReturnStatus201WhenRequestSaveValidOrderMundi() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus201WhenRequestSaveValidOrderMundi();
		String orderMundiJson = this.mapper.writeValueAsString(orderMundi);
		ResponseApi<OrderMund> response = null;
		String location = null;
		String localtionExpected = "http://localhost" + this.PATH_SAVE_ORDER + "/" + orderMundi.getIdVanrooy();
		
		//Execute operation
		ResultActions postResult = this.mock
				.perform(post(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = postResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		location = postResult.andReturn().getResponse().getHeader("location").toString();
		
		//Execute tests
		postResult.andExpect(status().isCreated());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Order saved");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
		assertEquals(localtionExpected, location);
	}
	
	@Test
	public void musBeReturnStatus417WhenRequestUpdatedInvalidOrderMundi() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus417WhenRequestUpdatedInvalidOrderMundi();
		String orderMundiJson = this.mapper.writeValueAsString(orderMundi);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isExpectationFailed());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("errors");
		assertThat(response.getMessage()).containsIgnoringCase("idVanrooy");
		assertThat(response.getMessage()).containsIgnoringCase("creditCard");
		assertThat(response.getMessage()).containsIgnoringCase("orderDetail");
		assertThat(response.getMessage()).containsIgnoringCase("it's necessary");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestUpdatedOrderMundiNotSaved() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus404WhenRequestUpdatedOrderMundiNotSaved();
		String orderMundiJson = this.mapper.writeValueAsString(orderMundi);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase(orderMundi.getIdVanrooy());
		assertThat(response.getMessage()).containsIgnoringCase("for update not found");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
	}

	@Test
	public void musBeReturnStatus200WhenRequestUpdatedValidAndSavedOrderMundi() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestUpdatedValidAndSavedOrderMundi();
		OrderMund orderMundiManaged = this.orderService.saveOrUpate(orderMundi);
		
		OrderMund orderMundiAlter = this.objectOrder.alterItems(orderMundi);
		String orderMundiJson = this.mapper.writeValueAsString(orderMundiAlter);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_SAVE_ORDER).contentType(MediaType.APPLICATION_JSON)
						.content(orderMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Order updated.");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundiManaged.getIdVanrooy(), response.getData().getIdVanrooy());
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
		assertEquals(orderMundiAlter.getIdVanrooy(), response.getData().getIdVanrooy());
		assertThat(response.getData().getOrderDetail().getItems().get(0).getDescription())
		.isNotEqualToIgnoringCase(orderMundi.getOrderDetail().getItems().get(0).getDescription());
		assertThat(response.getData().getOrderDetail().getItems().get(0).getDescription())
		.isNotEqualToIgnoringCase(orderMundiManaged.getOrderDetail().getItems().get(0).getDescription());
		assertThat(response.getData().getOrderDetail().getItems().get(0).getDescription())
		.isEqualTo(orderMundiAlter.getOrderDetail().getItems().get(0).getDescription());
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestOrderMundiNotSaved() throws Exception {
		//Build scenario
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(this.PATH_SAVE_ORDER + "/" + this.objectOrder.idVanrooyNotFound)
						.contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("OrderMundi not found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().isEmpty()).isTrue();
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestOrderMundiManaged() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestOrderMundiManaged();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<OrderMund> response = null;
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(this.PATH_SAVE_ORDER + "/" + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("OrderMundi found");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
	}
	
	
	
	@Test
	public void musBeReturnStatus404WhenRequestOrderMundiPatternMundPaggNotSaved() throws Exception {
		//Build scenario
		ResponseApi<OrderRequest> response = null;
		String URL = this.PATH_SAVE_ORDER + "/" + this.objectOrder.idVanrooyNotFound + "/mund";
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderRequest>> typeReference = new TypeReference<ResponseApi<OrderRequest>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Order pattern MundiPagg not found");
		assertThat(response.getData()).isNotNull();
	}
	
	@Test
	public void musBeReturnStatus423WhenRequestOrderMundiPatternMundPaggInvalidToCapture() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus423WhenRequestOrderMundiPatternMundPaggInvalidToCapture();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<OrderRequest> response = null;
		String URL = this.PATH_SAVE_ORDER + "/" + orderMundi.getIdVanrooy() + "/mund";
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderRequest>> typeReference = new TypeReference<ResponseApi<OrderRequest>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isLocked());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Order not prepared for capture");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getCode()).isNull();
		assertThat(response.getData().getPayments()).isNull();
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestOrderMundiPatternMundPagg() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestOrderMundiPatternMundPagg();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<OrderRequest> response = null;
		String URL = this.PATH_SAVE_ORDER + "/" + orderMundi.getIdVanrooy() + "/mund";
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderRequest>> typeReference = new TypeReference<ResponseApi<OrderRequest>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getPayments()).isNotEmpty();
		assertEquals(orderMundi.getTokenMund().getToken(), response.getMessage());
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestStartConforenceNotSaved() throws Exception {
		//Build scenario
		ResponseApi<StartConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_START_CONFERENCE + "/" + this.objectOrder.idVanrooyNotFound)
						.contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<StartConference>> typeReference = new TypeReference<ResponseApi<StartConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("not found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsStartConference()).isFalse();
	}
	
	
	@Test
	public void musBeReturnStatus403WhenRequestStartConforenceNotPrepared() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus423WhenRequestStartConforenceNotPrepared();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<StartConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_START_CONFERENCE + "/" + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<StartConference>> typeReference = new TypeReference<ResponseApi<StartConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isForbidden());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("has alreeady benn processed. Conference not started");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsStartConference()).isFalse();
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestStartConforenceSuccess() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestStartConforenceSuccess();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<StartConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_START_CONFERENCE + "/" + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<StartConference>> typeReference = new TypeReference<ResponseApi<StartConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Conference started for Order");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsStartConference()).isTrue();
	}
	
	@Test
	public void musBeReturnStatus403WhenRequestFinishConforenceNotPrepared() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus403WhenRequestFinishConforenceNotPrepared();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<FinishConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_FINISH_CONFERENCE + "/" + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<FinishConference>> typeReference = new TypeReference<ResponseApi<FinishConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isForbidden());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("is not in a conference. Conference not finished");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsFinishConference()).isFalse();
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestFinishConforenceNotSaved() throws Exception {
		//Build scenario
		ResponseApi<FinishConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_FINISH_CONFERENCE + "/" + this.objectOrder.idVanrooyNotFound)
						.contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<FinishConference>> typeReference = new TypeReference<ResponseApi<FinishConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("not found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsFinishConference()).isFalse();
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestFinisheConforenceSuccess() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestFinisheConforenceSuccess();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<FinishConference> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(this.PATH_FINISH_CONFERENCE + "/" + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<FinishConference>> typeReference = new TypeReference<ResponseApi<FinishConference>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Conference finished for Order with idVanrooy");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIsFinishConference()).isTrue();
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestResultByOrderNotFound() throws Exception {
		//Build scenario
		ResponseApi<OrderMund> response = null;
		String URL = this.PATH_RESULT_ORDER + "/" + this.objectOrder.idVanrooyNotFound;
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Result Order not found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIdVanrooy()).isBlank();
		assertThat(response.getData().getOrderStatus().getProcessedGateway()).isFalse();
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestResultByOrder() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestResultToOrder();
		this.orderService.saveOrUpate(orderMundi);
		
		ResponseApi<OrderMund> response = null;
		String URL = this.PATH_RESULT_ORDER + "/" + orderMundi.getIdVanrooy();
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderMund>> typeReference = new TypeReference<ResponseApi<OrderMund>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Result Order found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getIdVanrooy()).isNotBlank();
		assertThat(response.getData().getOrderStatus().getProcessedGateway()).isTrue();
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestSendResultMundiForOrderNotFound() throws Exception {
		//Build scenario  GetOrderResponse
		ResponseApi<OrderResponse> orderResponseMundi= this.objectOrder.musBeReturnStatus404WhenRequestSendResultMundiForOrderNotFound();
		String orderResponseMundiJson = this.mapper.writeValueAsString(orderResponseMundi);
		String URI = this.PATH_SAVE_ORDER + "/" + this.objectOrder.idVanrooyNotFound + "/result";
		ResponseApi<String> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(URI).contentType(MediaType.APPLICATION_JSON)
						.content(orderResponseMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<String>> typeReference = new TypeReference<ResponseApi<String>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase(" for update response not found");
		assertThat(response.getData()).containsIgnoringCase(" for update response not found");
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestSendResultMundi() throws Exception {
		//Build scenario  GetOrderResponse
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestSendResultMundi();
		this.orderService.saveOrUpate(orderMundi);
		String URI = this.PATH_SAVE_ORDER + "/" + orderMundi.getIdVanrooy() + "/result";
		ResponseApi<OrderResponse> orderResponseMundi= this.objectOrder.musBeReturnStatus200WhenRequestSendResultMundiResponseMundi();
		String orderResponseMundiJson = this.mapper.writeValueAsString(orderResponseMundi);
		
		ResponseApi<String> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(put(URI).contentType(MediaType.APPLICATION_JSON)
						.content(orderResponseMundiJson)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<String>> typeReference = new TypeReference<ResponseApi<String>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Success Response recorded for idVanrooy");
		assertThat(response.getData()).containsIgnoringCase("Success Response recorded for idVanrooy");
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestStateByOrderNodFound() throws Exception {
		//Build scenario
		ResponseApi<OrderStatus> response = null;
		String URL = this.PATH_RESULT_STATE + "/" + this.objectOrder.idVanrooyNotFound;
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderStatus>> typeReference = new TypeReference<ResponseApi<OrderStatus>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Status Order not found");
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().getId()).isNull();
		assertEquals(false, response.getData().getProcessedGateway());
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestStateByOrder() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestStateByOrder();
		this.orderService.saveOrUpate(orderMundi);
		
		ResponseApi<OrderStatus> response = null;
		String URL = this.PATH_RESULT_STATE + "/" + orderMundi.getIdVanrooy();
		
		//Execute operation
		ResultActions getResult = this.mock
				.perform(get(URL).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<OrderStatus>> typeReference = new TypeReference<ResponseApi<OrderStatus>>() {};
		String bodyString = getResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		getResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase("Status Order with idVanrooy " + orderMundi.getIdVanrooy() + " found. ");
		assertThat(response.getData()).isNotNull();
		assertEquals(orderMundi.getIdVanrooy(), response.getData().getIdVanrooy());
		assertEquals(false, response.getData().getProcessedGateway());
	}
	
	@Test
	public void musBeReturnStatus404WhenRequestDeleteOrderMundiNotSaved() throws Exception {
		//Build scenario
		ResponseApi<String> response = null;
		String idVanrooy = "ID_NOT_SAVED";
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(delete(this.PATH_DELETE + idVanrooy).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<String>> typeReference = new TypeReference<ResponseApi<String>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isNotFound());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase(idVanrooy);
		assertThat(response.getMessage()).containsIgnoringCase("for delete not found");
	}
	
	@Test
	public void musBeReturnStatus200WhenRequestDeleteOrderMundiSaved() throws Exception {
		//Build scenario
		OrderMund orderMundi = this.objectOrder.musBeReturnStatus200WhenRequestDeleteOrderMundiSaved();
		this.orderService.saveOrUpate(orderMundi);
		ResponseApi<String> response = null;
		
		//Execute operation
		ResultActions putResult = this.mock
				.perform(delete(this.PATH_DELETE + orderMundi.getIdVanrooy()).contentType(MediaType.APPLICATION_JSON)
						.header(this.properties.getKey(), this.properties.getToken()));
		TypeReference<ResponseApi<String>> typeReference = new TypeReference<ResponseApi<String>>() {};
		String bodyString = putResult.andReturn().getResponse().getContentAsString();
		response = this.mapper.readValue(bodyString, typeReference);
		
		//Execute tests
		putResult.andExpect(status().isOk());
		assertThat(response).isNotNull();
		assertThat(response.getMessage()).containsIgnoringCase(orderMundi.getIdVanrooy());
		assertThat(response.getMessage()).containsIgnoringCase("success deleted");
	}
	
}