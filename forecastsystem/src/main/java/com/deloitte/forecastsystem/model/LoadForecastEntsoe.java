/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.model;

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
@Table(name = "df_load_forecast_entsoe")
public class LoadForecastEntsoe implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1857637642189987102L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;
    
    @Column(name = "Load_date")
    private Date loadDate;    
    
    @Column(name = "Load_hour")
    private Integer loadHour;  
    
    @Column(name = "Load_minute")
    private Integer loadMinute; 

    @Column(name = "Load_forecast_entsoe")
    private Integer loadForecastEntsoe;     

    @Column(name = "Date_of_forecast")
    private Date dateOfForecast;            
    
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
     * @return the loadDate
     */
    public Date getLoadDate() {
        return loadDate;
    }

    /**
     * @param loadDate the loadDate to set
     */
    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    /**
     * @return the loadHour
     */
    public Integer getLoadHour() {
        return loadHour;
    }

    /**
     * @param loadHour the loadHour to set
     */
    public void setLoadHour(Integer loadHour) {
        this.loadHour = loadHour;
    }

    /**
     * @return the loadMinute
     */
    public Integer getLoadMinute() {
        return loadMinute;
    }

    /**
     * @param loadMinute the loadMinute to set
     */
    public void setLoadMinute(Integer loadMinute) {
        this.loadMinute = loadMinute;
    }

    /**
     * @return the loadForecastEntsoe
     */
    public Integer getLoadForecastEntsoe() {
        return loadForecastEntsoe;
    }

    /**
     * @param loadForecastEntsoe the loadForecastEntsoe to set
     */
    public void setLoadForecastEntsoe(Integer loadForecastEntsoe) {
        this.loadForecastEntsoe = loadForecastEntsoe;
    }

    /**
     * @return the dateOfForecast
     */
    public Date getDateOfForecast() {
        return dateOfForecast;
    }

    /**
     * @param dateOfForecast the dateOfForecast to set
     */
    public void setDateOfForecast(Date dateOfForecast) {
        this.dateOfForecast = dateOfForecast;
    }
    
    
}
