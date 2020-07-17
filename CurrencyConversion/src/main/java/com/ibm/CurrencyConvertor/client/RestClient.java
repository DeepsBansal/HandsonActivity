package com.ibm.CurrencyConvertor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("Convert-Currency-Service")
public interface RestClient {

	@GetMapping("/converted-amount")
	public long getconvertedAmount(@RequestParam("fromCountryCode") String fromCountryCode , 
			@RequestParam("toCountryCode") String toCountryCode,
			@RequestParam("amountobeconverted") Long amountobeconverted
			);
}
