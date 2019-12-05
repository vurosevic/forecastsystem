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
import deloitte.forecastsystem_bih.model.TempLoadForecastArima;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;
import deloitte.forecastsystem_bih.service.TempLoadForecastArimaService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class ArimaForecastService48 implements CommandLineRunner {

	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired
	CountryService countryService; 
	
	@Autowired
	ArimaModelService arimaModelService;
	
	@Autowired
	TempLoadForecastArimaService tempLoadForecastArimaService;
	
	public static void main(String[] args) {
	    SpringApplication.run(ArimaForecastService48.class, args);	
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--ARIMA FORECAST SERVICE--");
		System.out.println("--------------------------");		
		
		Country con = countryService.findById(2L);
		
		double[] res = preparedDataLoadHoursService.getAllRealDataLoadHoursByCountry(con);
		int[] res_god = preparedDataLoadHoursService.getAllGodinaLoadHoursByCountry(con);
		int[] res_mes = preparedDataLoadHoursService.getAllMesecLoadHoursByCountry(con);
		int[] res_dan = preparedDataLoadHoursService.getAllDanLoadHoursByCountry(con);
		int[] res_hour = preparedDataLoadHoursService.getAllHourLoadHoursByCountry(con);
		
		arimaModelService.setDataArray(res);
		arimaModelService.setpForecastSize(48);		
		
		arimaModelService.setPp(24); 
		arimaModelService.setPd(1); 
		arimaModelService.setPq(1); 
		
        Calendar c = Calendar.getInstance(); 
		TempLoadForecastArima lfa = new TempLoadForecastArima();	
		
		arimaModelService.prepareDataArrayPart(res.length);
		arimaModelService.trainArima();
		
        c.set(res_god[res_god.length-1], res_mes[res_mes.length-1]-1, res_dan[res_dan.length-1], 0, 0, 0);	
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Arima Forecast for Date: " + c.getTime());
        for (int i=0; i<24; i++) {
        ArimaRecord arimaRec = new ArimaRecord(c.getTime(), i, new Date());
		arimaRec.addHourForecast(arimaModelService.getForecastData()[i]);
		
		lfa.setCountry(countryService.findById(2L));
		lfa.setLoadDate(arimaRec.getLoadDate());
		lfa.setForecastDate(arimaRec.getForecastDate());
		lfa.setLoadForecastArima(arimaRec.getLoadForecastArima());
		lfa.setLoadHour(arimaRec.getLoadHour());
		lfa.setLoadMinute(arimaRec.getLoadMinute());
		lfa.setId(0L);	
		
		tempLoadForecastArimaService.save(lfa);
        }
        
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Arima Forecast for Date: " + c.getTime());        
        for (int i=0; i<24; i++) {
        ArimaRecord arimaRec = new ArimaRecord(c.getTime(), i, new Date());
		arimaRec.addHourForecast(arimaModelService.getForecastData()[24+i]);
		
		lfa.setCountry(countryService.findById(2L));
		lfa.setLoadDate(arimaRec.getLoadDate());
		lfa.setForecastDate(arimaRec.getForecastDate());
		lfa.setLoadForecastArima(arimaRec.getLoadForecastArima());
		lfa.setLoadHour(arimaRec.getLoadHour());
		lfa.setLoadMinute(arimaRec.getLoadMinute());
		lfa.setId(0L);	
		
		tempLoadForecastArimaService.save(lfa);
        }        
		
        System.out.println("END.");
	}

}
