package cl.springmachine.microservices.currency.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.microservices.currency.conversion.model.CurrencyConversion;
import cl.springmachine.microservices.currency.conversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	private final RestTemplate restTemplate;
	
	private final CurrencyExchangeProxy proxy;
	
	public CurrencyConversionController(CurrencyExchangeProxy proxy, RestTemplate restTemplate) {
		this.proxy = proxy;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getConversionTotal(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {

		Map<String, String> uriVariables = new HashMap<>();

		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		if (currencyConversion == null) return null;

		return new CurrencyConversion(currencyConversion.id(), from, to, quantity, currencyConversion.multiple(),
				currencyConversion.multiple().multiply(BigDecimal.valueOf(quantity)), currencyConversion.env()+ " rest template");
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getConversionTotalFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {

		CurrencyConversion currencyConversion = proxy.getConversionTotal(from, to);
		
		if (currencyConversion == null) return null;

		return new CurrencyConversion(currencyConversion.id(), from, to, quantity, currencyConversion.multiple(),
				currencyConversion.multiple().multiply(BigDecimal.valueOf(quantity)), currencyConversion.env() + " feign");
	}

}
