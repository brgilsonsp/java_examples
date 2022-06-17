package br.com.gilson.integration.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import br.com.gilson.integration.entity.OrderMund;
import br.com.gilson.integration.repository.OrderMundiRepository;
import br.com.gilson.integration.services.OrderMundiService;

@Service
public class OrderMundiServiceImpl implements OrderMundiService {

	@Autowired
	private OrderMundiRepository repository;

	@Override
	public OrderMund saveOrUpate(OrderMund orderMundi) {
		return this.repository.save(orderMundi);
	}

	@Override
	public OrderMund findById(Long id) {
		try {
			Optional<OrderMund> optional = this.repository.findById(id);
			return optional.isPresent() ? optional.get() : new OrderMund();
		} catch (InvalidDataAccessApiUsageException e) {
			return new OrderMund();
		}
	}

	@Override
	public OrderMund findByIdVanrooy(String idVanrooy) {
		Optional<OrderMund> optional = this.repository.findByIdVanrooy(idVanrooy);
		return optional.isPresent() ? optional.get() : new OrderMund();
	}

	@Override
	public void delete(OrderMund orderMund) {
		this.repository.delete(orderMund);
		
	}
}