package br.com.gilson.integration.services;

import org.springframework.stereotype.Component;

import br.com.gilson.integration.entity.OrderMund;

@Component
public interface OrderMundiService {
	
	/**
	 * Save or Update the record sent in the parameter and return the record managed
	 * @param orderMundi Object OrderMundi, not null
	 * @return the record managed
	 */
	OrderMund saveOrUpate(OrderMund orderMundi);
	
	/**
	 * Find record by id, if not found, return the new object OrderMundi transient
	 * @param id Long with value of the id
	 * @return If found the record, return the managed object, if not found, return the new object OrderMundi transient
	 * without value
	 */
	OrderMund findById(Long id);
	
	/**
	 * Find record by idVanrooy, if not found, return the new object OrderMundi transient
	 * @param id String with value of the idVanrooy
	 * @return If found the record, return the managed object, if not found, return the new object OrderMundi transient
	 * without value
	 */
	OrderMund findByIdVanrooy(String idVanrooy);
	
	void delete(OrderMund orderMund);

}