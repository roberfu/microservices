package cl.springmachine.microservices.currency.exchange.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "currency_exchange")
public class CurrencyExchangeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "_from")
	private String from;
	
	@Column(name = "_to")
	private String to;
	
	private BigDecimal multiple;
	
	private String env;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getMultiple() {
		return multiple;
	}

	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public CurrencyExchangeEntity(Integer id, String from, String to, BigDecimal multiple, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multiple = multiple;
		this.env = env;
	}

	@Override
	public String toString() {
		return "CurrencyExchangeEntity [id=" + id + ", from=" + from + ", to=" + to + ", multiple=" + multiple + ", env="
				+ env + "]";
	}

	public CurrencyExchangeEntity() {
		super();
	}
	
	
	
	

}
