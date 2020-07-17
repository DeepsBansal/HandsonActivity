package com.ibm.ConvertCurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertCurrencyController {

	@GetMapping("/converted-amount")
	public long getconvertedAmount(@RequestParam("fromCountryCode") String fromCountryCode , @RequestParam("toCountryCode") String toCountryCode,
			@RequestParam("amountobeconverted") Long amountobeconverted) {
		System.out.println("------Inside getconvertedAmount");
		Long newamount=(long)0;
		if(fromCountryCode.equalsIgnoreCase("INR") ) {
			if(toCountryCode.equalsIgnoreCase("USD")) 
				newamount= (long) (amountobeconverted/75.68);
			else if(toCountryCode.equalsIgnoreCase("EUR")) 
				newamount= (long) (amountobeconverted/83.06);
			else if(toCountryCode.equalsIgnoreCase("POND")) 
				newamount= (long) (amountobeconverted/93.22);
			else if(toCountryCode.equalsIgnoreCase("YEN")) 
				newamount= (long) (amountobeconverted/1.42);
					
		}else if(fromCountryCode.equalsIgnoreCase("USD")) {
		
			if(toCountryCode.equalsIgnoreCase("INR")) 
				newamount= (long) (amountobeconverted*75.68);
			if(toCountryCode.equalsIgnoreCase("EUR")) 
				newamount= (long) (amountobeconverted*1.10);
			if(toCountryCode.equalsIgnoreCase("POND")) 
				newamount= (long) (amountobeconverted*1.23);
			if(toCountryCode.equalsIgnoreCase("YEN")) 
				newamount= (long) (amountobeconverted*107.43);
			
		}
		return newamount;
	}	
}
