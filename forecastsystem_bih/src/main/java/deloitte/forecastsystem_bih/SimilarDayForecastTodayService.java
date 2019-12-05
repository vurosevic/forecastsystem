package deloitte.forecastsystem_bih;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.loadforecast.similarday.SimilarDayInputDataService;
import deloitte.forecastsystem_bih.loadforecast.similarday.SimilarDayService;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.TempLoadForecastSimilarDay;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;
import deloitte.forecastsystem_bih.service.TempLoadForecastSimilarDayService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class SimilarDayForecastTodayService implements CommandLineRunner {
	
	@Autowired
	SimilarDayInputDataService similarDayInputDataService;
	
	@Autowired
	SimilarDayService similarDayService;
	
	@Autowired
	TempLoadForecastSimilarDayService tempLoadForecastSimilarDayService;
	
	@Autowired
	CountryService countryService; 	
	
	@Autowired
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	public static void main(String[] args) {
		SpringApplication.run(SimilarDayForecastTodayService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Country con = countryService.findById(2L);					
		
		int[] res_god = preparedDataLoadHoursService.getAllGodinaLoadHoursByCountry(con);
		int[] res_mes = preparedDataLoadHoursService.getAllMesecLoadHoursByCountry(con);
		int[] res_dan = preparedDataLoadHoursService.getAllDanLoadHoursByCountry(con);
		
		Calendar cForecastToday = Calendar.getInstance();
		cForecastToday.set(Calendar.HOUR, 0);
		cForecastToday.set(Calendar.MINUTE, 0);
		cForecastToday.set(Calendar.SECOND, 0);
		cForecastToday.set(Calendar.MILLISECOND, 0);				
		
		Calendar c = Calendar.getInstance();
        c.set(res_god[res_god.length-1], res_mes[res_mes.length-1]-1, res_dan[res_dan.length-1], 0, 0, 0);	
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("SimilarDay Forecast for Date: " + c.getTime());		
		
		similarDayService.set(con, Long.valueOf(res_dan.length-1));
		similarDayService.normalizeData();
		
		similarDayInputDataService.prepareInputDataForToday(c.getTime(), con);
        
		for (int i=0; i<24; i++) {
			
			TempLoadForecastSimilarDay lfsd = new TempLoadForecastSimilarDay();		
			similarDayService.set(con, Long.valueOf(res_dan.length-1));
			similarDayService.calculateDistance(similarDayInputDataService.getInputDataForToday()[i]);
			 			
			lfsd.setCountry(con);
			lfsd.setId(0L);
			lfsd.setForecastDate(cForecastToday.getTime());
			lfsd.setLoadDate(c.getTime());
			lfsd.setLoadForecastSimilarDay(similarDayService.getForecast()); 
			lfsd.setLoadHour(i);
			lfsd.setLoadMinute(0); 			
			tempLoadForecastSimilarDayService.save(lfsd);
			
		}

        System.out.println("END.");
	}

}
