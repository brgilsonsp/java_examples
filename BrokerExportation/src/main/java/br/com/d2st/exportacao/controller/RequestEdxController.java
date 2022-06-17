package br.com.d2st.exportacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.d2st.exportacao.model.RequestEdx;
import br.com.d2st.exportacao.service.RequestEdxService;

@RestController
@RequestMapping("/admin/config/request")
public class RequestEdxController {

	private RequestEdxService requestService;

	@Autowired
	public RequestEdxController(RequestEdxService requestService) {
		this.requestService = requestService;
	}

	public ResponseEntity<RequestEdx> save(RequestEdx requestEdx) {

		try {
			RequestEdx requestSave = requestService.saveRequest(requestEdx);
			return ResponseEntity.ok(requestSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
