package deloitte.forecastsystem_bih.loadforecast.datavector;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;

public interface DataVector {
	
	 CountriesEnum getCountry();
	 void setCountry(CountriesEnum country);
	 Integer getDan();
	 void setDan(Integer dan);
	 Integer getMesec();
	 void setMesec(Integer mesec);
	 Integer getGodina();
	 void setGodina(Integer godina);
	 double[] getPreparedData();
	 double getRealLoad();

}
