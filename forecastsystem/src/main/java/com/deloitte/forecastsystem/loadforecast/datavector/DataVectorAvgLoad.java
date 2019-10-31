package com.deloitte.forecastsystem.loadforecast.datavector;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastRecord;
import com.deloitte.forecastsystem.model.communication.WeatherForecastRecord;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.LoadForecastEntsoeService;
import com.deloitte.forecastsystem.service.LoadService;
import com.deloitte.forecastsystem.service.PreparedDataLoadAvgService;
import com.deloitte.forecastsystem.service.WeatherForecastHourlyService;
import com.deloitte.forecastsystem.service.WeatherForecastService;

@Service("dataVectorAvgLoad")
@Configurable
public class DataVectorAvgLoad implements DataVector {
	
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
	PreparedDataLoadAvgService preparedDataLoadAvgService;
	
	@Autowired 
	CountryService countryService;
	
	@Autowired
	LoadService loadService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	@Autowired
	WeatherForecastHourlyService weatherForecastHourlyService;
	
	@Autowired
	LoadForecastEntsoeService loadForecastEntsoeService;
	
	CountriesEnum country;
	
	Integer dan;
	Integer mesec;
	Integer godina;
	
	public DataVectorAvgLoad() {
		// TODO Auto-generated constructor stub
		//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//this.country = CountriesEnum.CO_RS;
	}
	
	public DataVectorAvgLoad(CountriesEnum con, Integer dan, Integer mesec, Integer godina) {
		// TODO Auto-generated constructor stub
		this.country = con;
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;							
	}
	
	public double[] getPreparedData() {						
		return preparedDataLoadAvgService.findByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVector(); 				
	}
	
	public double[] getPreparedDataToday() {	
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Belgrade"));
		cal.set(this.godina, this.mesec-1, this.dan);
		Date dateYesterday = cal.getTime();
		cal.set(this.godina, this.mesec-1, this.dan+1);
		Date dateToday = cal.getTime();		
		
		List<WeatherForecast> weatherForecastList = weatherForecastService.findByDate(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateYesterday);
		WeatherForecastRecord weatherForecastRecord = weatherForecastHourlyService.findByDayForecatsRecord(weatherForecastList.get(0), dateToday);
		
		LoadEntsoeForecastRecord loadEntsoeForecastRecord = loadForecastEntsoeService.findByDateForecastRecord(dateYesterday, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateToday); 
		
		double[] res = preparedDataLoadAvgService.findByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVectorToday();
		
		res[46] = loadService.getRealMinLoadByDate(dateYesterday, countryService.findById(Long.valueOf(this.country.ordinal())));
		res[47] = loadService.getRealMaxLoadByDate(dateYesterday, countryService.findById(Long.valueOf(this.country.ordinal())));
		res[48] = weatherForecastRecord.getAvgTemperature();
		res[49] = weatherForecastRecord.getMinTemperature();
		res[50] = weatherForecastRecord.getMaxTemperature();
		res[51] = weatherForecastRecord.getAvgFeelslike();
		res[52] = weatherForecastRecord.getMinFeelslike();
		res[53] = weatherForecastRecord.getMaxFeelslike();
		res[54] = loadEntsoeForecastRecord.getAvgLoadForecastEntsoe();
		res[55] = loadEntsoeForecastRecord.getMinLoadForecastEntsoe();
		res[56] = loadEntsoeForecastRecord.getMaxLoadForecastentsoe();
		
		return res;	
	}	
	
	public double getRealLoad() {
		return preparedDataLoadAvgService.findRealByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}
}
