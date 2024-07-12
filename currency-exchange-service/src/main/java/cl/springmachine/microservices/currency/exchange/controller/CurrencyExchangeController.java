package cl.springmachine.microservices.currency.exchange.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.microservices.currency.exchange.model.CurrencyExchangeEntity;
import cl.springmachine.microservices.currency.exchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	private Environment environment;
	
	private CurrencyExchangeRepository repository;

	public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
		this.environment = environment;
		this.repository = repository;
	}

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeEntity getExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		logger.info("request conversion from {} to {}", from, to);
		
		Optional<CurrencyExchangeEntity> optional = repository.findByFromAndTo(from, to);
		
		if (optional.isEmpty()) return null;
		
		CurrencyExchangeEntity entity = optional.get();
		entity.setEnv(environment.getProperty("local.server.port"));
		
		return entity;
	}

}
