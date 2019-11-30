package deloitte.forecastsystem_bih.loadforecast.datamanipulation;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;

public interface DataManipulation {

	String getFileName();
	String getQueryString();
	boolean prepareDataForTraining();
	CountriesEnum getCountry();
	void setCountry(CountriesEnum country);
	String getConnectionUrl();
	
}
