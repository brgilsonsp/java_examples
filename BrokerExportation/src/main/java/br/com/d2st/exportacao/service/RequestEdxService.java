package br.com.d2st.exportacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.d2st.exportacao.model.MessageKind;
import br.com.d2st.exportacao.model.MessageNumber;
import br.com.d2st.exportacao.model.RequestEdx;
import br.com.d2st.exportacao.repository.RequestEdxRepository;

@Service
public class RequestEdxService {

	private RequestEdxRepository repository;

	@Autowired
	public RequestEdxService(RequestEdxRepository repository) {
		this.repository = repository;
	}
	
	public RequestEdx saveRequest(RequestEdx requestEdx) {
		return repository.save(requestEdx);
	}
	
	public void deleteRequest(RequestEdx requestEdx) {
		repository.delete(requestEdx);
	}
	
	public RequestEdx getRequestEdxById(Long idRequestEdx) {
		return repository.findOne(idRequestEdx);
	}
	
	public RequestEdx getRequestEdx(MessageNumber messageNumber, MessageKind messageKind) {
		return repository.findByMessageNumberAndMessageKindAllIgnoreCase(messageNumber, messageKind);
	}
	
	public List<RequestEdx> getListRquestEdx() {
		return (List<RequestEdx>) repository.findAll();
	}
	
	
}
