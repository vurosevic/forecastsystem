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
import deloitte.forecastsystem_bih.model.WeatherForecastHourly;
//import deloitte.forecastsystem_bih.model.communication.LoadEntsoeForecastSumRecord;
import deloitte.forecastsystem_bih.model.communication.WeatherForecastRecord;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.LoadForecastArimaService;
import deloitte.forecastsystem_bih.service.LoadForecastSimilarDayService;
//import deloitte.forecastsystem_bih.service.LoadForecastEntsoeService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;
import deloitte.forecastsystem_bih.service.TempLoadForecastArimaService;
import deloitte.forecastsystem_bih.service.TempLoadForecastSimilarDayService;
import deloitte.forecastsystem_bih.service.WeatherForecastHourlyService;
import deloitte.forecastsystem_bih.service.WeatherForecastService;

//
// Not implemented yet ...
// 

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
	TempLoadForecastArimaService loadForecastArimaService;
	
	@Autowired
	TempLoadForecastSimilarDayService loadForecastSimilarDayService;	
	
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
		
		cal.set(this.godina, this.mesec-1, this.dan); 
		Date dateYesterday = cal.getTime();
		cal.set(this.godina, this.mesec-1, this.dan+1); 
		Date dateToday = cal.getTime();		
		
//		System.out.println("DateYesterday: " + dateYesterday);
//		System.out.println("DateToday: " + dateToday);		
		
		List<WeatherForecast> weatherForecastList;
		List<WeatherForecastHourly> weatherForecastResults;
		
		try {
		 weatherForecastList = weatherForecastService.findByDate(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateYesterday);
		 Integer startPos = weatherForecastHourlyService.findByDayForecatsByHourStart(weatherForecastList.get(0), dateToday);
		 weatherForecastResults = weatherForecastHourlyService.findByDayForecatsByHour(weatherForecastList.get(0), dateToday, loadHour+startPos);
		} catch (Exception e) {
			return null;
		}
		
		List<Double> loadArimaForecastResult = loadForecastArimaService.findByDateLoadAndHour(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateToday, loadHour); 		
		List<Double> loadSimilarDayForecastResult = loadForecastSimilarDayService.findByDateLoadAndHour(countryService.findById(Long.valueOf(this.getCountry().ordinal()+1)), dateToday, loadHour); 				
		
		double[] res = preparedDataLoadHoursService.findByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))).get(0).preparedVector();
		
		res[33] = weatherForecastResults.get(0).getTemperature();
		res[34] = weatherForecastResults.get(0).getApparentTemperature();
		res[35] = weatherForecastResults.get(0).getWindSpeed();
		res[36] = weatherForecastResults.get(0).getHumidity();
		res[37] = weatherForecastResults.get(0).getDewPoint();
		res[38] = weatherForecastResults.get(0).getPressure();
		res[39] = loadArimaForecastResult.get(0); // arima_forecast 
		res[40] = loadSimilarDayForecastResult.get(0); // similar_day_forecast   		
		
		return res;	
	}		
	
	public double getRealLoad() {
		return preparedDataLoadHoursService.findRealByDate(this.loadHour, this.dan, this.mesec, this.godina, countryService.findById(Long.valueOf(this.getCountry().ordinal()+1))); 
	}

}
