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
@Table(name="history_load_forecast")
public class HistoryLoadForecast implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7248207949067091613L;

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

	@Column(name="Load_forecast_data")
	private Double loadForecastData;
	
	@Column(name="Forecast_date")
	private Date forecastDate;	
	
	
}
