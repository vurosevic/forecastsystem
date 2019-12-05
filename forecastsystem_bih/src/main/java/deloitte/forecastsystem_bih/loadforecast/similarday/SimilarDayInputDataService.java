package deloitte.forecastsystem_bih.loadforecast.similarday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastHourly;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.HistoryLoadForecastService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;
import deloitte.forecastsystem_bih.service.WeatherForecastHourlyService;
import deloitte.forecastsystem_bih.service.WeatherForecastService;

@Service("similarDayInputDataService")
@Configurable
public class SimilarDayInputDataService {
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired
	WeatherForecastService weatherForecastService;
	
	@Autowired
	WeatherForecastHourlyService weatherForecastHourlyService;
	
	@Autowired
	HistoryLoadForecastService historyLoadForecastService;
	
	PreparedDataLoadHoursRecord inputDataForToday[];
	PreparedDataLoadHoursRecord inputDataForTomorrow[];
	
	public SimilarDayInputDataService() {
		// TODO Auto-generated constructor stub
		inputDataForToday = new PreparedDataLoadHoursRecord[24];
		inputDataForTomorrow = new PreparedDataLoadHoursRecord[24];
	}
	
	public PreparedDataLoadHoursRecord[] prepareInputDataForToday(Date todayDate, Country con) {
		
		List<PreparedDataLoadHours> pdlh = new ArrayList<PreparedDataLoadHours>();
		
		for (int i=0; i<24; i++) {
		
		inputDataForToday[i] = new PreparedDataLoadHoursRecord();
		Calendar cal = Calendar.getInstance();
		cal.setTime(todayDate);
		
		// avgTemperature2
		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		pdlh = preparedDataLoadHoursService.findByDate(i, cal.get(Calendar.DAY_OF_MONTH), 
														  cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR), con);
		
		inputDataForToday[i].setAvgTemperature2(pdlh.get(0).getAvgTemperature());
		inputDataForToday[i].setAvgFeelslike2(pdlh.get(0).getAvgFeelslike());
		inputDataForToday[i].setAvgLoadRealData2(pdlh.get(0).getAvgLoadRealData());

		// avgTemperature3		
		inputDataForToday[i].setAvgTemperature3(pdlh.get(0).getAvgTemperature2());
		inputDataForToday[i].setAvgFeelslike3(pdlh.get(0).getAvgFeelslike2());
		inputDataForToday[i].setAvgLoadRealData3(pdlh.get(0).getAvgLoadRealData2());
		
		// avgTemperature4		
		inputDataForToday[i].setAvgTemperature4(pdlh.get(0).getAvgTemperature3());
		inputDataForToday[i].setAvgFeelslike4(pdlh.get(0).getAvgFeelslike3());
		inputDataForToday[i].setAvgLoadRealData4(pdlh.get(0).getAvgLoadRealData3());		
		
		inputDataForToday[i].setAvgLoadRealData(0.0);
		inputDataForToday[i].setId(0L); 
		}
				
		return inputDataForToday;
	}
	
	public PreparedDataLoadHoursRecord[] prepareInputDataForTomorrow(Date tomorrowDate, Country con) {
		
		List<PreparedDataLoadHours> pdlh = new ArrayList<PreparedDataLoadHours>();

		for (int i=0; i<24; i++) {
			
			inputDataForTomorrow[i] = new PreparedDataLoadHoursRecord();
			
			Calendar calToday = Calendar.getInstance();
			calToday.setTime(tomorrowDate);	
			
			calToday.add(Calendar.DAY_OF_MONTH, -2);
			calToday.set(Calendar.HOUR, 0);
			calToday.set(Calendar.MINUTE, 0);
			calToday.set(Calendar.SECOND, 0);
			calToday.set(Calendar.MILLISECOND, 0);
			
			
			Calendar calYesterday = Calendar.getInstance();
			calYesterday.setTime(tomorrowDate);
			
			calYesterday.add(Calendar.DAY_OF_MONTH, -1);
			calYesterday.set(Calendar.HOUR, 0);
			calYesterday.set(Calendar.MINUTE, 0);
			calYesterday.set(Calendar.SECOND, 0);
			calYesterday.set(Calendar.MILLISECOND, 0);
			
			Calendar calTomorrow = Calendar.getInstance();
			calTomorrow.setTime(tomorrowDate);
			
			calTomorrow.set(Calendar.HOUR, 0);
			calTomorrow.set(Calendar.MINUTE, 0);
			calTomorrow.set(Calendar.SECOND, 0);
			calTomorrow.set(Calendar.MILLISECOND, 0);								
			
			List<WeatherForecast> weatherForecastList;
			List<WeatherForecastHourly> weatherForecastResults;
			
			try {
			 weatherForecastList = weatherForecastService.findByDate(con, calYesterday.getTime());
			 Integer startPos = weatherForecastHourlyService.findByDayForecatsByHourStart(weatherForecastList.get(0), calTomorrow.getTime());
			 weatherForecastResults = weatherForecastHourlyService.findByDayForecatsByHour(weatherForecastList.get(0), calTomorrow.getTime(), i+startPos);
			} catch (Exception e) {
				return null;
			}			
		
			pdlh = preparedDataLoadHoursService.findByDate(i, calToday.get(Calendar.DAY_OF_MONTH), 
					calToday.get(Calendar.MONTH)+1, calToday.get(Calendar.YEAR), con);	
			
			List<Double> forecastLoad = historyLoadForecastService.findByDateLoadAndHour(con, calYesterday.getTime(), i);
			
			// avgForecastTemperature
			inputDataForTomorrow[i].setAvgTemperature2(weatherForecastResults.get(0).getTemperature());
			inputDataForTomorrow[i].setAvgFeelslike2(weatherForecastResults.get(0).getApparentTemperature());
			inputDataForTomorrow[i].setAvgLoadRealData2(forecastLoad.get(0)); 

			// avgTemperature2		
			inputDataForTomorrow[i].setAvgTemperature3(pdlh.get(0).getAvgTemperature());
			inputDataForTomorrow[i].setAvgFeelslike3(pdlh.get(0).getAvgFeelslike());
			inputDataForTomorrow[i].setAvgLoadRealData3(pdlh.get(0).getAvgLoadRealData());
			
			// avgTemperature3		
			inputDataForTomorrow[i].setAvgTemperature4(pdlh.get(0).getAvgTemperature2());
			inputDataForTomorrow[i].setAvgFeelslike4(pdlh.get(0).getAvgFeelslike2());
			inputDataForTomorrow[i].setAvgLoadRealData4(pdlh.get(0).getAvgLoadRealData2());		
			
			inputDataForTomorrow[i].setAvgLoadRealData(0.0);
			inputDataForTomorrow[i].setId(0L); 			
		}
		
		
		return inputDataForTomorrow;
	}

	public PreparedDataLoadHoursRecord[] getInputDataForToday() {
		return inputDataForToday;
	}

	public void setInputDataForToday(PreparedDataLoadHoursRecord[] inputDataForToday) {
		this.inputDataForToday = inputDataForToday;
	}

	public PreparedDataLoadHoursRecord[] getInputDataForTomorrow() {
		return inputDataForTomorrow;
	}

	public void setInputDataForTomorrow(PreparedDataLoadHoursRecord[] inputDataForTomorrow) {
		this.inputDataForTomorrow = inputDataForTomorrow;
	}	
	
}
