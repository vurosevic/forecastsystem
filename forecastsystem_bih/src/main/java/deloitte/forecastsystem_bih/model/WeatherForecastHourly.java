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
@Table(name = "df_weather_forecast_hourly")
public class WeatherForecastHourly implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8315318007598153853L;

	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Weather_forecast_fk")
    private WeatherForecast weatherForecast;
 
    @Column(name = "Hour_forecast")
    private Integer hourForecast;
    
    @Column(name = "Visibility")
    private Double visibility;      

    @Column(name = "Wind_gust")
    private Double windGust;          

    @Column(name = "Cloud_cover")
    private Double cloudCover;

    @Column(name = "Wind_bearing")
    private Double windBearing;    

    @Column(name = "Apparent_temperature")
    private Double apparentTemperature;

    @Column(name = "Pressure")
    private Double pressure;    
    
    @Column(name = "Dew_point")
    private Double dewPoint;

    @Column(name = "Ozone")
    private Double ozone;

    @Column(name = "Temperature")
    private Double temperature;
    
    @Column(name = "Humidity")
    private Double humidity;    

    @Column(name = "Day_forecast")
    private Date dayForecast;    

    @Column(name = "Wind_speed")
    private Double windSpeed;    

    @Column(name = "Uv_index")
    private Double uvIndex;    

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
     * @return the hourForecast
     */
    public Integer getHourForecast() {
        return hourForecast;
    }

    /**
     * @param hourForecast the hourForecast to set
     */
    public void setHourForecast(Integer hourForecast) {
        this.hourForecast = hourForecast;
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
     * @return the apparentTemperature
     */
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    /**
     * @param apparentTemperature the apparentTemperature to set
     */
    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
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
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
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

    
}
