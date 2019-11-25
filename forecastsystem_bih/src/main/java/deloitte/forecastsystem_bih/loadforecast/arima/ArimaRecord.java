package deloitte.forecastsystem_bih.loadforecast.arima;

import java.util.Calendar;
import java.util.Date;

public class ArimaRecord {
	
	Date loadDate;
	Integer loadHour;
	Integer loadMinute;
	Double loadForecastArima;
	Date forecastDate;
	
	public ArimaRecord() {
		// TODO Auto-generated constructor stub
	}	

	public ArimaRecord(Date loadDate, Integer loadHour, Date forecastDate) {
		// TODO Auto-generated constructor stub
		this.loadDate = loadDate;
		this.loadHour = loadHour;
		this.loadMinute = 0;
		this.loadForecastArima = 0.0;
		this.forecastDate = forecastDate;
	}	
	
	public void addHourForecast(Double loadForecastArima) {		
        // convert date to calendar
//        Calendar c = Calendar.getInstance();
//        c.setTime(loadDate);
//
//        this.loadHour++;
//        if (this.loadHour == 24) {
//            	this.loadHour = 0;
//		        c.add(Calendar.DATE, 1);
//		        loadDate = c.getTime();            	
//        }        
        this.loadForecastArima = loadForecastArima;		
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public Integer getLoadHour() {
		return loadHour;
	}

	public void setLoadHour(Integer loadHour) {
		this.loadHour = loadHour;
	}

	public Integer getLoadMinute() {
		return loadMinute;
	}

	public void setLoadMinute(Integer loadMinute) {
		this.loadMinute = loadMinute;
	}

	public Double getLoadForecastArima() {
		return loadForecastArima;
	}

	public void setLoadForecastArima(Double loadForecastArima) {
		this.loadForecastArima = loadForecastArima;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}
	
	

}
