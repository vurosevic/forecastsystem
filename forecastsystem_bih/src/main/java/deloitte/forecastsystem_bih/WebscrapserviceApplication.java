package deloitte.forecastsystem_bih;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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

@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class WebscrapserviceApplication implements CommandLineRunner {

  @Autowired
  CountryService countryService;
  
  @Autowired
  LoadService loadService;
  
  @Autowired
  WeatherService weatherService;
  
  DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
  DateFormat dateFormatWeather = new SimpleDateFormat("yyyy-MM-dd");  
  
  public static void main(String[] args) {
          SpringApplication.run(WebscrapserviceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
      
      System.out.println("--- DELOITTE SOFTWARE ---");
      System.out.println("--- WEBSCRAPPING WEATHER DATA ---");
      
      for (int i=1; i<1760; i++) 
      {   
          Thread.sleep(1000); 
          Date datum = new GregorianCalendar(2015, 0, i).getTime();
          System.out.println("Datum: " + datum);

          //for (Country con : countryService.findAll()){
          Country con = countryService.findById(2L);
              System.out.println("Country: " + con.getName());
              GrabWeatherData gwd = new GrabWeatherData(con.getWeather());            
              gwd.setDateWeather(dateFormatWeather.format(datum));
              gwd.setCountry(con); 
              gwd.webScrap();
              for (Weather l : gwd.getWeatherDataList()){
                  weatherService.save(l);
              }
          //}        
      }
      
      System.out.println("--- END ---");


  }
}
