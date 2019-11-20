/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.model;

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
@Table(name = "df_weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;
    
    @Column(name = "Weather_date")
    private Date weatherDate;      
    
    @Column(name = "Hour")
    private Integer weatherHour;        

    @Column(name = "Minute")
    private Integer weatherMinute;  
    
    @Column(name = "Temperature")
    private Double temperature;   
    
    @Column(name = "Feelslike")
    private Double feelslike;
    
    @Column(name = "Wind")
    private Double wind;  
    
    @Column(name = "Humidity")
    private Double humidity;    
    
    @Column(name = "Dew_point")
    private Double dewPoint; 
    
    @Column(name = "Pressure")
    private Double pressure;  

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
     * @return the weatherDate
     */
    public Date getWeatherDate() {
        return weatherDate;
    }

    /**
     * @param weatherDate the weatherDate to set
     */
    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

    /**
     * @return the weatherHour
     */
    public Integer getWeatherHour() {
        return weatherHour;
    }

    /**
     * @param weatherHour the weatherHour to set
     */
    public void setWeatherHour(Integer weatherHour) {
        this.weatherHour = weatherHour;
    }

    /**
     * @return the weatherMinute
     */
    public Integer getWeatherMinute() {
        return weatherMinute;
    }

    /**
     * @param weatherMinute the weatherMinute to set
     */
    public void setWeatherMinute(Integer weatherMinute) {
        this.weatherMinute = weatherMinute;
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
     * @return the feelslike
     */
    public Double getFeelslike() {
        return feelslike;
    }

    /**
     * @param feelslike the feelslike to set
     */
    public void setFeelslike(Double feelslike) {
        this.feelslike = feelslike;
    }

    /**
     * @return the wind
     */
    public Double getWind() {
        return wind;
    }

    /**
     * @param wind the wind to set
     */
    public void setWind(Double wind) {
        this.wind = wind;
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
}
