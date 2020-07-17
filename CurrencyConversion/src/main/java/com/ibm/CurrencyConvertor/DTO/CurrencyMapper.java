package com.ibm.CurrencyConvertor.DTO;

import com.ibm.CurrencyConvertor.domain.Currency;

public class CurrencyMapper {

public CurrencyDTO convertCurrencyToCurrencyDTO(Currency currency) {
		
	CurrencyDTO currencyDTO=new CurrencyDTO();
		currencyDTO.setId(currency.getId());
		currencyDTO.setFromCountryCode(currency.getFromcountry());
		currencyDTO.setToCountryCode(currency.getTocountry());
		currencyDTO.setConversionFactor(currency.getConversionfactor());
		return currencyDTO;
	}
	
	public Currency convertCurrencyDTOToCurrency(CurrencyRequestDTO currencyDTO) {
		
		Currency currency=new Currency();
		currency.setFromcountry(currencyDTO.getFromCountryCode());
		currency.setTocountry(currencyDTO.getToCountryCode());
		currency.setConversionfactor(currencyDTO.getConversionFactor());
		return currency;
	}
	
	public Currency updateCurrencyDTOToCurrency(CurrencyRequestDTO currencyDTO,long id) {
		
		Currency currency=new Currency();
		currency.setFromcountry(currencyDTO.getFromCountryCode());
		currency.setTocountry(currencyDTO.getToCountryCode());
		currency.setConversionfactor(currencyDTO.getConversionFactor());
		currency.setId(id);
		return currency;
	}
public Currency convertCurrencyDTOToCurrencyFallBack(CurrencyRequestDTO currencyDTO) {
		
		Currency currency=new Currency();
		//currency.setId(currencyDTO.getId());
		System.out.println("---------------------Inside Fall Back Method----Hystrix Circut breaker");
		currency.setFromcountry(currencyDTO.getFromCountryCode());
		currency.setTocountry(currencyDTO.getToCountryCode());
		currency.setConversionfactor((long) 0);//Hard Code Conversion Factor Value
		currency.setConvertedAmount((long)0); //Hard Converted Amount Value
		return currency;
	}
			
}
