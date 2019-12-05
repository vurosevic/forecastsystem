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
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

@Service("similarDayInputDataService")
@Configurable
public class SimilarDayInputDataService {
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
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
	
	public PreparedDataLoadHoursRecord[] prepareInputDataForTomorrow(Date todayDate) {
		
		
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
