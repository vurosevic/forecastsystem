package deloitte.forecastsystem_bih;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
public class TestSimilarDay implements CommandLineRunner {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	SimilarDayService similarDayService;

	@Autowired 
	LoadForecastSimilarDayService loadForecastSimilarDayService; 		
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;	
	
	public static void main(String[] args){

		SpringApplication.run(TestSimilarDay.class, args);		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("TEST SIMILAR DAY: ");
		
		Country con = countryService.findById(2L);	

		//Long number = 24560L;
		
//		File file = new File("similarday_loadsum_bih.csv");
//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);			
				
		LoadForecastSimilarDay lfsd = new LoadForecastSimilarDay();
		
		similarDayService.set(con, 16172L);
		similarDayService.normalizeData();	
		
//		for (Long number = 16172L; number < 41589L; number++)
//		for (Long number = 41589L; number < 41591L; number++)
		for (Long number = 16172L; number < 41591L; number++)
		{
		
		PreparedDataLoadHours recData = preparedDataLoadHoursService.findById(number).get();
		
		similarDayService.set(con, number-1);		
		
		//PreparedDataLoadHoursRecord rec = new PreparedDataLoadHoursRecord(8410L, -3.0,-3.0,687.0,-2.0,-2.0,690.0,-3.0,-3.0,705.0, 624.0); 
		//PreparedDataLoadHoursRecord rec = new PreparedDataLoadHoursRecord(11500L, 10.0,10.0,360.0, 10.0, 10.0,376.0, 11.0, 11.0, 369.0, 372.0);
		PreparedDataLoadHoursRecord rec = new PreparedDataLoadHoursRecord(number, recData.getAvgTemperature4() , recData.getAvgFeelslike4() , recData.getAvgLoadRealData4(), 
																			  	  recData.getAvgTemperature3() , recData.getAvgFeelslike3() , recData.getAvgLoadRealData3(), 
																			  	  recData.getAvgTemperature2() , recData.getAvgFeelslike2() , recData.getAvgLoadRealData2(), 
																			  	  recData.getAvgLoadRealData());
		
		//PreparedDataLoadHoursRecord rec = new PreparedDataLoadHoursRecord(11500L, 10.0,10.0,360.0, 10.0, 10.0,376.0, 11.0, 11.0, 369.0, 372.0);
		
		similarDayService.calculateDistance(rec); 
		
//		System.out.println("....... DATA ......." + similarDayService.getData().size());
//		System.out.println("....... NORMDATA ......." + similarDayService.getNormalizedData().size());
//		System.out.println("....... DISTANCEDATA ......." + similarDayService.getDistance().size());
//		System.out.println("....... MIN INDEX ......." + similarDayService.getMinIndex()); 		
//		System.out.println("....... PREDICT VALUE ......." + similarDayService.getForecast());
//		System.out.println("....... REAL VALUE ......." + recData.getAvgLoadRealData());		
//		System.out.println("..............");			
		
//		bw.write(recData.getAvgLoadRealData() + ";" + similarDayService.getForecast() + "\n");
		
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
		
//		for (int i=0; i<similarDayService.getDistance().size(); i++){
//		
//		System.out.println(i + ". " + similarDayService.getDistance().get(i));
//		
//		}
		
		
		System.out.println("....... END .......");
		
	}	

}
