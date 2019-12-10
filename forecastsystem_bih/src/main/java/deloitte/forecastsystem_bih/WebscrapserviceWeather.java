package deloitte.forecastsystem_bih;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Weather;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.LoadService;
import deloitte.forecastsystem_bih.service.WeatherService;
import deloitte.forecastsystem_bih.webscrapload.GrabWeatherData;

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class WebscrapserviceWeather implements CommandLineRunner {

  @Autowired
  CountryService countryService;
  
  @Autowired
  LoadService loadService;
  
  @Autowired
  WeatherService weatherService;
  
  DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
  DateFormat dateFormatWeather = new SimpleDateFormat("yyyy-MM-dd");  
  
  public static void main(String[] args) {
          SpringApplication.run(WebscrapserviceWeather.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
      
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
      
      System.out.println("--- END ---");


  }
}
