package deloitte.forecastsystem_bih.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="df_load_forecast_similar_day")
public class LoadForecastSimilarDay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -958148134282636465L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;	

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;		

	@Column(name="Load_date")
	private Date loadDate;    
    
	@Column(name="Load_hour")
	private Integer loadHour;
	
	@Column(name="Load_minute")
	private Integer loadMinute;	

	@Column(name="Load_forecast_similar_day")
	private Double loadForecastSimilarDay;
	
	@Column(name="Forecast_date")
	private Date forecastDate;

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

	public Integer getLoadMinute() {
		return loadMinute;
	}

	public void setLoadMinute(Integer loadMinute) {
		this.loadMinute = loadMinute;
	}



	public Double getLoadForecastSimilarDay() {
		return loadForecastSimilarDay;
	}

	public void setLoadForecastSimilarDay(Double loadForecastSimilarDay) {
		this.loadForecastSimilarDay = loadForecastSimilarDay;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}	
	
	
}
