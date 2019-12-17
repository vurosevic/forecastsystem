package deloitte.forecastsystem_bih;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastDaily;
import deloitte.forecastsystem_bih.model.WeatherForecastHourly;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.WeatherForecastDailyService;
import deloitte.forecastsystem_bih.service.WeatherForecastHourlyService;
import deloitte.forecastsystem_bih.service.WeatherForecastService;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class WebscrapserviceForecastWeather implements CommandLineRunner {
	
    @Autowired
    CountryService countryService;
    
    @Autowired
    WeatherForecastService weatherForecastService;
    
    @Autowired
    WeatherForecastDailyService weatherForecastDailyService;    

    @Autowired
    WeatherForecastHourlyService weatherForecastHourlyService; 
    
    public static void main(String[] args) {
        SpringApplication.run(WebscrapserviceForecastWeather.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); 
        //cal.add(Calendar.DAY_OF_YEAR,-1);
        Date datum= cal.getTime();
        
        System.out.println("------------------------------------");
        System.out.println("DELOITTE SOFTWARE");
        System.out.println("WEBSCRAP SERVICE FORECAST WEATHER");
        System.out.println("------------------------------------");
        System.out.println("DATE: " + datum);        
        
//        for (Country con : countryService.findAll()){
//        	Thread.sleep(1000);
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
            //In case there is no daily data available
            if(daily.days()<0)
                    System.out.println("No daily data.");
            else
                    System.out.println("Daily:");
            //Print daily data
            for(int i = 0; i<daily.days()-1; i++){
                    String [] h = daily.getDay(i).getFieldsArray();
                    
                    WeatherForecastDaily wfd = new WeatherForecastDaily();   
                    wfd.setWeatherForecast(wf);
                    wfd.setId(0L);
                    
                    for(int j=0; j<h.length; j++) {
			//System.out.println(h[j]+": "  + " Broj: " + j + ", " +daily.getDay(i).getByKey(h[j]));
                        
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
            //In case there is no hourly data available
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
			//System.out.println(h[j]+": " + " Broj: " + j + ", " +hourly.getHour(i).getByKey(h[j]));
                        
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
            
//        }   
          
        System.out.println("------------------------------------");
        System.out.println("END.");
        System.out.println("------------------------------------");		
		
		
	}    

}
