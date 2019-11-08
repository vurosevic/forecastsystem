package com.deloitte.forecastsystem.webscrapload;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.Load;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class GrabLoadData {
	 
    private String dateLoad;
    private String rootUrl;
    private Country country;
    
    private List<Load> loadDataList;

    public GrabLoadData() {
        loadDataList = new ArrayList<>();
        loadDataList.clear();
    }

    public GrabLoadData(String rootUrl) {
        loadDataList = new ArrayList<>();
        loadDataList.clear();
        this.rootUrl = rootUrl;
    }
    
    public void webScrap(){
       
       rootUrl = rootUrl.replaceAll("###", dateLoad);               
       WebClient client = new WebClient();  
       client.getOptions().setCssEnabled(false);  
       client.getOptions().setJavaScriptEnabled(false);  
       HtmlDivision dvData; 
       HtmlElement table;
       try {  
         HtmlPage page = client.getPage(this.rootUrl);   
         List<HtmlTable> tabele = (List<HtmlTable>) (List<?>) page.getByXPath( "//table[contains(@class, 'data-view-table')]");
        if(tabele == null){  
          System.out.println("No items found !");
        }else{            
            List<HtmlTableRow> rts = tabele.get(0).getRows();
            int pom = 0;
            for (HtmlTableRow rt : rts){
                Load ld = new Load();
                pom++;
                if (pom>3){                
                    try {
                    ld.setLoadDate(new SimpleDateFormat("dd.MM.yyyy").parse(getDateLoad()));
                    ld.setLoadHour(Integer.parseInt(rt.getCell(0).asText().substring(0, 2)));
                    ld.setLoadForecatEntsoe(Integer.parseInt(rt.getCell(1).asText()));
                    try {
                    ld.setLoadRealData(Integer.parseInt(rt.getCell(2).asText()));
                    } catch (Exception e) {
                        ld.setLoadRealData(0);
                    }
                    ld.setLoadMinute(Integer.parseInt(rt.getCell(0).asText().substring(3, 5))); 
                    ld.setCountry(country); 
                    ld.setId(0L);
                    getLoadDataList().add(ld);
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
     * @return the dateLoad
     */
    public String getDateLoad() {
        return dateLoad;
    }

    /**
     * @param dateLoad the dateLoad to set
     */
    public void setDateLoad(String dateLoad) {
        this.dateLoad = dateLoad;
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
     * @return the loadDataList
     */
    public List<Load> getLoadDataList() {
        return loadDataList;
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
    
    
}

