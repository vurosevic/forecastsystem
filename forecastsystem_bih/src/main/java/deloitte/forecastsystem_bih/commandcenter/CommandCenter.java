package deloitte.forecastsystem_bih.commandcenter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import deloitte.forecastsystem_bih.loadforecast.arima.ArimaModelService;
import deloitte.forecastsystem_bih.loadforecast.arima.ArimaRecord;
import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.datavector.DataVectorHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.similarday.SimilarDayInputDataService;
import deloitte.forecastsystem_bih.loadforecast.similarday.SimilarDayService;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastHoursLoad;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.HistoryLoadForecast;
import deloitte.forecastsystem_bih.model.LoadForecastArima;
import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;
import deloitte.forecastsystem_bih.model.PartialInputDataHourlyComplete;
import deloitte.forecastsystem_bih.model.PartialInputDataHourlyStart;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.TempLoadForecastArima;
import deloitte.forecastsystem_bih.model.TempLoadForecastSimilarDay;
import deloitte.forecastsystem_bih.model.Weather;
import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastDaily;
import deloitte.forecastsystem_bih.model.WeatherForecastHourly;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.HistoryLoadForecastService;
import deloitte.forecastsystem_bih.service.LoadForecastArimaService;
import deloitte.forecastsystem_bih.service.LoadForecastSimilarDayService;
import deloitte.forecastsystem_bih.service.LoadService;
import deloitte.forecastsystem_bih.service.PartialInputDataHourlyCompleteService;
import deloitte.forecastsystem_bih.service.PartialInputDataHourlyStartService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;
import deloitte.forecastsystem_bih.service.TempLoadForecastArimaService;
import deloitte.forecastsystem_bih.service.TempLoadForecastSimilarDayService;
import deloitte.forecastsystem_bih.service.WeatherForecastDailyService;
import deloitte.forecastsystem_bih.service.WeatherForecastHourlyService;
import deloitte.forecastsystem_bih.service.WeatherForecastService;
import deloitte.forecastsystem_bih.service.WeatherService;
import deloitte.forecastsystem_bih.webscrapload.GrabWeatherData;

@Service("commandCenterService")
@Configurable
public class CommandCenter {
	
  @Autowired
  CountryService countryService;
  
  @Autowired
  LoadService loadService;
  
  @Autowired
  WeatherService weatherService;	
  	    
  @Autowired
  WeatherForecastService weatherForecastService;

  @Autowired
  WeatherForecastDailyService weatherForecastDailyService;    

  @Autowired
  WeatherForecastHourlyService weatherForecastHourlyService; 	  
  
  @Autowired 
  PreparedDataLoadHoursService preparedDataLoadHoursService;
	
  @Autowired
  ArimaModelService arimaModelService;	
	
  @Autowired
  LoadForecastArimaService loadForecastArimaService;	
  
  @Autowired
  SimilarDayService similarDayService;

  @Autowired 
  LoadForecastSimilarDayService loadForecastSimilarDayService; 		

  @Autowired
  TempLoadForecastArimaService tempLoadForecastArimaService;  
  
  @Autowired
  SimilarDayInputDataService similarDayInputDataService;
	
  @Autowired
  TempLoadForecastSimilarDayService tempLoadForecastSimilarDayService;	 
	
  @Autowired
  DataVectorHoursLoad dataVector;	 	
	
  @Autowired
  SystemForecastHoursLoad systemForecast;
	
  @Autowired
  HistoryLoadForecastService historyLoadForecastService;	  
  
  @Autowired
  PartialInputDataHourlyStartService partialInputDataHourlyStartService;
  
  @Autowired
  PartialInputDataHourlyCompleteService partialInputDataHourlyCompleteService;  
	
