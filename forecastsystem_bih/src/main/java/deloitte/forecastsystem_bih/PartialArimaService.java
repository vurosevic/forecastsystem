package deloitte.forecastsystem_bih;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.loadforecast.arima.ArimaModelService;
import deloitte.forecastsystem_bih.loadforecast.arima.ArimaRecord;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.LoadForecastArima;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.LoadForecastArimaService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class PartialArimaService implements CommandLineRunner {
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired
	CountryService countryService; 
	
	@Autowired
	ArimaModelService arimaModelService;	
	
	@Autowired
	LoadForecastArimaService loadForecastArimaService;		
	
	public static void main(String[] args) {
		SpringApplication.run(PartialArimaService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("PARTIAL ARIMA SERVICE: ");
		
		Country con = countryService.findById(2L);
		
		double[] res = preparedDataLoadHoursService.getAllRealDataLoadHoursByCountry(con);
		int[] res_god = preparedDataLoadHoursService.getAllGodinaLoadHoursByCountry(con);
		int[] res_mes = preparedDataLoadHoursService.getAllMesecLoadHoursByCountry(con);
		int[] res_dan = preparedDataLoadHoursService.getAllDanLoadHoursByCountry(con);
		int[] res_hour = preparedDataLoadHoursService.getAllHourLoadHoursByCountry(con);
		long[] ids = preparedDataLoadHoursService.getAllIdsLoadHoursByCountry(con);
		
		
		Long startId = preparedDataLoadHoursService.getMinIndexForPartialData(con);
		Long endId = preparedDataLoadHoursService.getMaxIndexForPartialData(con);
		
		if (startId == null) {
			System.out.println("No data for update...");
			return;
		}
		
		arimaModelService.setDataArray(res);
		arimaModelService.setpForecastSize(1);		
		
		arimaModelService.setPp(24); 
		arimaModelService.setPd(1); 
		arimaModelService.setPq(1); 
		
        Calendar c = Calendar.getInstance();
		LoadForecastArima lfa = new LoadForecastArima();	
		
        Long startPos = -1L; 
        for (int i=0; i<res.length; i++) { 
            if (ids[i] == startId) { 
            	startPos = Long.valueOf(i); 
                break; 
            } 
        } 	
        
        System.out.println("Start position: " + startPos);
        
		if (startPos == -1) {
			System.out.println("No data for update...");
			return;
		}        
		
		//for (int i=25606; i<res.length; i++) {
		for (int i=startPos.intValue(); i<res.length; i++) {			
					arimaModelService.prepareDataArrayPart(i);
					arimaModelService.trainArima();		
					
					System.out.println(i + ".  "+arimaModelService.getDataArray()[i] + "," + arimaModelService.getForecastData()[0]);
					
			        c.set(res_god[i], res_mes[i]-1, res_dan[i], 0, 0, 0);	
			        ArimaRecord arimaRec = new ArimaRecord(c.getTime(), res_hour[i], new Date());
					
					arimaRec.addHourForecast(arimaModelService.getForecastData()[0]);
					lfa.setCountry(countryService.findById(2L));
					lfa.setLoadDate(arimaRec.getLoadDate());
					lfa.setForecastDate(arimaRec.getForecastDate());
					lfa.setLoadForecastArima(arimaRec.getLoadForecastArima());
					lfa.setLoadHour(arimaRec.getLoadHour());
					lfa.setLoadMinute(arimaRec.getLoadMinute());
					lfa.setId(0L); 
					
					loadForecastArimaService.save(lfa);					
		}
		
		System.out.println("End...");
	}

}
