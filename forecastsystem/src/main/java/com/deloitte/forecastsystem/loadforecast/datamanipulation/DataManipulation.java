package com.deloitte.forecastsystem.loadforecast.datamanipulation;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;

public interface DataManipulation {

	String getFileName();
	String getQueryString();
	boolean prepareDataForTraining();
	CountriesEnum getCountry();
	void setCountry(CountriesEnum country);
	String getConnectionUrl();
	
}
