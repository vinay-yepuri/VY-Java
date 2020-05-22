/**
 * 
 */
package com.vinay.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author VINAY
 *
 */
@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
				;
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean responseBody = responseEntity.getBody();
		
		return new CurrencyConversionBean(responseBody.getId(),from,to,responseBody.getConversionMultiple(),quantity,
				quantity.multiply(responseBody.getConversionMultiple()),responseBody.getPort());
	}
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		/*
		 * Map<String, String> uriVariables = new HashMap<String, String>();
		 * uriVariables.put("from", from); uriVariables.put("to", to); ;
		 * ResponseEntity<CurrencyConversionBean> responseEntity = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
		 * CurrencyConversionBean.class, uriVariables); CurrencyConversionBean
		 * responseBody = responseEntity.getBody();
		 */
		
		CurrencyConversionBean responseBody = proxy.retrieveExchangeValue(from, to);
		
		logger.info("{}",responseBody);
		
		return new CurrencyConversionBean(responseBody.getId(),from,to,responseBody.getConversionMultiple(),quantity,
				quantity.multiply(responseBody.getConversionMultiple()),responseBody.getPort());
	}

}
