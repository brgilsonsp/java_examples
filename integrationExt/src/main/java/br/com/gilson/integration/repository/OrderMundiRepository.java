package br.com.gilson.integration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gilson.integration.entity.OrderMund;

public interface OrderMundiRepository extends JpaRepository<OrderMund, Long> {

	Optional<OrderMund> findByIdVanrooy(String idVanrooy);
}