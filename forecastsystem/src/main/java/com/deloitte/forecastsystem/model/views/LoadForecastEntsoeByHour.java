package com.deloitte.forecastsystem.model.views;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.deloitte.forecastsystem.model.Country;

@Entity
@Table(name="vw_load_forecast_entsoe")
public class LoadForecastEntsoeByHour {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;
    
    @Column(name = "Load_date")
    private Date loadDate;    
    
    @Column(name = "Load_hour")
    private Integer loadHour;      

    @Column(name = "AVG_Load_Forecast_Entsoe")
    private Double loadForecastEntsoe;     

    @Column(name = "Date_of_forecast")
    private Date dateOfForecast;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public Double getLoadForecastEntsoe() {
		return loadForecastEntsoe;
	}

	public void setLoadForecastEntsoe(Double loadForecastEntsoe) {
		this.loadForecastEntsoe = loadForecastEntsoe;
	}

	public Date getDateOfForecast() {
		return dateOfForecast;
	}

	public void setDateOfForecast(Date dateOfForecast) {
		this.dateOfForecast = dateOfForecast;
	}

 

}
