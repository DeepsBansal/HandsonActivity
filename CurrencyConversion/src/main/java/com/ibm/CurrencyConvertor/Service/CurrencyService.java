/**
 * 
 */
package com.ibm.CurrencyConvertor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.CurrencyConvertor.DTO.CurrencyDTO;
import com.ibm.CurrencyConvertor.DTO.CurrencyMapper;
import com.ibm.CurrencyConvertor.DTO.CurrencyRequestDTO;
import com.ibm.CurrencyConvertor.client.RestClient;
import com.ibm.CurrencyConvertor.domain.Currency;
import com.ibm.CurrencyConvertor.repository.CurrencyRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Optional;


/**
 * @author Deepika Bansal
 * Currency MicroService
 *
 */
@Service
public class CurrencyService {

	final RestClient restClient;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	public CurrencyService(RestClient restClient) {
		this.restClient=restClient;
	}
	
	@HystrixCommand(fallbackMethod="addConversionFactorFallback")
	public CurrencyDTO addConversionFactor(CurrencyRequestDTO currencyDto) {
		CurrencyMapper mapper=new CurrencyMapper();
		Currency currency= mapper.convertCurrencyDTOToCurrency(currencyDto);
		System.out.println("---------------Start get converted amount");
 Long convertedAmount = restClient.getconvertedAmount(currencyDto.getFromCountryCode(),currencyDto.getToCountryCode(),currencyDto.getAmountobeconverted());
 System.out.println("-------------------end   get converted amount");
		currency.setConvertedAmount(convertedAmount);
		Currency currency1= currencyRepository.save(currency);
		       return mapper.convertCurrencyToCurrencyDTO(currency1);
		
	}

	// This method will be called in case Conversion-Service circuit breaks
	public CurrencyDTO addConversionFactorFallback(CurrencyRequestDTO currencyDto) {
		CurrencyMapper mapper=new CurrencyMapper();
		Currency currency= mapper.convertCurrencyDTOToCurrencyFallBack(currencyDto);
		
		Currency currency1= currencyRepository.save(currency);
		       return mapper.convertCurrencyToCurrencyDTO(currency1);
		
	}
	

	public CurrencyDTO updateConversionFactor(Long id, CurrencyRequestDTO currencyDTO) {
		CurrencyMapper mapper=new CurrencyMapper();
		Optional<Currency> currency = currencyRepository.findById(id);
		
		if(currency.isPresent()) {
			Currency currency1 = new Currency();
			currency1.setId(currency.get().getId());
			currency1 = mapper.updateCurrencyDTOToCurrency(currencyDTO,currency.get().getId());
			//Update Currency
			Currency currency2= currencyRepository.save(currency1);
			return mapper.convertCurrencyToCurrencyDTO(currency2);
		}
		else {
			return null;
		}
		
	}


	public CurrencyDTO findByFromAndTo(String fromCountryCode, String toCountryCode) {
		CurrencyMapper mapper=new CurrencyMapper();
		Currency currency1 = currencyRepository.findByFromcountryAndTocountry(fromCountryCode, toCountryCode);   
		
		return mapper.convertCurrencyToCurrencyDTO(currency1);
	}

}
