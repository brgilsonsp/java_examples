package br.com.d2st.exportacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.d2st.exportacao.model.MessageKind;
import br.com.d2st.exportacao.model.MessageNumber;
import br.com.d2st.exportacao.model.RequestEdx;

public interface RequestEdxRepository extends CrudRepository<RequestEdx, Long> {
	
	RequestEdx findByMessageNumberAndMessageKindAllIgnoreCase(MessageNumber messageNumber, MessageKind messageKind);

}
