package br.com.gilson.integration.controller;

import java.net.URI;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import br.com.gilson.integration.entity.FinishConference;
import br.com.gilson.integration.entity.OrderMund;
import br.com.gilson.integration.entity.OrderMundResponse;
import br.com.gilson.integration.entity.OrderStatus;
import br.com.gilson.integration.entity.ResponseApi;
import br.com.gilson.integration.entity.StartConference;
import br.com.gilson.integration.services.OrderMundiService;
import br.com.gilson.integration.utils.BuildErrorsValidator;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderResponse;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

	private final Logger logger = LogManager.getLogger(TransactionController.class);

	@Autowired
	private OrderMundiService orderService;

	@Autowired
	private BuildErrorsValidator buildErrorsValidator;

	@PostMapping("/order")
	public ResponseEntity<ResponseApi<OrderMund>> createOrder(@Valid @RequestBody OrderMund order,
			BindingResult result) {
		logger.info("Start createOrder");

		ResponseApi<OrderMund> response;
		OrderMund orderApiReturn;
		HttpStatus statusHttp;
		String messageReturn;

		try {
			if (result.hasErrors() || order.hasErrorNotNoted()) {
				messageReturn = this.buildErrorsValidator.buildMessageValidation(result.getAllErrors(), order)
						.toString();
				statusHttp = HttpStatus.EXPECTATION_FAILED;
				orderApiReturn = order;
			} else {
				OrderMund orderPersisted = this.orderService.saveOrUpate(order);
				orderApiReturn = orderPersisted;
				statusHttp = HttpStatus.CREATED;
				messageReturn = "Order saved. Waiting URA send data...";
			}
		} catch (DataIntegrityViolationException dE) {
			statusHttp = HttpStatus.CONFLICT;
			messageReturn = "Order with idVanrooy " + order.getIdVanrooy() + " is already saved. Order not saved";
			orderApiReturn = order;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			messageReturn = "Order not saved, fatal error";
			orderApiReturn = order;
			logger.error(messageReturn, e);
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderApiReturn);

		logger.info("Finish createOrder. Status: " + statusHttp + ", Message: " + messageReturn);

		if (statusHttp == HttpStatus.CREATED) {
			URI uriHeader = this.buildUriHeader(orderApiReturn.getIdVanrooy());
			return ResponseEntity.created(uriHeader).body(response);
		} else {
			return ResponseEntity.status(statusHttp).body(response);
		}
	}

	@PutMapping("/order")
	public ResponseEntity<ResponseApi<OrderMund>> updateOrder(@Valid @RequestBody OrderMund order,
			BindingResult result) {
		logger.info("Start updateOrder");

		ResponseApi<OrderMund> response;
		OrderMund orderApiReturn;
		HttpStatus statusHttp;
		String messageReturn;

		try {
			if (result.hasErrors() || order.hasErrorNotNoted()) {
				statusHttp = HttpStatus.EXPECTATION_FAILED;
				messageReturn = this.buildErrorsValidator.buildMessageValidation(result.getAllErrors(), order)
						.toString();
				orderApiReturn = order;
			} else {
				OrderMund orderApiPersisted = this.orderService.findByIdVanrooy(order.getIdVanrooy());
				if (orderApiPersisted.isEmpty()) {
					statusHttp = HttpStatus.NOT_FOUND;
					messageReturn = "Order with idVanrooy " + order.getIdVanrooy() + " for update not found";
					orderApiReturn = order;
				} else {
					orderApiPersisted.updateOrderMundi(order);
					orderApiReturn = this.orderService.saveOrUpate(orderApiPersisted);
					statusHttp = HttpStatus.OK;
					messageReturn = "Order updated. Waiting URA send data...";
				}
			}

		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			messageReturn = "Order not updated, fatal error";
			orderApiReturn = order;
			logger.error(messageReturn, e);
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderApiReturn);

		logger.info("Finish updateOrder. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}

	@GetMapping("/order/{idVanrooy}")
	public ResponseEntity<ResponseApi<OrderMund>> getOrderByIdVanrooy(@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start getOrderByIdVanrooy");

		ResponseApi<OrderMund> response = new ResponseApi<>();
		OrderMund orderApiReturn = new OrderMund();
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderApi = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderApi.isEmpty()) {
				messageReturn = "OrderMundi not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				orderApiReturn = orderApi;
				messageReturn = "OrderMundi found";
				statusHttp = HttpStatus.OK;
			}
		} catch (Exception e) {
			messageReturn = "Fatal error. Could not get order";
			logger.error(messageReturn, e);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderApiReturn);
		logger.info("Finish getOrderByIdVanrooy. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}

	@GetMapping("/order/{idVanrooy}/mund")
	public ResponseEntity<ResponseApi<OrderRequest>> getOrderPatterMundiByIdVanrooy(
			@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start getOrderPatterMundiByIdVanrooy");

		ResponseApi<OrderRequest> response = new ResponseApi<>();
		OrderRequest orderApiPatterMund = new OrderRequest();
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderApi = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderApi.isEmpty()) {
				messageReturn = "Order pattern MundiPagg not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				if (orderApi.isValidToProcessTransactionInGateway()) {
					orderApiPatterMund = orderApi.buildOrderPatterMund();
					messageReturn = orderApi.getTokenMund().getToken();
					statusHttp = HttpStatus.OK;
				} else {
					messageReturn = "Order not prepared for capture";
					statusHttp = HttpStatus.LOCKED;
				}
			}
		} catch (Exception e) {
			messageReturn = "Fatal error. Could not get Order pattern MundiPagg";
			logger.error(messageReturn, e);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderApiPatterMund);
		logger.info("Finish getOrderPatterMundiByIdVanrooy. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}

	@PutMapping("/startConference/{idVanrooy}")
	public ResponseEntity<ResponseApi<StartConference>> startConference(@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start startConference");

		ResponseApi<StartConference> response = new ResponseApi<>();
		StartConference startConference = new StartConference(false);
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderApiPersisted = this.orderService.findByIdVanrooy(idVanrooy);

			if (orderApiPersisted.isEmpty()) {
				messageReturn = "Order with idVanrooy " + idVanrooy + " not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				if (orderApiPersisted.isValidForStartConference()) {
					orderApiPersisted.uraStarterConference();
					this.orderService.saveOrUpate(orderApiPersisted);
					startConference = new StartConference(true);
					statusHttp = HttpStatus.OK;
					messageReturn = "Conference started for Order with idVanrooy " + idVanrooy;
				} else {
					messageReturn = "Order with idVanrooy " + idVanrooy
							+ " has alreeady benn processed. Conference not started";
					statusHttp = HttpStatus.FORBIDDEN;
				}
			}

		} catch (Exception ex) {
			messageReturn = "Error while started conference in order with idVanrooy " + idVanrooy;
			logger.error(messageReturn, ex);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(startConference);
		logger.info("Finish startConference. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);

	}

	@PutMapping("/finishConference/{idVanrooy}")
	public ResponseEntity<ResponseApi<FinishConference>> finishConference(@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start finishConference");

		ResponseApi<FinishConference> response = new ResponseApi<>();
		FinishConference finishConference = new FinishConference(false);
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderApiPersisted = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderApiPersisted.isEmpty()) {
				messageReturn = "Order with idVanrooy " + idVanrooy + " not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				if (orderApiPersisted.isValidForFinishConference()) {
					orderApiPersisted.uraFinishedConference();
					this.orderService.saveOrUpate(orderApiPersisted);
					finishConference = new FinishConference(true);
					statusHttp = HttpStatus.OK;
					messageReturn = "Conference finished for Order with idVanrooy " + idVanrooy;
				} else {
					messageReturn = "Order with idVanrooy " + idVanrooy
							+ " is not in a conference. Conference not finished";
					statusHttp = HttpStatus.FORBIDDEN;
				}
			}

		} catch (Exception ex) {
			messageReturn = "Error while started conference in order with idVanrooy " + idVanrooy;
			logger.error(messageReturn, ex);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(finishConference);
		logger.info("Finish finishConference. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}
	
	@GetMapping("/result/{idVanrooy}")
	public ResponseEntity<ResponseApi<OrderMundResponse>> getResultOrder(@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start getResultOrder");

		ResponseApi<OrderMundResponse> response = new ResponseApi<>();
		OrderMundResponse orderMundResponse = new OrderMundResponse();
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderApi = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderApi.isEmpty()) {
				messageReturn = "Result Order not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				orderMundResponse = orderApi.getOrderMundResponse();
				messageReturn = "Result Order found";
				statusHttp = HttpStatus.OK;
			}
		} catch (Exception e) {
			messageReturn = "Fatal error. Could not get result order";
			logger.error(messageReturn, e);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderMundResponse);
		logger.info("Finish getResultOrder. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}
	
	@PutMapping("/order/{idVanrooy}/result")
	public ResponseEntity<ResponseApi<String>> updateResultOrder(@PathVariable("idVanrooy") String idVanrooy,
			@RequestBody ResponseApi<OrderResponse> responseMundi, BindingResult result) {
		logger.info("Start updateResultOrder");

		ResponseApi<String> response;
		HttpStatus statusHttp;
		String messageReturn;

		try {
			OrderMund orderApiPersisted = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderApiPersisted.isEmpty()) {
				statusHttp = HttpStatus.NOT_FOUND;
				messageReturn = "Order with idVanrooy " + idVanrooy + " for update response not found";
			} else {
				orderApiPersisted.buildResponseMundi(responseMundi);
				this.orderService.saveOrUpate(orderApiPersisted);
				statusHttp = HttpStatus.OK;
				messageReturn = "Success Response recorded for idVanrooy " + idVanrooy;
			}

		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			messageReturn = "Order not updated, fatal error";
			logger.error(messageReturn, e);
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(messageReturn);

		logger.info("Finish updateResultOrder. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}

	@GetMapping("/state/{idVanrooy}")
	public ResponseEntity<ResponseApi<OrderStatus>> getStateOrder(@PathVariable("idVanrooy") String idVanrooy) {
		logger.info("Start getStateOrder");

		ResponseApi<OrderStatus> response = new ResponseApi<>();
		OrderStatus orderStatus = new OrderStatus();
		HttpStatus statusHttp;
		String messageReturn = "";

		try {
			OrderMund orderMundi = this.orderService.findByIdVanrooy(idVanrooy);
			if (orderMundi.isEmpty()) {
				messageReturn = "Status Order not found";
				statusHttp = HttpStatus.NOT_FOUND;
			} else {
				orderStatus = orderMundi.getOrderStatus();
				messageReturn = "Status Order with idVanrooy " + idVanrooy + " found. ";
				statusHttp = HttpStatus.OK;
			}
		} catch (Exception e) {
			messageReturn = "Fatal error. Could not get state order";
			logger.error(messageReturn, e);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(orderStatus);
		logger.info("Finish getStateOrder. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}
	
	@DeleteMapping("/order/delete/inter/{idVanrooy}")
	public ResponseEntity<ResponseApi<String>> deleteOrderByIdVanrroy(@PathVariable("idVanrooy") String idVanrooy){
		logger.info("Start deleteOrderByIdVanrroy");
		ResponseApi<String> response = new ResponseApi<>();
		HttpStatus statusHttp;
		String messageReturn = "";
		
		try {
			OrderMund orderMund = this.orderService.findByIdVanrooy(idVanrooy);
			if(orderMund.getIdVanrooy() == null || orderMund.getIdVanrooy().isEmpty()) {
				statusHttp = HttpStatus.NOT_FOUND;
				messageReturn = "Order with idVanrooy " + idVanrooy + " for delete not found.";
			}else {
				this.orderService.delete(orderMund);
				statusHttp = HttpStatus.OK;
				messageReturn = "Order with idVanrooy " + idVanrooy + " success deleted.";
			}
			
		}catch(Exception e) {
			messageReturn = "Fatal error. Could not delete order";
			logger.error(messageReturn, e);
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseApi<>();
		response.setMessage(messageReturn);
		response.setData(messageReturn);
		logger.info("Finish deleteOrderByIdVanrroy. Status: " + statusHttp + ", Message: " + messageReturn);
		return ResponseEntity.status(statusHttp).body(response);
	}
	
	private URI buildUriHeader(String idVanrroyPersisted) {

		return MvcUriComponentsBuilder
				.fromMethodName(TransactionController.class, "getOrderByIdVanrooy", idVanrroyPersisted)
				.buildAndExpand(idVanrroyPersisted).toUri();
	}

}
