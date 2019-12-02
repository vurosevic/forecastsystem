package deloitte.forecastsystem_bih.controller;

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

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.datavector.DataVectorSumLoad;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetSumLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastSumLoad;
import deloitte.forecastsystem_bih.model.communication.LoadAvgComm;
import deloitte.forecastsystem_bih.model.communication.LoadAvgCommRecords;
import deloitte.forecastsystem_bih.service.CountryService;

@RestController
@RequestMapping("/loadsum")
public class LoadSumController {

	@Autowired
	CountryService countryService;
	
	@Autowired
	SystemForecastSumLoad systemForecast;
	
	@Autowired
	DataVectorSumLoad dataVector;		
	
    @RequestMapping(value = "/predict", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predict(@RequestBody LoadAvgComm o) { 
    	
    	System.out.println("PREDICT 'SUM LOAD' COMMAND");    	
    	System.out.println(o);   
    	
		MlpNetSumLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLaccountry()-1]);
		nn.loadLastStateMlpNet();    	
		
		dataVector.setCountry(CountriesEnum.values()[o.getLaccountry()-1]);
		dataVector.setDan(o.getLacday());
		dataVector.setMesec(o.getLacmonth());
		dataVector.setGodina(o.getLacyear()); 	
		
		Double result = nn.predict(dataVector.getPreparedData());
    	
        return ResponseEntity.status(HttpStatus.OK).body(result); 
    }
    
    @RequestMapping(value = "/predicttoday", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predictToday(@RequestBody LoadAvgComm o) { 
    	
    	System.out.println("PREDICT TODAY 'SUM LOAD' COMMAND");    	
    	System.out.println(o);   
    	
		MlpNetSumLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLaccountry()-1]);
		nn.loadLastStateMlpNet();    	
		
		dataVector.setCountry(CountriesEnum.values()[o.getLaccountry()-1]);
		dataVector.setDan(o.getLacday()); 
		dataVector.setMesec(o.getLacmonth());
		dataVector.setGodina(o.getLacyear()); 	
		
		//Double result = nn.predict(dataVector.getPreparedDataToday());
		Double result = 0.0;
		
		
//		System.out.println("------------");
//		System.out.println("GET PREPARED DATA: ");
//		for (int i=0; i<dataVector.getPreparedData().length; i++) {
//			System.out.print(dataVector.getPreparedData()[i] + ", ");
//		}
//		
//		dataVector.setDan(o.getLacday()-1);
//		System.out.println("------------");
//		System.out.println("GET PREPARED DATA TODAY: ");
//		for (int i=0; i<dataVector.getPreparedDataToday().length; i++) {
//			System.out.print(dataVector.getPreparedDataToday()[i] + ", ");
//		}		
//		System.out.println("------------");
		  	
        return ResponseEntity.status(HttpStatus.OK).body(result); 
    }      
    
    @RequestMapping(value = "/predictmonth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)        
    public @ResponseBody Object predictMonth(@RequestBody LoadAvgComm o) { 
    	
    	System.out.println("PREDICT 'MONTH SUM LOAD' COMMAND");    	
    	System.out.println(o);   
    	
    	List<LoadAvgCommRecords> records = new ArrayList<LoadAvgCommRecords>();
    	
    	YearMonth yearMonthObject = YearMonth.of(o.getLacyear(), o.getLacmonth());
    	int daysInMonth = yearMonthObject.lengthOfMonth(); 
    	    	
    	System.out.println("SELECTED COUNTRY: " + CountriesEnum.values()[o.getLaccountry()-1]);
    	
    	for (int i=1; i<=daysInMonth; i++) {
    		
			MlpNetSumLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLaccountry()-1]);
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
				System.out.println(e.getMessage());
				System.out.println("Data not exist: " + CountriesEnum.values()[o.getLaccountry()-1] + ", " + i + "." + o.getLacmonth() + "." + o.getLacyear());
			}
    	}
    	    	    	
        return ResponseEntity.status(HttpStatus.OK).body(records);  
    }     
}
