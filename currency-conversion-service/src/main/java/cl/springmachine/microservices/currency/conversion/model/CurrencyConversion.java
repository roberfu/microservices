package cl.springmachine.microservices.currency.conversion.model;

import java.math.BigDecimal;

public record CurrencyConversion(Integer id, String from, String to, Integer quantity, BigDecimal multiple, BigDecimal total, String env) {

}
