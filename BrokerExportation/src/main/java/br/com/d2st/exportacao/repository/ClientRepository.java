package br.com.d2st.exportacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.d2st.exportacao.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
