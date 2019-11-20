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
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Temporal;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "df_weather_forecast")
public class WeatherForecast implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7952196742050689467L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;
        
    @Column(name = "Forecast_time", columnDefinition = "DATE")
    private Date forecastTime;

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
     * @return the forecastTime
     */
    public Date getForecastTime() {
        return forecastTime;
    }

    /**
     * @param forecastTime the forecastTime to set
     */
    public void setForecastTime(Date forecastTime) {
        this.forecastTime = forecastTime;
    }
    
    
    
}
