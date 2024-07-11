package cl.springmachine.microservices.currency.exchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springmachine.microservices.currency.exchange.model.CurrencyExchangeEntity;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Integer>{

	Optional<CurrencyExchangeEntity> findByFromAndTo(String from, String to);

}
