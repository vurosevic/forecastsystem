package deloitte.forecastsystem_bih.loadforecast.similarday;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

public class SimilarDayInputData {
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	PreparedDataLoadHoursRecord inputDataForToday[];
	PreparedDataLoadHoursRecord inputDataForTomorrow[];
	
	public SimilarDayInputData() {
		// TODO Auto-generated constructor stub
		inputDataForToday = new PreparedDataLoadHoursRecord[24];
		inputDataForTomorrow = new PreparedDataLoadHoursRecord[24];
	}
	
	public PreparedDataLoadHoursRecord[] prepareInputDataForToday(Date todayDate) {
		
		
		return inputDataForToday;
	}
	
	public PreparedDataLoadHoursRecord[] prepareInputDataForTomorrow(Date todayDate) {
		
		
		return inputDataForTomorrow;
	}	
	
}
