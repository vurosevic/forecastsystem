package deloitte.forecastsystem_bih;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.loadforecast.similarday.SimilarDayService;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.LoadForecastSimilarDayService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class PartialSimilarDayService implements CommandLineRunner {

	@Autowired
	CountryService countryService;
	
	@Autowired
	SimilarDayService similarDayService;

	@Autowired 
	LoadForecastSimilarDayService loadForecastSimilarDayService; 		
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;		
	
	public static void main(String[] args) {
		SpringApplication.run(PartialSimilarDayService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("PARTIAL SIMILAR DAY SERVICE: ");
		
		Country con = countryService.findById(2L);	
		
		LoadForecastSimilarDay lfsd = new LoadForecastSimilarDay();
				
		//Long start = 25059L;
		long[] ids = preparedDataLoadHoursService.getAllIdsLoadHoursByCountry(con);		
		
		Long startId = preparedDataLoadHoursService.getMinIndexForPartialData(con);
		Long endId = preparedDataLoadHoursService.getMaxIndexForPartialData(con);
		
		if (startId == null) {
			System.out.println("No data for update...");
			return;
		}
		
        Long startPos = -1L; 
        for (int i=0; i<ids.length; i++) { 
            if (ids[i] == startId) { 
            	startPos = Long.valueOf(i); 
                break; 
            } 
        } 	
        
        System.out.println("Start position: " + startPos);		
		System.out.println("Id interval: " + startId + "," + endId);
		
		similarDayService.set(con, startPos);
		similarDayService.normalizeData();	
		
		
	//	for (Long number = 25059L; number < endPos; number++) {
		for (Long number = startId; number <= endId; number++) {
		
		PreparedDataLoadHours recData = preparedDataLoadHoursService.findById(number).get();
		
		similarDayService.set(con, startPos);
		startPos++;
		
		//similarDayService.set(con, start);		
		//start++;
		
		PreparedDataLoadHoursRecord rec = new PreparedDataLoadHoursRecord(number, recData.getAvgTemperature4() , recData.getAvgFeelslike4() , recData.getAvgLoadRealData4(), 
																			  	  recData.getAvgTemperature3() , recData.getAvgFeelslike3() , recData.getAvgLoadRealData3(), 
																			  	  recData.getAvgTemperature2() , recData.getAvgFeelslike2() , recData.getAvgLoadRealData2(), 
																			  	  recData.getAvgLoadRealData());		
		similarDayService.calculateDistance(rec); 
			
		lfsd.setCountry(con);
		lfsd.setId(0L);
		Calendar c = Calendar.getInstance();
		lfsd.setForecastDate(c.getTime());
		c.set(recData.getGodina(), recData.getMesec()-1, recData.getDan(), 0, 0, 0);
		lfsd.setLoadDate(c.getTime());
		lfsd.setLoadForecastSimilarDay(similarDayService.getForecast()); 
		lfsd.setLoadHour(recData.getLoadHour());
		lfsd.setLoadMinute(0); 
		loadForecastSimilarDayService.save(lfsd);
		
		System.out.println(recData.getAvgLoadRealData() + "," + similarDayService.getForecast());
		
		} // number
		
		System.out.println("....... END .......");		
	}
	
}
