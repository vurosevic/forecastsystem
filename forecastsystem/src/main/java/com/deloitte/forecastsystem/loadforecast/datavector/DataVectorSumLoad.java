package com.deloitte.forecastsystem.loadforecast.datavector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.PreparedDataLoadSumService;

@Service("dataVectorSumLoad")
@Configurable
public class DataVectorSumLoad implements DataVector {

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
	
	@Autowired
	PreparedDataLoadSumService preparedDataLoadSumService;
	
	@Autowired 
	CountryService countryService;
	
	CountriesEnum country;
	
	Integer dan;
	Integer mesec;
	Integer godina;
	
	public DataVectorSumLoad() {
		// TODO Auto-generated constructor stub
		//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//this.country = CountriesEnum.CO_RS;
	}
	
	public DataVectorSumLoad(CountriesEnum con, Integer dan, Integer mesec, Integer godina) {
		// TODO Auto-generated constructor stub
		this.country = con;
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;							
	}
	
	public double[] getPreparedData() {						
		return preparedDataLoadSumService.findByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVector(); 				
	}
	
	public double getRealLoad() {
		return preparedDataLoadSumService.findRealByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}

}
