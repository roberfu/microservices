package cl.springmachine.microservices.currency.exchange.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/api")
	@Retry(name = "api", fallbackMethod = "errorResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "errorResponse")
	@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public Map<String, String> get() {
		logger.info("try");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("localhost", String.class);
		Map<String, String> response = new HashMap<>();
		response.put("message", responseEntity.getBody());
		return response;
	}
	
	public Map<String, String> errorResponse(Exception ex) {
		logger.info("fallback");
		Map<String, String> response = new HashMap<>();
		response.put("message", "now its all good: " + ex.getMessage());
		return response;
	}

}
