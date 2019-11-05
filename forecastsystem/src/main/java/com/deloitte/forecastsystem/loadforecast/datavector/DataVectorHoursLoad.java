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
import com.deloitte.forecastsystem.model.WeatherForecastHourly;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;
import com.deloitte.forecastsystem.model.communication.WeatherForecastRecord;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.LoadForecastEntsoeService;
import com.deloitte.forecastsystem.service.PreparedDataLoadHoursService;
import com.deloitte.forecastsystem.service.WeatherForecastHourlyService;
import com.deloitte.forecastsystem.service.WeatherForecastService;

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
	
	public double[] getPreparedDataToday() {	
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Belgrade"));
		cal.set(this.godina, this.mesec-1, this.dan);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);		
		
		cal.set(this.godina, this.mesec-1, this.dan); // dodata linija
		Date dateYesterday = cal.getTime();
		cal.set(this.godina, this.mesec-1, this.dan+1); // +1
		Date dateToday = cal.getTime();		
		
		System.out.println("DateYesterday: " + dateYesterday);
		System.out.println("DateToday: " + dateToday);		
		
		List<WeatherForecast> weatherForecastList;
		List<WeatherForecastHourly> weatherForecastResults;
		
		try {
		 weatherForecastList = weatherForecastService.findByDate(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateYesterday);
		 weatherForecastResults = weatherForecastHourlyService.findByDayForecatsByHour(weatherForecastList.get(0), dateToday, loadHour+16);
		} catch (Exception e) {
			return null;
		}
		
		Double loadEntsoeForecastResult = loadForecastEntsoeService.findByDateForeastAndHour(dateYesterday, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateToday, loadHour); 
		
		double[] res = preparedDataLoadHoursService.findByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVector();
		
		res[29] = weatherForecastResults.get(0).getTemperature();
		res[30] = weatherForecastResults.get(0).getApparentTemperature();
		res[31] = weatherForecastResults.get(0).getWindSpeed();
		res[32] = weatherForecastResults.get(0).getHumidity();
		res[33] = weatherForecastResults.get(0).getDewPoint();
		res[34] = weatherForecastResults.get(0).getPressure();
		res[35] = loadEntsoeForecastResult;
		
		return res;	
	}		
	
	public double getRealLoad() {
		return preparedDataLoadHoursService.findRealByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}

}
