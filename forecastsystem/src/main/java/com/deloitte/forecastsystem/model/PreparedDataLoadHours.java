package com.deloitte.forecastsystem.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="df_prepared_data_loadhours")
public class PreparedDataLoadHours implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6018342730783264451L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;	

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;		
	
	@Column(name="Load_hour")
	private Integer loadHour;	
	
	@Column(name="Tip_dana")
	private Integer tipDana;
	
	@Column(name="Dan")
	private Integer dan;
	
	@Column(name="Mesec")
	private Integer mesec;	

	@Column(name="Godina")
	private Integer godina;		
	
	@Column(name="AVG_Temperature4")
	private Double avgTemperature4;
	
	@Column(name="AVG_Feelslike4")
	private Double avgFeelslike4;	

	@Column(name="AVG_Wind4")
	private Double avgWind4;
	
	@Column(name="AVG_Humidity4")
	private Double avgHumidity4;	

	@Column(name="AVG_Dew_point4")
	private Double avgDewPoint4;
	
	@Column(name="AVG_Pressure4")
	private Double avgPressure4;	

	@Column(name="AVG_Load_forecast_entsoe4")
	private Double avgLoadForecastEntsoe4;
	
	@Column(name="AVG_Load_real_data4")
	private Double avgLoadRealData4;		
	
	@Column(name="AVG_Temperature3")
	private Double avgTemperature3;
	
	@Column(name="AVG_Feelslike3")
	private Double avgFeelslike3;	

	@Column(name="AVG_Wind3")
	private Double avgWind3;
	
	@Column(name="AVG_Humidity3")
	private Double avgHumidity3;	

	@Column(name="AVG_Dew_point3")
	private Double avgDewPoint3;
	
	@Column(name="AVG_Pressure3")
	private Double avgPressure3;	

	@Column(name="AVG_Load_forecast_entsoe3")
	private Double avgLoadForecastEntsoe3;
	
	@Column(name="AVG_Load_real_data3")
	private Double avgLoadRealData3;
		
	@Column(name="AVG_Temperature2")
	private Double avgTemperature2;
	
	@Column(name="AVG_Feelslike2")
	private Double avgFeelslike2;	

	@Column(name="AVG_Wind2")
	private Double avgWind2;
	
	@Column(name="AVG_Humidity2")
	private Double avgHumidity2;	

	@Column(name="AVG_Dew_point2")
	private Double avgDewPoint2;
	
	@Column(name="AVG_Pressure2")
	private Double avgPressure2;	

	@Column(name="AVG_Load_forecast_entsoe2")
	private Double avgLoadForecastEntsoe2;
	
	@Column(name="AVG_Load_real_data2")
	private Double avgLoadRealData2;
	
	@Column(name="AVG_Temperature")
	private Double avgTemperature;
	
	@Column(name="AVG_Feelslike")
	private Double avgFeelslike;	

	@Column(name="AVG_Wind")
	private Double avgWind;
	
	@Column(name="AVG_Humidity")
	private Double avgHumidity;	

	@Column(name="AVG_Dew_point")
	private Double avgDewPoint;
	
	@Column(name="AVG_Pressure")
	private Double avgPressure;	

	@Column(name="AVG_Load_forecast_entsoe")
	private Double avgLoadForecastEntsoe;
	
	@Column(name="AVG_Load_real_data")
	private Double avgLoadRealData;

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

	public Integer getLoadHour() {
		return loadHour;
	}

	public void setLoadHour(Integer loadHour) {
		this.loadHour = loadHour;
	}

	public Integer getTipDana() {
		return tipDana;
	}

	public void setTipDana(Integer tipDana) {
		this.tipDana = tipDana;
	}

	public Integer getDan() {
		return dan;
	}

	public void setDan(Integer dan) {
		this.dan = dan;
	}

	public Integer getMesec() {
		return mesec;
	}

	public void setMesec(Integer mesec) {
		this.mesec = mesec;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	public Double getAvgTemperature4() {
		return avgTemperature4;
	}

	public void setAvgTemperature4(Double avgTemperature4) {
		this.avgTemperature4 = avgTemperature4;
	}

	public Double getAvgFeelslike4() {
		return avgFeelslike4;
	}

	public void setAvgFeelslike4(Double avgFeelslike4) {
		this.avgFeelslike4 = avgFeelslike4;
	}

	public Double getAvgWind4() {
		return avgWind4;
	}

	public void setAvgWind4(Double avgWind4) {
		this.avgWind4 = avgWind4;
	}

	public Double getAvgHumidity4() {
		return avgHumidity4;
	}

	public void setAvgHumidity4(Double avgHumidity4) {
		this.avgHumidity4 = avgHumidity4;
	}

	public Double getAvgDewPoint4() {
		return avgDewPoint4;
	}

	public void setAvgDewPoint4(Double avgDewPoint4) {
		this.avgDewPoint4 = avgDewPoint4;
	}

	public Double getAvgPressure4() {
		return avgPressure4;
	}

	public void setAvgPressure4(Double avgPressure4) {
		this.avgPressure4 = avgPressure4;
	}

	public Double getAvgLoadForecastEntsoe4() {
		return avgLoadForecastEntsoe4;
	}

	public void setAvgLoadForecastEntsoe4(Double avgLoadForecastEntsoe4) {
		this.avgLoadForecastEntsoe4 = avgLoadForecastEntsoe4;
	}

	public Double getAvgLoadRealData4() {
		return avgLoadRealData4;
	}

	public void setAvgLoadRealData4(Double avgLoadRealData4) {
		this.avgLoadRealData4 = avgLoadRealData4;
	}

	public Double getAvgTemperature3() {
		return avgTemperature3;
	}

	public void setAvgTemperature3(Double avgTemperature3) {
		this.avgTemperature3 = avgTemperature3;
	}

	public Double getAvgFeelslike3() {
		return avgFeelslike3;
	}

	public void setAvgFeelslike3(Double avgFeelslike3) {
		this.avgFeelslike3 = avgFeelslike3;
	}

	public Double getAvgWind3() {
		return avgWind3;
	}

	public void setAvgWind3(Double avgWind3) {
		this.avgWind3 = avgWind3;
	}

	public Double getAvgHumidity3() {
		return avgHumidity3;
	}

	public void setAvgHumidity3(Double avgHumidity3) {
		this.avgHumidity3 = avgHumidity3;
	}

	public Double getAvgDewPoint3() {
		return avgDewPoint3;
	}

	public void setAvgDewPoint3(Double avgDewPoint3) {
		this.avgDewPoint3 = avgDewPoint3;
	}

	public Double getAvgPressure3() {
		return avgPressure3;
	}

	public void setAvgPressure3(Double avgPressure3) {
		this.avgPressure3 = avgPressure3;
	}

	public Double getAvgLoadForecastEntsoe3() {
		return avgLoadForecastEntsoe3;
	}

	public void setAvgLoadForecastEntsoe3(Double avgLoadForecastEntsoe3) {
		this.avgLoadForecastEntsoe3 = avgLoadForecastEntsoe3;
	}

	public Double getAvgLoadRealData3() {
		return avgLoadRealData3;
	}

	public void setAvgLoadRealData3(Double avgLoadRealData3) {
		this.avgLoadRealData3 = avgLoadRealData3;
	}

	public Double getAvgTemperature2() {
		return avgTemperature2;
	}

	public void setAvgTemperature2(Double avgTemperature2) {
		this.avgTemperature2 = avgTemperature2;
	}

	public Double getAvgFeelslike2() {
		return avgFeelslike2;
	}

	public void setAvgFeelslike2(Double avgFeelslike2) {
		this.avgFeelslike2 = avgFeelslike2;
	}

	public Double getAvgWind2() {
		return avgWind2;
	}

	public void setAvgWind2(Double avgWind2) {
		this.avgWind2 = avgWind2;
	}

	public Double getAvgHumidity2() {
		return avgHumidity2;
	}

	public void setAvgHumidity2(Double avgHumidity2) {
		this.avgHumidity2 = avgHumidity2;
	}

	public Double getAvgDewPoint2() {
		return avgDewPoint2;
	}

	public void setAvgDewPoint2(Double avgDewPoint2) {
		this.avgDewPoint2 = avgDewPoint2;
	}

	public Double getAvgPressure2() {
		return avgPressure2;
	}

	public void setAvgPressure2(Double avgPressure2) {
		this.avgPressure2 = avgPressure2;
	}

	public Double getAvgLoadForecastEntsoe2() {
		return avgLoadForecastEntsoe2;
	}

	public void setAvgLoadForecastEntsoe2(Double avgLoadForecastEntsoe2) {
		this.avgLoadForecastEntsoe2 = avgLoadForecastEntsoe2;
	}

	public Double getAvgLoadRealData2() {
		return avgLoadRealData2;
	}

	public void setAvgLoadRealData2(Double avgLoadRealData2) {
		this.avgLoadRealData2 = avgLoadRealData2;
	}

	public Double getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgTemperature(Double avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public Double getAvgFeelslike() {
		return avgFeelslike;
	}

	public void setAvgFeelslike(Double avgFeelslike) {
		this.avgFeelslike = avgFeelslike;
	}

	public Double getAvgWind() {
		return avgWind;
	}

	public void setAvgWind(Double avgWind) {
		this.avgWind = avgWind;
	}

	public Double getAvgHumidity() {
		return avgHumidity;
	}

	public void setAvgHumidity(Double avgHumidity) {
		this.avgHumidity = avgHumidity;
	}

	public Double getAvgDewPoint() {
		return avgDewPoint;
	}

	public void setAvgDewPoint(Double avgDewPoint) {
		this.avgDewPoint = avgDewPoint;
	}

	public Double getAvgPressure() {
		return avgPressure;
	}

	public void setAvgPressure(Double avgPressure) {
		this.avgPressure = avgPressure;
	}

	public Double getAvgLoadForecastEntsoe() {
		return avgLoadForecastEntsoe;
	}

	public void setAvgLoadForecastEntsoe(Double avgLoadForecastEntsoe) {
		this.avgLoadForecastEntsoe = avgLoadForecastEntsoe;
	}

	public Double getAvgLoadRealData() {
		return avgLoadRealData;
	}

	public void setAvgLoadRealData(Double avgLoadRealData) {
		this.avgLoadRealData = avgLoadRealData;
	}	
		
	public double[] preparedVector() {
		double[] retval = {
			this.loadHour,
			this.tipDana, this.dan, this.mesec, this.godina, 
			this.avgTemperature4, this.avgFeelslike4, this.avgWind4, 
			this.avgHumidity4, this.avgDewPoint4, this.avgPressure4, 
			this.avgLoadForecastEntsoe4, this.avgLoadRealData4,
			this.avgTemperature3, this.avgFeelslike3, this.avgWind3, 
			this.avgHumidity3, this.avgDewPoint3, this.avgPressure3, 
			this.avgLoadForecastEntsoe3, this.avgLoadRealData3,
			this.avgTemperature2, this.avgFeelslike2, this.avgWind2, 
			this.avgHumidity2, this.avgDewPoint2, this.avgPressure2, 
			this.avgLoadForecastEntsoe2, this.avgLoadRealData2,		
			this.avgTemperature, this.avgFeelslike, this.avgWind, 
			this.avgHumidity, this.avgDewPoint, this.avgPressure, 
			this.avgLoadForecastEntsoe};			
		return retval;
	}    
	
	public double[] preparedVectorToday() {
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Belgrade"));		
		cal.set(this.godina, this.mesec-1, this.dan+1);	
		
		double[] retval = {
			this.loadHour,
			cal.get(Calendar.DAY_OF_WEEK), cal.get(Calendar.DAY_OF_MONTH), (cal.get(Calendar.MONTH)+1), cal.get(Calendar.YEAR), 		
			
			this.avgTemperature3, this.avgFeelslike3, this.avgWind3, 
			this.avgHumidity3, this.avgDewPoint3, this.avgPressure3, 
			this.avgLoadForecastEntsoe3, this.avgLoadRealData3,
			
			this.avgTemperature2, this.avgFeelslike2, this.avgWind2, 
			this.avgHumidity2, this.avgDewPoint2, this.avgPressure2, 
			this.avgLoadForecastEntsoe2, this.avgLoadRealData2,
			
			this.avgTemperature, this.avgFeelslike, this.avgWind, 
			this.avgHumidity, this.avgDewPoint, this.avgPressure, 
			this.avgLoadForecastEntsoe, this.avgLoadRealData,
			
			0, 0, 0, 
			0, 0, 0, 
			0};
		
		return retval;
	}	

}
