package com.deloitte.forecastsystem.controller;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.datavector.DataVectorAvgLoad;
import com.deloitte.forecastsystem.loadforecast.datavector.DataVectorHoursLoad;
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetAvgLoad;
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetHoursLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastHoursLoad;
import com.deloitte.forecastsystem.model.communication.LoadAvgComm;
import com.deloitte.forecastsystem.model.communication.LoadAvgCommRecords;
import com.deloitte.forecastsystem.model.communication.LoadHoursComm;
import com.deloitte.forecastsystem.model.communication.LoadHoursCommRecords;
import com.deloitte.forecastsystem.service.CountryService;

@RestController
@RequestMapping("/loadhours")
public class LoadHourController {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	SystemForecastHoursLoad systemForecast;
	
	@Autowired
	DataVectorHoursLoad dataVector;	 	
    
    @RequestMapping(value = "/predictday", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predictMonth(@RequestBody LoadHoursComm o) { 
    	
    	System.out.println("PREDICT 'DAY BY HOURS - LOAD' COMMAND");    	
    	System.out.println(o);   
    	
    	List<LoadHoursCommRecords> records = new ArrayList<LoadHoursCommRecords>();
    	   	    	
    	System.out.println("SELECTED COUNTRY: " + CountriesEnum.values()[o.getLhccountry()-1]);
    	
    	for (int i=0; i<24; i++) {
    		
			MlpNetHoursLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			nn.loadLastStateMlpNet();    	
			
			LoadHoursCommRecords record = new LoadHoursCommRecords(); 			
			
			dataVector.setLoadHour(i);
			dataVector.setCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			dataVector.setDan(o.getLhcday());
			dataVector.setMesec(o.getLhcmonth());
			dataVector.setGodina(o.getLhcyear());
			
			try {
			record.setLachour(i);
			record.setLacday(o.getLhcday());
			record.setLacmonth(o.getLhcmonth());
			record.setLacyear(o.getLhcyear());
			record.setLaccountry(o.getLhccountry());					
			record.setLacForecast(nn.predict(dataVector.getPreparedData()));
			record.setLacRealLoad(dataVector.getRealLoad());     		
			records.add(record);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Data not exist: " + CountriesEnum.values()[o.getLhccountry()-1] + ", " + i + "." + o.getLhcmonth() + "." + o.getLhcyear());
			}
    	}
    	    	    	
        return ResponseEntity.status(HttpStatus.OK).body(records);  
    } 	
    
    @RequestMapping(value = "/predicttoday", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predictTodayByHours(@RequestBody LoadHoursComm o) { 
    	
    	System.out.println("PREDICT 'TODAY BY HOURS - LOAD' COMMAND");    	
    	System.out.println(o);   
    	
    	List<LoadHoursCommRecords> records = new ArrayList<LoadHoursCommRecords>();
    	   	    	
    	System.out.println("SELECTED COUNTRY: " + CountriesEnum.values()[o.getLhccountry()-1]);
    	
    	for (int i=0; i<24; i++) {
    		
			MlpNetHoursLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			nn.loadLastStateMlpNet();    	
			
			LoadHoursCommRecords record = new LoadHoursCommRecords(); 			
			
			dataVector.setLoadHour(i);
			dataVector.setCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			dataVector.setDan(o.getLhcday());
			dataVector.setMesec(o.getLhcmonth());
			dataVector.setGodina(o.getLhcyear());
			
			try {
			record.setLachour(i);
			record.setLacday(o.getLhcday());
			record.setLacmonth(o.getLhcmonth());
			record.setLacyear(o.getLhcyear());
			record.setLaccountry(o.getLhccountry());					
			record.setLacForecast(nn.predict(dataVector.getPreparedDataToday()));
			record.setLacRealLoad(0);     		
			records.add(record);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Data not exist: " + CountriesEnum.values()[o.getLhccountry()-1] + ", " + i + "." + o.getLhcmonth() + "." + o.getLhcyear());
			}
    	}
    	    	    	
        return ResponseEntity.status(HttpStatus.OK).body(records);  
    }     

}
