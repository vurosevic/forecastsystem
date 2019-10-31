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
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastAvgLoad;
import com.deloitte.forecastsystem.model.communication.LoadAvgComm;
import com.deloitte.forecastsystem.model.communication.LoadAvgCommRecords;
import com.deloitte.forecastsystem.service.CountryService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	SystemForecastAvgLoad systemForecast;
	
	@Autowired
	DataVectorAvgLoad dataVector;	
	
    @RequestMapping(value = "/testmonth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predict(@RequestBody LoadAvgComm o) { 
    	
    	System.out.println("TEST PREDICT MONTH COMMAND");    	
    	System.out.println(o);   
    	
    	List<LoadAvgCommRecords> records = new ArrayList<LoadAvgCommRecords>();
    	
    	YearMonth yearMonthObject = YearMonth.of(o.getLacyear(), o.getLacmonth());
    	int daysInMonth = yearMonthObject.lengthOfMonth(); 
    	
    	
    	System.out.println("IZABRANA ZEMLJA: " + CountriesEnum.values()[o.getLaccountry()-1]);
    	
    	for (int i=1; i<=daysInMonth; i++) {
    		
			MlpNetAvgLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLaccountry()-1]);
			nn.loadLastStateMlpNet();    	
			
			LoadAvgCommRecords record = new LoadAvgCommRecords(); 
			
			
			dataVector.setCountry(CountriesEnum.values()[o.getLaccountry()-1]);
			dataVector.setDan(i);
			dataVector.setMesec(o.getLacmonth());
			dataVector.setGodina(o.getLacyear());
			
			try {
			record.setLacday(i);
			record.setLacmonth(o.getLacmonth());
			record.setLacyear(o.getLacyear());
			record.setLaccountry(o.getLaccountry());					
			record.setLacForecast(nn.predict(dataVector.getPreparedData()));
			record.setLacRealLoad(dataVector.getRealLoad());     		
			records.add(record);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Data not exist: " + CountriesEnum.values()[o.getLaccountry()-1] + ", " + i + "." + o.getLacmonth() + "." + o.getLacyear());
			}
    	}
    	    	    	
        return ResponseEntity.status(HttpStatus.OK).body(records); 
    } 	

}
