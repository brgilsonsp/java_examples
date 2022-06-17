package br.com.d2st.exportacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.d2st.exportacao.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
