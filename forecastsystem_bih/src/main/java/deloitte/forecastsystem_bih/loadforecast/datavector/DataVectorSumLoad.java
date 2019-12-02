package deloitte.forecastsystem_bih.loadforecast.datavector;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.model.WeatherForecast;
//import deloitte.forecastsystem_bih.model.communication.LoadEntsoeForecastRecord;
//import deloitte.forecastsystem_bih.model.communication.LoadEntsoeForecastSumRecord;
import deloitte.forecastsystem_bih.model.communication.WeatherForecastRecord;
import deloitte.forecastsystem_bih.service.CountryService;
//import deloitte.forecastsystem_bih.service.LoadForecastEntsoeByHourService;
//import deloitte.forecastsystem_bih.service.LoadForecastEntsoeService;
import deloitte.forecastsystem_bih.service.LoadService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadSumService;
import deloitte.forecastsystem_bih.service.WeatherForecastHourlyService;
import deloitte.forecastsystem_bih.service.WeatherForecastService;

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
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	@Autowired
	WeatherForecastHourlyService weatherForecastHourlyService;
	
	//@Autowired
	//LoadForecastEntsoeByHourService loadForecastEntsoeByHourService;
	
	@Autowired
	LoadService loadService;	
	
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
	
	public double[] getPreparedDataToday() {	
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Belgrade"));
		cal.set(this.godina, this.mesec-1, this.dan);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);		
		
		Date dateYesterday = cal.getTime();
		cal.set(this.godina, this.mesec-1, this.dan+1);
		Date dateToday = cal.getTime();		
		
//		System.out.println("DateYesterday: " + dateYesterday);
//		System.out.println("DateToday: " + dateToday);		
		
		List<WeatherForecast> weatherForecastList;
		WeatherForecastRecord weatherForecastRecord;
		
		try {
		 weatherForecastList = weatherForecastService.findByDate(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateYesterday);
		 weatherForecastRecord = weatherForecastHourlyService.findByDayForecatsRecord(weatherForecastList.get(0), dateToday);
		} catch (Exception e) {
			return null;
		}
		
	//	LoadEntsoeForecastSumRecord loadEntsoeForecastSumRecord = loadForecastEntsoeByHourService.findByDateForecastSumRecord(dateYesterday, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateToday); 
		
		double[] res = preparedDataLoadSumService.findByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVectorToday();
		
		res[46] = loadService.getRealMinLoadByDate(dateYesterday, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)));
		res[47] = loadService.getRealMaxLoadByDate(dateYesterday, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)));
		res[48] = weatherForecastRecord.getAvgTemperature();
		res[49] = weatherForecastRecord.getMinTemperature();
		res[50] = weatherForecastRecord.getMaxTemperature();
		res[51] = weatherForecastRecord.getAvgFeelslike();
		res[52] = weatherForecastRecord.getMinFeelslike();
		res[53] = weatherForecastRecord.getMaxFeelslike();
//		res[54] = loadEntsoeForecastSumRecord.getSumLoadForecastEntsoe();
//		res[55] = loadEntsoeForecastSumRecord.getMinLoadForecastEntsoe();
//		res[56] = loadEntsoeForecastSumRecord.getMaxLoadForecastentsoe();
		
		return res;	
	}		
	
	public double getRealLoad() {
		return preparedDataLoadSumService.findRealByDate(this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}

}
