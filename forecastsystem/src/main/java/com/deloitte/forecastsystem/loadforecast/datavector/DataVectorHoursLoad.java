package com.deloitte.forecastsystem.loadforecast.datavector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.PreparedDataLoadHoursService;

@Service("dataVectorHoursLoad")
@Configurable
public class DataVectorHoursLoad implements  DataVector {

	public CountriesEnum getCountry() {
		return country;
	}

	public void setCountry(CountriesEnum country) {
		this.country = country;
	}

	public Integer getDan() {
		return dan;
	}

	public void setDan(Integer dan) {
		this.dan = dan;
	}

	public Integer getMesec() {
		return mesec;
	}

	public void setMesec(Integer mesec) {
		this.mesec = mesec;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}
	
	
	
	public Integer getLoadHour() {
		return loadHour;
	}

	public void setLoadHour(Integer loadHour) {
		this.loadHour = loadHour;
	}



	@Autowired
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired 
	CountryService countryService;
	
	CountriesEnum country;
	
	Integer dan;
	Integer mesec;
	Integer godina;
	Integer loadHour;
	
	public DataVectorHoursLoad() {
		// TODO Auto-generated constructor stub
		//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//this.country = CountriesEnum.CO_RS;
	}
	
	public DataVectorHoursLoad(CountriesEnum con,Integer loadHours, Integer dan, Integer mesec, Integer godina) {
		// TODO Auto-generated constructor stub
		this.country = con;
		this.loadHour = loadHours;
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;							
	}
	
	public double[] getPreparedData() {						
		return preparedDataLoadHoursService.findByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVector(); 				
	}
	
	public double getRealLoad() {
		return preparedDataLoadHoursService.findRealByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}

}