	public void runWeatherHistoryService() throws InterruptedException {
		
		  DateFormat dateFormatWeather = new SimpleDateFormat("yyyy-MM-dd");  

	      System.out.println("--- DELOITTE SOFTWARE ---");
	      System.out.println("--- WEBSCRAPPING WEATHER DATA ---");
	      
	      Country con = countryService.findById(2L);
	      System.out.println("Country: " + con.getName());      
	      
	      Calendar startDate = Calendar.getInstance();
	      startDate.setTime(weatherService.lastDate(con));
	      startDate.add(Calendar.DAY_OF_MONTH, 1);
	      startDate.set(Calendar.HOUR, 0);
	      startDate.set(Calendar.MINUTE, 0);
	      startDate.set(Calendar.MILLISECOND, 0);
	      
	      Calendar endDate = Calendar.getInstance();  
	      endDate.set(Calendar.HOUR, 0);
	      endDate.set(Calendar.MINUTE, 0);
	      endDate.set(Calendar.MILLISECOND, 0);
	      
	      long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
	      long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	      
	      for (int i=startDate.get(Calendar.DAY_OF_MONTH); i<diffDays+startDate.get(Calendar.DAY_OF_MONTH); i++) 
	      {   
	          Thread.sleep(1000); 
	          Date datum = new GregorianCalendar(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), i).getTime();
	          System.out.println("Date: " + datum);

	              GrabWeatherData gwd = new GrabWeatherData(con.getWeather());            
	              gwd.setDateWeather(dateFormatWeather.format(datum));
	              gwd.setCountry(con); 
	              gwd.webScrap();
	              for (Weather l : gwd.getWeatherDataList()){
	                  weatherService.save(l);
	              }      
	      }
	      
