package deloitte.forecastsystem_bih.webscrapload;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Weather;

/**
*
* @author Vladimir
*/
public class GrabWeatherData {
   
   private String dateWeather;
   private String rootUrl;
   private Country country;
   
   private List<Weather> weatherDataList;  

   public GrabWeatherData() {
       weatherDataList = new ArrayList<>();
       weatherDataList.clear();       
   }
   
   public GrabWeatherData(String rootUrl) {
       weatherDataList = new ArrayList<>();
       weatherDataList.clear();  
       this.rootUrl = rootUrl;        
   }    
   
   public void webScrap(){
      
      setRootUrl(getRootUrl().replaceAll("###", getDateWeather()));               
      WebClient client = new WebClient();  
      client.getOptions().setCssEnabled(false);  
      client.getOptions().setJavaScriptEnabled(false);  
      HtmlDivision dvData; 
      HtmlElement table;
      try {  
        HtmlPage page = client.getPage(this.getRootUrl());   
        List<HtmlTable> tabele = (List<HtmlTable>) (List<?>) page.getByXPath( "//table[contains(@class, 'daily-history')]");
       if(tabele == null){  
         System.out.println("No items found !");
       }else{            
           List<HtmlTableRow> rts = tabele.get(0).getRows();
           int pom = 0;
           for (HtmlTableRow rt : rts){
               Weather ld = new Weather();
               pom++;
               if (pom>1){                
                   try {
                   ld.setWeatherDate(new SimpleDateFormat("yyyy-MM-dd").parse(getDateWeather()));
                   ld.setWeatherHour(Integer.parseInt(rt.getCell(0).asText().substring(0, 2)));
                   ld.setWeatherMinute(Integer.parseInt(rt.getCell(0).asText().substring(3, 5))); 
                   String temp = rt.getCell(1).asText();
                   ld.setTemperature(Double.parseDouble(temp.substring(0, temp.length()-2)));   
                   String feelslike = rt.getCell(2).asText();
                   ld.setFeelslike(Double.parseDouble(feelslike.substring(0, feelslike.length()-2)));  
                   String wind = rt.getCell(3).asText();
                   if (wind.split("\r\n").length>1)
                    ld.setWind(Double.parseDouble(wind.split("\r\n")[2].substring(0, wind.split("\r\n")[2].length()-5)));
                   else if (wind.split(" ").length>2)
                    ld.setWind(Double.parseDouble(wind.split(" ")[2]));    
                   else // bez vetra
                    ld.setWind(0.0);      
                   
                   String humid = rt.getCell(5).asText();
                   ld.setHumidity(Double.parseDouble(humid.substring(0, humid.length()-1))); 
                   String dew = rt.getCell(6).asText();
                   ld.setDewPoint(Double.parseDouble(dew.substring(0, dew.length()-2))); 
                   String pressure = rt.getCell(7).asText();
                   ld.setPressure(Double.parseDouble(pressure.substring(0, pressure.length()-4)));                                                             
                   ld.setCountry(getCountry()); 
                   ld.setId(0L);
                   getWeatherDataList().add(ld);
                   } catch (Exception ex) {
                       System.out.println(ex.getMessage());
                   };
               }
           }        
       }
      }catch(Exception e){
        e.printStackTrace();
      }       
       
       
   }    

   /**
    * @return the dateWeather
    */
   public String getDateWeather() {
       return dateWeather;
   }

   /**
    * @param dateWeather the dateWeather to set
    */
   public void setDateWeather(String dateWeather) {
       this.dateWeather = dateWeather;
   }

   /**
    * @return the rootUrl
    */
   public String getRootUrl() {
       return rootUrl;
   }

   /**
    * @param rootUrl the rootUrl to set
    */
   public void setRootUrl(String rootUrl) {
       this.rootUrl = rootUrl;
   }

   /**
    * @return the country
    */
   public Country getCountry() {
       return country;
   }

   /**
    * @param country the country to set
    */
   public void setCountry(Country country) {
       this.country = country;
   }

   /**
    * @return the weatherDataList
    */
   public List<Weather> getWeatherDataList() {
       return weatherDataList;
   }

   /**
    * @param weatherDataList the weatherDataList to set
    */
   public void setWeatherDataList(List<Weather> weatherDataList) {
       this.weatherDataList = weatherDataList;
   }
   
}

