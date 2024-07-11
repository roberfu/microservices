package cl.springmachine.microservices.limits.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.microservices.limits.configuration.Configuration;
import cl.springmachine.microservices.limits.model.LimitRecord;

@RestController
public class LimitsController {
	
	private final Configuration config;
	
	public LimitsController(Configuration config) {
		this.config = config;
	}
	
	@GetMapping("/limits")
	public LimitRecord getLimit() {
		return new LimitRecord(config.getMin(), config.getMax());
	}

}
