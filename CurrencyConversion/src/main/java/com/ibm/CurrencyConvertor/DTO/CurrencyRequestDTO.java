package com.ibm.CurrencyConvertor.DTO;

public class CurrencyRequestDTO {

	private String fromCountryCode;
	private String toCountryCode;
	private Long conversionFactor;
	private Long amountobeconverted;
	
	
	public Long getAmountobeconverted() {
		return amountobeconverted;
	}
	public void setAmountobeconverted(Long amountobeconverted) {
		this.amountobeconverted = amountobeconverted;
	}
	public Long getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Long conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public String getFromCountryCode() {
		return fromCountryCode;
	}
	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
	public String getToCountryCode() {
		return toCountryCode;
	}
	public void setToCountryCode(String toCountryCode) {
		this.toCountryCode = toCountryCode;
	}
	
}