	      System.out.println("--- END WEBSCRAPPING WEATHER DATA ---");		  
		
	}
	
	public void runWeatherForecastService() throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); 
        Date datum= cal.getTime();
        
        System.out.println("--- DELOITTE SOFTWARE ---");
        System.out.println("--- WEBSCRAP SERVICE FORECAST WEATHER ---");
        System.out.println("Date: " + datum);        
        
        Country con = countryService.findById(2L);
        System.out.println("Country: " + con.getName());

            WeatherForecast wf = new WeatherForecast();        
            wf.setId(0L);
            wf.setCountry(con);
            wf.setForecastTime(datum);        
            wf = weatherForecastService.save(wf);            
            
            DateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");        

            ForecastIO fio = new ForecastIO("c4992b6d96bd9a53ca083c9c0fa9ae32");
            fio.setUnits(ForecastIO.UNITS_SI);
            fio.setLang(ForecastIO.LANG_ENGLISH);
            fio.getForecast(con.getLatitude().toString(), con.getLongitude().toString()); 
            System.out.println("Latitude: "+fio.getLatitude());
            System.out.println("Longitude: "+fio.getLongitude());
            System.out.println("Timezone: "+fio.getTimezone());              
            
            FIODaily daily = new FIODaily(fio);

            if(daily.days()<0)
                    System.out.println("No daily data.");
            else
                    System.out.println("Daily:");

            for(int i = 0; i<daily.days()-1; i++){
                    String [] h = daily.getDay(i).getFieldsArray();
                    
                    WeatherForecastDaily wfd = new WeatherForecastDaily();   
                    wfd.setWeatherForecast(wf);
                    wfd.setId(0L);
                    
                    for(int j=0; j<h.length; j++) {
                       
                    if (h[j].equals("windGust"))    
                       wfd.setWindGust(Double.valueOf(daily.getDay(i).getByKey(h[j]))); 
                    else if (h[j].equals("temperatureMax")) 
                         wfd.setTemperatureMax(Double.valueOf(daily.getDay(i).getByKey(h[j]))); 
                    else if (h[j].equals("windBearing")) 
                         wfd.setWindBearing(Double.valueOf(daily.getDay(i).getByKey(h[j]))); 
                    else if (h[j].equals("ozone")) 
                         wfd.setOzone(Double.valueOf(daily.getDay(i).getByKey(h[j])));
                    else if (h[j].equals("apparentTemperatureMin")) 
                         wfd.setApparentTemperatureMin(Double.valueOf(daily.getDay(i).getByKey(h[j])));
                    else if (h[j].equals("temperatureLow")) 
                         wfd.setTemperatureLow(Double.valueOf(daily.getDay(i).getByKey(h[j])));   
                    else if (h[j].equals("humidity")) 
                         wfd.setHumidity(Double.valueOf(daily.getDay(i).getByKey(h[j]))*100);              
                    else if (h[j].equals("windSpeed")) 
                         wfd.setWindSpeed(Double.valueOf(daily.getDay(i).getByKey(h[j])));    
                    else if (h[j].equals("apparentTemperatureLow")) 
                         wfd.setApparentTemperatureLow(Double.valueOf(daily.getDay(i).getByKey(h[j])));   
                    else if (h[j].equals("visibility")) 
                         wfd.setVisibility(Double.valueOf(daily.getDay(i).getByKey(h[j])));  
                    else if (h[j].equals("cloudCover")) 
                         wfd.setCloudCover(Double.valueOf(daily.getDay(i).getByKey(h[j])));     
                    else if (h[j].equals("temperatureMin")) 
                         wfd.setTemperatureMin(Double.valueOf(daily.getDay(i).getByKey(h[j])));  
                    else if (h[j].equals("pressure")) 
                         wfd.setPressure(Double.valueOf(daily.getDay(i).getByKey(h[j])));        
                    else if (h[j].equals("dewPoint")) 
                         wfd.setDewPoint(Double.valueOf(daily.getDay(i).getByKey(h[j]))); 
                    else if (h[j].equals("apparentTemperatureMax")) 
                         wfd.setApparentTemperatureMax(Double.valueOf(daily.getDay(i).getByKey(h[j])));   
                    else if (h[j].equals("temperatureHigh")) 
                         wfd.setTemperatureHigh(Double.valueOf(daily.getDay(i).getByKey(h[j])));     
                    else if (h[j].equals("apparentTemperatureHigh")) 
                         wfd.setApparentTemperatureHigh(Double.valueOf(daily.getDay(i).getByKey(h[j])));                    
                    else if (h[j].equals("time")) 
                         wfd.setDayForecast(formatter.parse(daily.getDay(i).getByKey(h[j])));
                    else if (h[j].equals("uvIndex")) 
                         wfd.setUvIndex(Double.valueOf(daily.getDay(i).getByKey(h[j])));   
                    
                    }  
                    weatherForecastDailyService.save(wfd);                    
            }

            FIOHourly hourly = new FIOHourly(fio);

            if(hourly.hours()<0)
                    System.out.println("No hourly data.");
            else
                    System.out.println("Hourly:");
            //Print hourly data
            for(int i = 0; i<hourly.hours(); i++){
                    String [] h = hourly.getHour(i).getFieldsArray();

                    WeatherForecastHourly wfh = new WeatherForecastHourly(); 
                    wfh.setWeatherForecast(wf);
                    wfh.setHourForecast(i+1);
                    wfh.setId(0L); 
                    
                    for(int j=0; j<h.length; j++) {
                    	
                        if (h[j].equals("windGust"))
                            wfh.setWindGust(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("visibility"))
                            wfh.setVisibility(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("cloudCover"))
                            wfh.setCloudCover(Double.valueOf(hourly.getHour(i).getByKey(h[j])));  
                        else if (h[j].equals("windBearing"))
                            wfh.setWindBearing(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("apparentTemperature"))                        
                            wfh.setApparentTemperature(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("pressure"))                        
                            wfh.setPressure(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("dewPoint"))                        
                            wfh.setDewPoint(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("ozone"))                        
                            wfh.setOzone(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("temperature"))                         
                            wfh.setTemperature(Double.valueOf(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("humidity"))                         
                            wfh.setHumidity(Double.valueOf(hourly.getHour(i).getByKey(h[j]))*100);     
                        else if (h[j].equals("time")) 
                            wfh.setDayForecast(formatter.parse(hourly.getHour(i).getByKey(h[j])));
                        else if (h[j].equals("windSpeed"))                         
                            wfh.setWindSpeed(Double.valueOf(hourly.getHour(i).getByKey(h[j])));      
                        else if (h[j].equals("uvIndex"))                         
                            wfh.setUvIndex(Double.valueOf(hourly.getHour(i).getByKey(h[j])));                         
                    }                                 
                    weatherForecastHourlyService.save(wfh);                
            }            
          
        System.out.println("--- END WEBSCRAP SERVICE FORECAST WEATHER ---");	
		
	}
	
	public void runPartialArimaService() {
		
		System.out.println("--- DELOITTE SOFTWARE ---");
		System.out.println("--- PARTIAL ARIMA SERVICE ---");
		
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
		
		System.out.println("--- END PARTIAL ARIMA SERVICE ---");		
		
	}
	
	public void runPartialSimilarDayService() {
		
		System.out.println("--- PARTIAL SIMILAR DAY SERVICE ---");
		
		Country con = countryService.findById(2L);			
		LoadForecastSimilarDay lfsd = new LoadForecastSimilarDay();
				
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
		
		for (Long number = startId; number <= endId; number++) {
		
		PreparedDataLoadHours recData = preparedDataLoadHoursService.findById(number).get();
		
		similarDayService.set(con, startPos);
		startPos++;
		
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
		
		System.out.println("--- END PARTIAL SIMILAR DAY SERVICE ---");			
		
	}
	
	public void runArimaForecastService() {
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--- ARIMA FORECAST SERVICE- --");
		
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
		
        System.out.println("-- END ARIMA FORECAST SERVICE ---");		
		
	}
	
	public void runSimilarDayTodayService() {
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--- SIMILAR DAY FORECAST TODAY SERVICE ---");		
		
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

        System.out.println("--- END SIMILAR DAY FORECAST TODAY SERVICE ---");		
		
	}
	
	public void runLoadForecastTodayService() {
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--- LOAD FORECAST TODAY SERVICE ---");		
			
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
            System.out.println("--- END LOAD FORECAST TODAY SERVICE ---");
		
		
	}
	
	public void runSimilarDayTomorrowService() {
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--- SIMILAR DAY FORECAST TOMORROW SERVICE ---");				
		
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
        c.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println("SimilarDay Forecast for Date: " + c.getTime());		
		
		similarDayService.set(con, Long.valueOf(res_dan.length-1));
		similarDayService.normalizeData();
		
		similarDayInputDataService.prepareInputDataForTomorrow(c.getTime(), con);		
		
		for (int i=0; i<24; i++) {
			
			TempLoadForecastSimilarDay lfsd = new TempLoadForecastSimilarDay();		
			similarDayService.set(con, Long.valueOf(res_dan.length-1));
			similarDayService.calculateDistance(similarDayInputDataService.getInputDataForTomorrow()[i]);
			 			
			lfsd.setCountry(con);
			lfsd.setId(0L);
			lfsd.setForecastDate(cForecastToday.getTime());
			lfsd.setLoadDate(c.getTime());
			lfsd.setLoadForecastSimilarDay(similarDayService.getForecast()); 
			lfsd.setLoadHour(i);
			lfsd.setLoadMinute(0); 			
			tempLoadForecastSimilarDayService.save(lfsd);
			
		}

        System.out.println("--- END ---");			
		
	}
	
	public void runLoadForecastTomorrowService() {
		
		System.out.println("--- DELOITTE  FORECAST ---");
		System.out.println("--- LOAD FORECAST TOMORROW SERVICE ---");				
		
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

		Calendar cTomorrow = Calendar.getInstance();
		cTomorrow.set(res_god[res_god.length-1], res_mes[res_mes.length-1]-1, res_dan[res_dan.length-1], 0, 0, 0);	
		cTomorrow.add(Calendar.DAY_OF_MONTH, 2);		
		
        System.out.println("LoadForecastTomorrow for Date: " + cTomorrow.getTime());	
        
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
    		historyLoadForecast.setLoadDate(cTomorrow.getTime());
    		historyLoadForecast.setLoadForecastData(nn.predict(dataVector.getPreparedDataTomorrow()));   
    		historyLoadForecast.setLoadHour(i);
    		historyLoadForecast.setLoadMinute(0);    
    		
    		historyLoadForecastService.save(historyLoadForecast); 
    	}
            System.out.println("--- END LOAD FORECAST TOMORROW SERVICE ---");  		
		
	}

	public void runPreparePartialInputDataHourlyStart() {
		
		List<PartialInputDataHourlyStart> listData = partialInputDataHourlyStartService.findAll();
		
		for (PartialInputDataHourlyStart rec : listData) {
			
			PreparedDataLoadHours sRec = new PreparedDataLoadHours();
			
			sRec.setId(0L); 
			sRec.setCountry(countryService.findById(rec.getCountryFk())); 
			sRec.setDan(rec.getDan());
			sRec.setMesec(rec.getMesec());
			sRec.setGodina(rec.getGodina());
			sRec.setLoadHour(rec.getLoadHour());
			sRec.setHoliday(rec.getHoliday());
			sRec.setTipDana(rec.getTipDana());
			
			sRec.setAvgDewPoint(rec.getAvgDewPoint());
			sRec.setAvgDewPoint2(rec.getAvgDewPoint3());
			sRec.setAvgDewPoint3(rec.getAvgDewPoint3());
			sRec.setAvgDewPoint4(rec.getAvgDewPoint3());
			
			sRec.setAvgFeelslike(rec.getAvgFeelslike());
			sRec.setAvgFeelslike2(rec.getAvgFeelslike2());
			sRec.setAvgFeelslike3(rec.getAvgFeelslike3());
			sRec.setAvgFeelslike4(rec.getAvgFeelslike4());
			
			sRec.setAvgTemperature(rec.getAvgTemperature());
			sRec.setAvgTemperature2(rec.getAvgTemperature2());
			sRec.setAvgTemperature3(rec.getAvgTemperature3());
			sRec.setAvgTemperature4(rec.getAvgTemperature4());
			
			sRec.setAvgHumidity(rec.getAvgHumidity());
			sRec.setAvgHumidity2(rec.getAvgHumidity2());
			sRec.setAvgHumidity3(rec.getAvgHumidity3());
			sRec.setAvgHumidity4(rec.getAvgHumidity4());
			
			sRec.setAvgLoadRealData(rec.getAvgLoadRealData());
			sRec.setAvgLoadRealData2(rec.getAvgLoadRealData2());
			sRec.setAvgLoadRealData3(rec.getAvgLoadRealData3());
			sRec.setAvgLoadRealData4(rec.getAvgLoadRealData4());
			
			sRec.setAvgPressure(rec.getAvgPressure());
			sRec.setAvgPressure2(rec.getAvgPressure2());
			sRec.setAvgPressure3(rec.getAvgPressure3());
			sRec.setAvgPressure4(rec.getAvgPressure4());
			
			sRec.setAvgWind(rec.getAvgWind());
			sRec.setAvgWind2(rec.getAvgWind2());
			sRec.setAvgWind3(rec.getAvgWind3());
			sRec.setAvgWind4(rec.getAvgWind4());
			
			sRec.setAvgLoadForecastArima(rec.getAvgLoadForecastArima());
			sRec.setAvgLoadForecastArima2(rec.getAvgLoadForecastArima2());
			sRec.setAvgLoadForecastArima3(rec.getAvgLoadForecastArima3());
			sRec.setAvgLoadForecastArima4(rec.getAvgLoadForecastArima4());
			
			sRec.setAvgLoadForecastSimilarDay(rec.getAvgLoadForecastSimilarDay());
			sRec.setAvgLoadForecastSimilarDay2(rec.getAvgLoadForecastSimilarDay2());
			sRec.setAvgLoadForecastSimilarDay3(rec.getAvgLoadForecastSimilarDay3());
			sRec.setAvgLoadForecastSimilarDay4(rec.getAvgLoadForecastSimilarDay4());
			
			preparedDataLoadHoursService.save(sRec);
		}
		
	}
	
	public void runPreparePartialInputDataHourlyComplete() {
		
		// delete start data		
		List<PreparedDataLoadHours> oldData = preparedDataLoadHoursService.getPartialData(countryService.findById(2L)); 
		
		for (PreparedDataLoadHours oldRec : oldData) {
			preparedDataLoadHoursService.delete(oldRec); 
		}
		
		List<PartialInputDataHourlyComplete> listData = partialInputDataHourlyCompleteService.findAll();
		
		for (PartialInputDataHourlyComplete rec : listData) {
			
			PreparedDataLoadHours sRec = new PreparedDataLoadHours();
			
			sRec.setId(0L); 
			sRec.setCountry(countryService.findById(rec.getCountryFk())); 
			sRec.setDan(rec.getDan());
			sRec.setMesec(rec.getMesec());
			sRec.setGodina(rec.getGodina());
			sRec.setLoadHour(rec.getLoadHour());
			sRec.setHoliday(rec.getHoliday());
			sRec.setTipDana(rec.getTipDana());
			
			sRec.setAvgDewPoint(rec.getAvgDewPoint());
			sRec.setAvgDewPoint2(rec.getAvgDewPoint3());
			sRec.setAvgDewPoint3(rec.getAvgDewPoint3());
			sRec.setAvgDewPoint4(rec.getAvgDewPoint3());
			
			sRec.setAvgFeelslike(rec.getAvgFeelslike());
			sRec.setAvgFeelslike2(rec.getAvgFeelslike2());
			sRec.setAvgFeelslike3(rec.getAvgFeelslike3());
			sRec.setAvgFeelslike4(rec.getAvgFeelslike4());
			
			sRec.setAvgTemperature(rec.getAvgTemperature());
			sRec.setAvgTemperature2(rec.getAvgTemperature2());
			sRec.setAvgTemperature3(rec.getAvgTemperature3());
			sRec.setAvgTemperature4(rec.getAvgTemperature4());
			
			sRec.setAvgHumidity(rec.getAvgHumidity());
			sRec.setAvgHumidity2(rec.getAvgHumidity2());
			sRec.setAvgHumidity3(rec.getAvgHumidity3());
			sRec.setAvgHumidity4(rec.getAvgHumidity4());
			
			sRec.setAvgLoadRealData(rec.getAvgLoadRealData());
			sRec.setAvgLoadRealData2(rec.getAvgLoadRealData2());
			sRec.setAvgLoadRealData3(rec.getAvgLoadRealData3());
			sRec.setAvgLoadRealData4(rec.getAvgLoadRealData4());
			
			sRec.setAvgPressure(rec.getAvgPressure());
			sRec.setAvgPressure2(rec.getAvgPressure2());
			sRec.setAvgPressure3(rec.getAvgPressure3());
			sRec.setAvgPressure4(rec.getAvgPressure4());
			
			sRec.setAvgWind(rec.getAvgWind());
			sRec.setAvgWind2(rec.getAvgWind2());
			sRec.setAvgWind3(rec.getAvgWind3());
			sRec.setAvgWind4(rec.getAvgWind4());
			
			sRec.setAvgLoadForecastArima(rec.getAvgLoadForecastArima());
			sRec.setAvgLoadForecastArima2(rec.getAvgLoadForecastArima2());
			sRec.setAvgLoadForecastArima3(rec.getAvgLoadForecastArima3());
			sRec.setAvgLoadForecastArima4(rec.getAvgLoadForecastArima4());
			
			sRec.setAvgLoadForecastSimilarDay(rec.getAvgLoadForecastSimilarDay());
			sRec.setAvgLoadForecastSimilarDay2(rec.getAvgLoadForecastSimilarDay2());
			sRec.setAvgLoadForecastSimilarDay3(rec.getAvgLoadForecastSimilarDay3());
			sRec.setAvgLoadForecastSimilarDay4(rec.getAvgLoadForecastSimilarDay4());
			
			preparedDataLoadHoursService.save(sRec);
		}				
		
	}
}
