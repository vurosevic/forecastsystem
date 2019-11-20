/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "df_weather_forecast_daily")
public class WeatherForecastDaily implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 745810886439138864L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Weather_forecast_fk")
    private WeatherForecast weatherForecast;
    
    @Column(name = "Apparent_temperature_min")
    private Double apparentTemperatureMin;
    
    @Column(name = "Apparent_temperature_max")
    private Double apparentTemperatureMax;    
    
    @Column(name = "Apparent_temperature_low")
    private Double apparentTemperatureLow;    
    
    @Column(name = "Apparent_temperature_high")
    private Double apparentTemperatureHigh;
    
    @Column(name = "Temperature_min")
    private Double temperatureMin;
    
    @Column(name = "Temperature_max")
    private Double temperatureMax;    
    
    @Column(name = "Temperature_low")
    private Double temperatureLow;    
    
    @Column(name = "Temperature_high")
    private Double temperatureHigh;    

    @Column(name = "Visibility")
    private Double visibility;      

    @Column(name = "Wind_gust")
    private Double windGust;          

    @Column(name = "Cloud_cover")
    private Double cloudCover;

    @Column(name = "Wind_bearing")
    private Double windBearing;

    @Column(name = "Pressure")
    private Double pressure;

    @Column(name = "Dew_point")
    private Double dewPoint;
    
    @Column(name = "Ozone")
    private Double ozone;
    
    @Column(name = "Humidity")
    private Double humidity;    

    @Column(name = "Wind_speed")
    private Double windSpeed;    

    @Column(name = "Uv_index")
    private Double uvIndex;    
    
    @Column(name = "Day_forecast")
    private Date dayForecast;    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the weatherForecast
     */
    public WeatherForecast getWeatherForecast() {
        return weatherForecast;
    }

    /**
     * @param weatherForecast the weatherForecast to set
     */
    public void setWeatherForecast(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    /**
     * @return the apparentTemperatureMin
     */
    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    /**
     * @param apparentTemperatureMin the apparentTemperatureMin to set
     */
    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    /**
     * @return the apparentTemperatureMax
     */
    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    /**
     * @param apparentTemperatureMax the apparentTemperatureMax to set
     */
    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    /**
     * @return the apparentTemperatureLow
     */
    public Double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    /**
     * @param apparentTemperatureLow the apparentTemperatureLow to set
     */
    public void setApparentTemperatureLow(Double apparentTemperatureLow) {
        this.apparentTemperatureLow = apparentTemperatureLow;
    }

    /**
     * @return the apparentTemperatureHigh
     */
    public Double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    /**
     * @param apparentTemperatureHigh the apparentTemperatureHigh to set
     */
    public void setApparentTemperatureHigh(Double apparentTemperatureHigh) {
        this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    /**
     * @return the temperatureMin
     */
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * @param temperatureMin the temperatureMin to set
     */
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    /**
     * @return the temperatureMax
     */
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * @param temperatureMax the temperatureMax to set
     */
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    /**
     * @return the temperatureLow
     */
    public Double getTemperatureLow() {
        return temperatureLow;
    }

    /**
     * @param temperatureLow the temperatureLow to set
     */
    public void setTemperatureLow(Double temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    /**
     * @return the temperatureHigh
     */
    public Double getTemperatureHigh() {
        return temperatureHigh;
    }

    /**
     * @param temperatureHigh the temperatureHigh to set
     */
    public void setTemperatureHigh(Double temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    /**
     * @return the visibility
     */
    public Double getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the windGust
     */
    public Double getWindGust() {
        return windGust;
    }

    /**
     * @param windGust the windGust to set
     */
    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    /**
     * @return the cloudCover
     */
    public Double getCloudCover() {
        return cloudCover;
    }

    /**
     * @param cloudCover the cloudCover to set
     */
    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    /**
     * @return the windBearing
     */
    public Double getWindBearing() {
        return windBearing;
    }

    /**
     * @param windBearing the windBearing to set
     */
    public void setWindBearing(Double windBearing) {
        this.windBearing = windBearing;
    }

    /**
     * @return the pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the dewPoint
     */
    public Double getDewPoint() {
        return dewPoint;
    }

    /**
     * @param dewPoint the dewPoint to set
     */
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    /**
     * @return the ozone
     */
    public Double getOzone() {
        return ozone;
    }

    /**
     * @param ozone the ozone to set
     */
    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    /**
     * @return the humidity
     */
    public Double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the windSpeed
     */
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the uvIndex
     */
    public Double getUvIndex() {
        return uvIndex;
    }

    /**
     * @param uvIndex the uvIndex to set
     */
    public void setUvIndex(Double uvIndex) {
        this.uvIndex = uvIndex;
    }

    /**
     * @return the dayForecast
     */
    public Date getDayForecast() {
        return dayForecast;
    }

    /**
     * @param dayForecast the dayForecast to set
     */
    public void setDayForecast(Date dayForecast) {
        this.dayForecast = dayForecast;
    }



}
