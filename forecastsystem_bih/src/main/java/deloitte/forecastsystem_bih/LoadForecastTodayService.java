package deloitte.forecastsystem_bih;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.datavector.DataVectorHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastHoursLoad;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.HistoryLoadForecast;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.HistoryLoadForecastService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class LoadForecastTodayService implements CommandLineRunner {
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired
	CountryService countryService;	
	
	@Autowired
	DataVectorHoursLoad dataVector;	 	
	
	@Autowired
	SystemForecastHoursLoad systemForecast;
	
	@Autowired
	HistoryLoadForecastService historyLoadForecastService;
	
	public static void main(String[] args) {
		SpringApplication.run(LoadForecastTodayService.class, args);
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

		Calendar cYesteday = Calendar.getInstance();
		cYesteday.set(res_god[res_god.length-1], res_mes[res_mes.length-1]-1, res_dan[res_dan.length-1], 0, 0, 0);		
		
		Calendar cToday = Calendar.getInstance();
		cToday.set(res_god[res_god.length-1], res_mes[res_mes.length-1]-1, res_dan[res_dan.length-1], 0, 0, 0);	
		cToday.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("LoadForecastToday for Date: " + cToday.getTime());
        
		MlpNetHoursLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[1]); //BIH
		nn.loadLastStateMlpNet();	        
        
    	for (int i=0; i<24; i++) {
    		
			dataVector.setLoadHour(i);
			dataVector.setCountry(CountriesEnum.values()[1]); //BIH
			dataVector.setDan(cYesteday.get(Calendar.DAY_OF_MONTH)); 
			dataVector.setMesec(cYesteday.get(Calendar.MONTH)+1); 
			dataVector.setGodina(cYesteday.get(Calendar.YEAR));         	
        		
    		HistoryLoadForecast historyLoadForecast = new HistoryLoadForecast();
    		
    		historyLoadForecast.setCountry(con);
    		historyLoadForecast.setId(0L);
    		historyLoadForecast.setForecastDate(cForecastToday.getTime());
    		historyLoadForecast.setLoadDate(cToday.getTime());
    		historyLoadForecast.setLoadForecastData(nn.predict(dataVector.getPreparedDataToday()));  
    		historyLoadForecast.setLoadHour(i);
    		historyLoadForecast.setLoadMinute(0);    
    		
    		historyLoadForecastService.save(historyLoadForecast); 
    	}
            System.out.println("END.");
		
	}

}
