package com.deloitte.forecastsystem.loadforecast.config;

public enum CountriesEnum {
	CO_RS, CO_BIH, CO_HU, CO_RO, CO_CR, CO_CZ, 
	CO_SK, CO_SL, CO_PO, CO_BL, CO_GR, CO_AT, CO_ME;
    
	public final int value;
	
	private CountriesEnum() {
		// TODO Auto-generated constructor stub
		value = 0;
	}
	
	CountriesEnum(final int value) {
	     this.value = value;
	  }
 }
