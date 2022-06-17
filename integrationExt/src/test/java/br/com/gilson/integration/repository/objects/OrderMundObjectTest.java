package br.com.gilson.integration.repository.objects;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gilson.integration.entity.ItemMund;
import br.com.gilson.integration.entity.OrderDetailMund;
import br.com.gilson.integration.entity.OrderMund;
import br.com.gilson.integration.entity.ResponseApi;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderResponse;

@Component
@Configuration
public class OrderMundObjectTest {

	public final String idVanrooyNotFound = "2536NOT_FOUND_serfosd";

	@Autowired
	private ObjectMapper mapper;

	public String getFileContents(String fileName) throws IOException {
		String result = "";

		ClassLoader classLoader = getClass().getClassLoader();
		byte[] buffer = new byte[1024];
		int length;
		InputStream fileStream = classLoader.getResourceAsStream(fileName);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		while ((length = fileStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, length);
		}
		result = outputStream.toString(StandardCharsets.UTF_8.name());

		return result;
	}

	public OrderMund mustBeReturnObjectManagedWhenSaveOrUpdateValidOrderMundi() throws Exception {
		String string = this.getFileContents("mock/order_complet_2re339_sdsdere.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund mustBeReturnObjectManagedWhenFoundRecordByIdVanrooy() throws Exception {
		String string = this.getFileContents("mock/order_complet_875s87r_sdsdere.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund mustBeReturnObjectManagedWhenFoundRecordById() throws Exception {
		String string = this.getFileContents("mock/order_complet_87124gfrtg.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund mustBeDeleteObjectManaged() throws IOException {
		String string = this.getFileContents("mock/order_complet_02136545869dd85.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus417WhenRequestSaveInvalidOrderMundi() throws Exception {
		String string = this.getFileContents("mock/order_invalid_211426sse_dse.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus409WhenRequestSaveOrderMundiRecorded() throws Exception {
		String string = this.getFileContents("mock/order_complet_23458$858ndjsu322.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus201WhenRequestSaveValidOrderMundi() throws Exception {
		String string = this.getFileContents("mock/order_complet_8758$rrfdee9658dd.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus417WhenRequestUpdatedInvalidOrderMundi() throws Exception {
		String string = this.getFileContents("mock/order_invalid_null.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus404WhenRequestUpdatedOrderMundiNotSaved() throws Exception {
		String string = this.getFileContents("mock/order_complet_875442sdergg$85832sdsderer.json");
		return this.mapper.readValue(string, OrderMund.class);

	}

	public OrderMund musBeReturnStatus200WhenRequestUpdatedValidAndSavedOrderMundi() throws Exception {
		String string = this.getFileContents("mock/order_complet_sr547u889985$8583ds3rsderer.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund alterItems(OrderMund orderMundi) {
		int amount = 28569;
		String description = "New Item";
		int quantity = 1;
		ItemMund item = new ItemMund(amount, description, quantity);
		List<ItemMund> items = new ArrayList<>();
		items.add(item);
		OrderDetailMund orderDetail = new OrderDetailMund(orderMundi.getOrderDetail().getCustomer(), items,
				orderMundi.getOrderDetail().getCurrency());

		return new OrderMund(orderMundi.getIdVanrooy(), orderDetail, orderMundi.getPayments(),
				orderMundi.getTokenMund());
	}

	public OrderMund musBeReturnStatus200WhenRequestOrderMundiManaged() throws Exception {
		String string = this.getFileContents("mock/order_complet_8f45g62e55sdld8e7fdrer.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus423WhenRequestOrderMundiPatternMundPaggInvalidToCapture() throws Exception {
		String string = this.getFileContents("mock/order_complet_757dg5g8ret54tdidkfk7he&63ssderer.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus200WhenRequestOrderMundiPatternMundPagg() throws Exception {
		String string = this.getFileContents("mock/order_complet_745fgrtbh99d8$85200startderer.json");
		OrderMund orderMundi = this.mapper.readValue(string, OrderMund.class);
		orderMundi.uraStarterConference();

		return orderMundi;
	}

	public OrderMund musBeReturnStatus423WhenRequestStartConforenceNotPrepared() throws Exception {
		String string = this.getFileContents("mock/order_complet_754f78965ddstartedr8fdesderer.json");
		OrderMund orderMundi = this.mapper.readValue(string, OrderMund.class);
		orderMundi.uraStarterConference();
		return orderMundi;
	}

	public OrderMund musBeReturnStatus200WhenRequestStartConforenceSuccess() throws Exception {
		String string = this.getFileContents("mock/order_complet_754fght8f5d99r8frdv35erer.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus403WhenRequestFinishConforenceNotPrepared() throws Exception {
		String string = this.getFileContents("mock/order_complet_125365f69gd58.json");
		return this.mapper.readValue(string, OrderMund.class);
	}

	public OrderMund musBeReturnStatus200WhenRequestFinisheConforenceSuccess() throws Exception {
		String string = this.getFileContents("mock/order_complet_754fght8fsdfsdfww3gderer.json");
		OrderMund orderMundi = this.mapper.readValue(string, OrderMund.class);
		orderMundi.uraStarterConference();
		return orderMundi;
	}

	public OrderMund musBeReturnStatus200WhenRequestResultToOrder() throws Exception {

		String string = this.getFileContents("mock/order_complet_56d5d655f85.json");
		OrderMund orderMundi = this.mapper.readValue(string, OrderMund.class);

		return orderMundi;
	}

	public ResponseApi<OrderResponse> musBeReturnStatus404WhenRequestSendResultMundiForOrderNotFound()
			throws Exception {
		String string = this.getFileContents("mock/order_response_valid_2019000598885s98dd9.json");
		TypeReference<ResponseApi<OrderResponse>> typeRef = new TypeReference<ResponseApi<OrderResponse>>() {
		};
		ResponseApi<OrderResponse> responseApi = this.mapper.readValue(string, typeRef);
		return responseApi;
	}

	public OrderMund musBeReturnStatus200WhenRequestSendResultMundi() throws Exception {
		String string = this.getFileContents("mock/order_complet_56589695ssf6g.json");
		OrderMund orderMundi = this.mapper.readValue(string, OrderMund.class);

		return orderMundi;
	}

	public ResponseApi<OrderResponse> musBeReturnStatus200WhenRequestSendResultMundiResponseMundi() throws Exception {
		String string = this.getFileContents("mock/order_response_valid_56589695ssf6g.json");
		TypeReference<ResponseApi<OrderResponse>> typeRef = new TypeReference<ResponseApi<OrderResponse>>() {
		};
		ResponseApi<OrderResponse> responseApi = this.mapper.readValue(string, typeRef);
		return responseApi;
	}

	public OrderMund musBeReturnStatus200WhenRequestStateByOrder() throws Exception {
		String string = this.getFileContents("mock/order_complet_757dg5g8ret54tdfr23edssderer.json");
		return this.mapper.readValue(string, OrderMund.class);

	}

	public OrderMund musBeReturnStatus200WhenRequestDeleteOrderMundiSaved() throws IOException {
		String string = this.getFileContents("mock/order_complet_056958dd869dd85.json");
		return this.mapper.readValue(string, OrderMund.class);
	}


}
