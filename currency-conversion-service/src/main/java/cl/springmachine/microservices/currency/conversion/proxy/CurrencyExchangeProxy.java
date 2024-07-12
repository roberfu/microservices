package cl.springmachine.microservices.currency.conversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.springmachine.microservices.currency.conversion.model.CurrencyConversion;

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getConversionTotal(@PathVariable String from, @PathVariable String to);

}
