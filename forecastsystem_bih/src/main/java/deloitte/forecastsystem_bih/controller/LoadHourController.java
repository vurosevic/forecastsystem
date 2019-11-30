package deloitte.forecastsystem_bih.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import deloitte.forecastsystem_bih.loadforecast.datavector.DataVectorHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastHoursLoad;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Load;
import deloitte.forecastsystem_bih.model.communication.LoadHoursComm;
import deloitte.forecastsystem_bih.model.communication.LoadHoursCommRecords;
import deloitte.forecastsystem_bih.service.CountryService;
//import deloitte.forecastsystem_bih.webscrapload.GrabLoadData;

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
    	
    	//Get real data for Today
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); 
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); 
        Date datumForecast= cal.getTime();    
        
        Country con = countryService.findById(Long.valueOf(o.getLhccountry()));
                
//        GrabLoadData gld = new GrabLoadData(con.getLoad());            
//        gld.setDateLoad(dateFormat.format(datumForecast));
//        gld.setCountry(con); 
//        gld.webScrap();    
//        List<Load> listReal = gld.getLoadDataList();
    	
    	for (int i=0; i<24; i++) {
    		
			MlpNetHoursLoad nn = systemForecast.getNetByCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			nn.loadLastStateMlpNet();    	
			
			LoadHoursCommRecords record = new LoadHoursCommRecords(); 			
			
			dataVector.setLoadHour(i);
			dataVector.setCountry(CountriesEnum.values()[o.getLhccountry()-1]);
			dataVector.setDan(o.getLhcday());
			dataVector.setMesec(o.getLhcmonth());
			dataVector.setGodina(o.getLhcyear());
			
//			Boolean test = Boolean.FALSE;
			
			try {
			record.setLachour(i);
			record.setLacday(o.getLhcday());
			record.setLacmonth(o.getLhcmonth());
			record.setLacyear(o.getLhcyear());
			record.setLaccountry(o.getLhccountry());					
			record.setLacForecast(nn.predict(dataVector.getPreparedDataToday()));			
			 
//			for (Load l : listReal) {
//				if ((l.getLoadHour() == i) && (l.getLoadMinute() == 0)) {
//					test = Boolean.TRUE;
//				    record.setLacRealLoad(l.getLoadRealData());	
//				}
//			}
//			if (test == Boolean.FALSE) record.setLacRealLoad(0);
			record.setLacRealLoad(0);
			
			records.add(record);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error:" + e.getMessage());
				System.out.println("Data not exist: " + CountriesEnum.values()[o.getLhccountry()-1] + ", " + i + " : " + o.getLhcday() + "." + o.getLhcmonth() + "." + o.getLhcyear());
			}
    	}
    	    	    	
        return ResponseEntity.status(HttpStatus.OK).body(records);  
    }     

}
