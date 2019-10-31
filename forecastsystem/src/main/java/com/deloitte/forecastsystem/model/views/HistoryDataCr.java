package com.deloitte.forecastsystem.model.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_input_data_cr")
public class HistoryDataCr {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;	
	
	@Column(name="Tip_dana", nullable=false, unique=true)
	private Integer tipDana;
	
	@Column(name="Dan", nullable=false, unique=true)
	private Integer dan;
	
	@Column(name="Medec", nullable=false, unique=true)
	private Integer mesec;	

	@Column(name="Godina", nullable=false, unique=true)
	private Integer godina;	

	// day-4
	
	@Column(name="AVG_Temperature4", nullable=false, unique=true)
	private Double avgTemperature4;
	
	@Column(name="MIN_Temperature4", nullable=false, unique=true)
	private Double minTemperature4;
	
	@Column(name="MAX_Temperature4", nullable=false, unique=true)
	private Double maxTemperature4;	

	@Column(name="AVG_Feelslike4", nullable=false, unique=true)
	private Double avgFeelslike4;
	
	@Column(name="MIN_Feelslike4", nullable=false, unique=true)
	private Double minFeelslike4;
	
	@Column(name="MAX_Feelslike4", nullable=false, unique=true)
	private Double maxFeelslike4;

	@Column(name="Wind4", nullable=false, unique=true)
	private Double wind4;
	
	@Column(name="Humidity4", nullable=false, unique=true)
	private Double humidity4;	
	
	@Column(name="Dew_point4", nullable=false, unique=true)
	private Double dewPoint4;
	
	@Column(name="Pressure4", nullable=false, unique=true)
	private Double pressure4;
	
	@Column(name="AVG_Load_forecast_entsoe4", nullable=false, unique=true)
	private Double avgLoadForecastEntsoe4;
	
	@Column(name="MIN_Load_forecast_entsoe4", nullable=false, unique=true)
	private Double minLoadForecastEntsoe4;	
	
	@Column(name="MAX_Load_forecast_entsoe4", nullable=false, unique=true)
	private Double maxLoadForecastEntsoe4;
	
	@Column(name="AVG_Load_real_data4", nullable=false, unique=true)
	private Double avgLoadRealData4;
	
	@Column(name="MIN_Load_real_data4", nullable=false, unique=true)
	private Double minLoadRealData4;	
	
	@Column(name="MAX_Load_real_data4", nullable=false, unique=true)
	private Double maxLoadRealData4;	

	// day-3
	
	@Column(name="AVG_Temperature3", nullable=false, unique=true)
	private Double avgTemperature3;
	
	@Column(name="MIN_Temperature3", nullable=false, unique=true)
	private Double minTemperature3;
	
	@Column(name="MAX_Temperature3", nullable=false, unique=true)
	private Double maxTemperature3;	

	@Column(name="AVG_Feelslike3", nullable=false, unique=true)
	private Double avgFeelslike3;
	
	@Column(name="MIN_Feelslike3", nullable=false, unique=true)
	private Double minFeelslike3;
	
	@Column(name="MAX_Feelslike3", nullable=false, unique=true)
	private Double maxFeelslike3;

	@Column(name="Wind3", nullable=false, unique=true)
	private Double wind3;
	
	@Column(name="Humidity3", nullable=false, unique=true)
	private Double humidity3;	
	
	@Column(name="Dew_point3", nullable=false, unique=true)
	private Double dewPoint3;
	
	@Column(name="Pressure3", nullable=false, unique=true)
	private Double pressure3;
	
	@Column(name="AVG_Load_forecast_entsoe3", nullable=false, unique=true)
	private Double avgLoadForecastEntsoe3;
	
	@Column(name="MIN_Load_forecast_entsoe3", nullable=false, unique=true)
	private Double minLoadForecastEntsoe3;	
	
	@Column(name="MAX_Load_forecast_entsoe3", nullable=false, unique=true)
	private Double maxLoadForecastEntsoe3;
	
	@Column(name="AVG_Load_real_data3", nullable=false, unique=true)
	private Double avgLoadRealData3;
	
	@Column(name="MIN_Load_real_data3", nullable=false, unique=true)
	private Double minLoadRealData3;	
	
	@Column(name="MAX_Load_real_data3", nullable=false, unique=true)
	private Double maxLoadRealData3;	
	
	// day-2
	
	@Column(name="AVG_Temperature2", nullable=false, unique=true)
	private Double avgTemperature2;
	
	@Column(name="MIN_Temperature2", nullable=false, unique=true)
	private Double minTemperature2;
	
	@Column(name="MAX_Temperature2", nullable=false, unique=true)
	private Double maxTemperature2;	

	@Column(name="AVG_Feelslike2", nullable=false, unique=true)
	private Double avgFeelslike2;
	
	@Column(name="MIN_Feelslike2", nullable=false, unique=true)
	private Double minFeelslike2;
	
	@Column(name="MAX_Feelslike2", nullable=false, unique=true)
	private Double maxFeelslike2;

	@Column(name="Wind2", nullable=false, unique=true)
	private Double wind2;
	
	@Column(name="Humidity2", nullable=false, unique=true)
	private Double humidity2;	
	
	@Column(name="Dew_point2", nullable=false, unique=true)
	private Double dewPoint2;
	
	@Column(name="Pressure2", nullable=false, unique=true)
	private Double pressure2;
	
	@Column(name="AVG_Load_forecast_entsoe2", nullable=false, unique=true)
	private Double avgLoadForecastEntsoe2;
	
	@Column(name="MIN_Load_forecast_entsoe2", nullable=false, unique=true)
	private Double minLoadForecastEntsoe2;	
	
	@Column(name="MAX_Load_forecast_entsoe2", nullable=false, unique=true)
	private Double maxLoadForecastEntsoe2;
	
	@Column(name="AVG_Load_real_data2", nullable=false, unique=true)
	private Double avgLoadRealData2;
	
	@Column(name="MIN_Load_real_data2", nullable=false, unique=true)
	private Double minLoadRealData2;	
	
	@Column(name="MAX_Load_real_data2", nullable=false, unique=true)
	private Double maxLoadRealData2;		
	
	// day-1
	
	@Column(name="AVG_Temperature", nullable=false, unique=true)
	private Double avgTemperature;
	
	@Column(name="MIN_Temperature", nullable=false, unique=true)
	private Double minTemperature;
	
	@Column(name="MAX_Temperature", nullable=false, unique=true)
	private Double maxTemperature;	

	@Column(name="AVG_Feelslike", nullable=false, unique=true)
	private Double avgFeelslike;
	
	@Column(name="MIN_Feelslike", nullable=false, unique=true)
	private Double minFeelslike;
	
	@Column(name="MAX_Feelslike", nullable=false, unique=true)
	private Double maxFeelslike;

	@Column(name="Wind", nullable=false, unique=true)
	private Double wind;
	
	@Column(name="Humidity", nullable=false, unique=true)
	private Double humidity;	
	
	@Column(name="Dew_point", nullable=false, unique=true)
	private Double dewPoint;
	
	@Column(name="Pressure", nullable=false, unique=true)
	private Double pressure;
	
	@Column(name="AVG_Load_forecast_entsoe", nullable=false, unique=true)
	private Double avgLoadForecastEntsoe;
	
	@Column(name="MIN_Load_forecast_entsoe", nullable=false, unique=true)
	private Double minLoadForecastEntsoe;	
	
	@Column(name="MAX_Load_forecast_entsoe", nullable=false, unique=true)
	private Double maxLoadForecastEntsoe;
	
	@Column(name="AVG_Load_real_data", nullable=false, unique=true)
	private Double avgLoadRealData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getMinTemperature4() {
		return minTemperature4;
	}

	public void setMinTemperature4(Double minTemperature4) {
		this.minTemperature4 = minTemperature4;
	}

	public Double getMaxTemperature4() {
		return maxTemperature4;
	}

	public void setMaxTemperature4(Double maxTemperature4) {
		this.maxTemperature4 = maxTemperature4;
	}

	public Double getAvgFeelslike4() {
		return avgFeelslike4;
	}

	public void setAvgFeelslike4(Double avgFeelslike4) {
		this.avgFeelslike4 = avgFeelslike4;
	}

	public Double getMinFeelslike4() {
		return minFeelslike4;
	}

	public void setMinFeelslike4(Double minFeelslike4) {
		this.minFeelslike4 = minFeelslike4;
	}

	public Double getMaxFeelslike4() {
		return maxFeelslike4;
	}

	public void setMaxFeelslike4(Double maxFeelslike4) {
		this.maxFeelslike4 = maxFeelslike4;
	}

	public Double getWind4() {
		return wind4;
	}

	public void setWind4(Double wind4) {
		this.wind4 = wind4;
	}

	public Double getHumidity4() {
		return humidity4;
	}

	public void setHumidity4(Double humidity4) {
		this.humidity4 = humidity4;
	}

	public Double getDewPoint4() {
		return dewPoint4;
	}

	public void setDewPoint4(Double dewPoint4) {
		this.dewPoint4 = dewPoint4;
	}

	public Double getPressure4() {
		return pressure4;
	}

	public void setPressure4(Double pressure4) {
		this.pressure4 = pressure4;
	}

	public Double getAvgLoadForecastEntsoe4() {
		return avgLoadForecastEntsoe4;
	}

	public void setAvgLoadForecastEntsoe4(Double avgLoadForecastEntsoe4) {
		this.avgLoadForecastEntsoe4 = avgLoadForecastEntsoe4;
	}

	public Double getMinLoadForecastEntsoe4() {
		return minLoadForecastEntsoe4;
	}

	public void setMinLoadForecastEntsoe4(Double minLoadForecastEntsoe4) {
		this.minLoadForecastEntsoe4 = minLoadForecastEntsoe4;
	}

	public Double getMaxLoadForecastEntsoe4() {
		return maxLoadForecastEntsoe4;
	}

	public void setMaxLoadForecastEntsoe4(Double maxLoadForecastEntsoe4) {
		this.maxLoadForecastEntsoe4 = maxLoadForecastEntsoe4;
	}

	public Double getAvgLoadRealData4() {
		return avgLoadRealData4;
	}

	public void setAvgLoadRealData4(Double avgLoadRealData4) {
		this.avgLoadRealData4 = avgLoadRealData4;
	}

	public Double getMinLoadRealData4() {
		return minLoadRealData4;
	}

	public void setMinLoadRealData4(Double minLoadRealData4) {
		this.minLoadRealData4 = minLoadRealData4;
	}

	public Double getMaxLoadRealData4() {
		return maxLoadRealData4;
	}

	public void setMaxLoadRealData4(Double maxLoadRealData4) {
		this.maxLoadRealData4 = maxLoadRealData4;
	}

	public Double getAvgTemperature3() {
		return avgTemperature3;
	}

	public void setAvgTemperature3(Double avgTemperature3) {
		this.avgTemperature3 = avgTemperature3;
	}

	public Double getMinTemperature3() {
		return minTemperature3;
	}

	public void setMinTemperature3(Double minTemperature3) {
		this.minTemperature3 = minTemperature3;
	}

	public Double getMaxTemperature3() {
		return maxTemperature3;
	}

	public void setMaxTemperature3(Double maxTemperature3) {
		this.maxTemperature3 = maxTemperature3;
	}

	public Double getAvgFeelslike3() {
		return avgFeelslike3;
	}

	public void setAvgFeelslike3(Double avgFeelslike3) {
		this.avgFeelslike3 = avgFeelslike3;
	}

	public Double getMinFeelslike3() {
		return minFeelslike3;
	}

	public void setMinFeelslike3(Double minFeelslike3) {
		this.minFeelslike3 = minFeelslike3;
	}

	public Double getMaxFeelslike3() {
		return maxFeelslike3;
	}

	public void setMaxFeelslike3(Double maxFeelslike3) {
		this.maxFeelslike3 = maxFeelslike3;
	}

	public Double getWind3() {
		return wind3;
	}

	public void setWind3(Double wind3) {
		this.wind3 = wind3;
	}

	public Double getHumidity3() {
		return humidity3;
	}

	public void setHumidity3(Double humidity3) {
		this.humidity3 = humidity3;
	}

	public Double getDewPoint3() {
		return dewPoint3;
	}

	public void setDewPoint3(Double dewPoint3) {
		this.dewPoint3 = dewPoint3;
	}

	public Double getPressure3() {
		return pressure3;
	}

	public void setPressure3(Double pressure3) {
		this.pressure3 = pressure3;
	}

	public Double getAvgLoadForecastEntsoe3() {
		return avgLoadForecastEntsoe3;
	}

	public void setAvgLoadForecastEntsoe3(Double avgLoadForecastEntsoe3) {
		this.avgLoadForecastEntsoe3 = avgLoadForecastEntsoe3;
	}

	public Double getMinLoadForecastEntsoe3() {
		return minLoadForecastEntsoe3;
	}

	public void setMinLoadForecastEntsoe3(Double minLoadForecastEntsoe3) {
		this.minLoadForecastEntsoe3 = minLoadForecastEntsoe3;
	}

	public Double getMaxLoadForecastEntsoe3() {
		return maxLoadForecastEntsoe3;
	}

	public void setMaxLoadForecastEntsoe3(Double maxLoadForecastEntsoe3) {
		this.maxLoadForecastEntsoe3 = maxLoadForecastEntsoe3;
	}

	public Double getAvgLoadRealData3() {
		return avgLoadRealData3;
	}

	public void setAvgLoadRealData3(Double avgLoadRealData3) {
		this.avgLoadRealData3 = avgLoadRealData3;
	}

	public Double getMinLoadRealData3() {
		return minLoadRealData3;
	}

	public void setMinLoadRealData3(Double minLoadRealData3) {
		this.minLoadRealData3 = minLoadRealData3;
	}

	public Double getMaxLoadRealData3() {
		return maxLoadRealData3;
	}

	public void setMaxLoadRealData3(Double maxLoadRealData3) {
		this.maxLoadRealData3 = maxLoadRealData3;
	}

	public Double getAvgTemperature2() {
		return avgTemperature2;
	}

	public void setAvgTemperature2(Double avgTemperature2) {
		this.avgTemperature2 = avgTemperature2;
	}

	public Double getMinTemperature2() {
		return minTemperature2;
	}

	public void setMinTemperature2(Double minTemperature2) {
		this.minTemperature2 = minTemperature2;
	}

	public Double getMaxTemperature2() {
		return maxTemperature2;
	}

	public void setMaxTemperature2(Double maxTemperature2) {
		this.maxTemperature2 = maxTemperature2;
	}

	public Double getAvgFeelslike2() {
		return avgFeelslike2;
	}

	public void setAvgFeelslike2(Double avgFeelslike2) {
		this.avgFeelslike2 = avgFeelslike2;
	}

	public Double getMinFeelslike2() {
		return minFeelslike2;
	}

	public void setMinFeelslike2(Double minFeelslike2) {
		this.minFeelslike2 = minFeelslike2;
	}

	public Double getMaxFeelslike2() {
		return maxFeelslike2;
	}

	public void setMaxFeelslike2(Double maxFeelslike2) {
		this.maxFeelslike2 = maxFeelslike2;
	}

	public Double getWind2() {
		return wind2;
	}

	public void setWind2(Double wind2) {
		this.wind2 = wind2;
	}

	public Double getHumidity2() {
		return humidity2;
	}

	public void setHumidity2(Double humidity2) {
		this.humidity2 = humidity2;
	}

	public Double getDewPoint2() {
		return dewPoint2;
	}

	public void setDewPoint2(Double dewPoint2) {
		this.dewPoint2 = dewPoint2;
	}

	public Double getPressure2() {
		return pressure2;
	}

	public void setPressure2(Double pressure2) {
		this.pressure2 = pressure2;
	}

	public Double getAvgLoadForecastEntsoe2() {
		return avgLoadForecastEntsoe2;
	}

	public void setAvgLoadForecastEntsoe2(Double avgLoadForecastEntsoe2) {
		this.avgLoadForecastEntsoe2 = avgLoadForecastEntsoe2;
	}

	public Double getMinLoadForecastEntsoe2() {
		return minLoadForecastEntsoe2;
	}

	public void setMinLoadForecastEntsoe2(Double minLoadForecastEntsoe2) {
		this.minLoadForecastEntsoe2 = minLoadForecastEntsoe2;
	}

	public Double getMaxLoadForecastEntsoe2() {
		return maxLoadForecastEntsoe2;
	}

	public void setMaxLoadForecastEntsoe2(Double maxLoadForecastEntsoe2) {
		this.maxLoadForecastEntsoe2 = maxLoadForecastEntsoe2;
	}

	public Double getAvgLoadRealData2() {
		return avgLoadRealData2;
	}

	public void setAvgLoadRealData2(Double avgLoadRealData2) {
		this.avgLoadRealData2 = avgLoadRealData2;
	}

	public Double getMinLoadRealData2() {
		return minLoadRealData2;
	}

	public void setMinLoadRealData2(Double minLoadRealData2) {
		this.minLoadRealData2 = minLoadRealData2;
	}

	public Double getMaxLoadRealData2() {
		return maxLoadRealData2;
	}

	public void setMaxLoadRealData2(Double maxLoadRealData2) {
		this.maxLoadRealData2 = maxLoadRealData2;
	}

	public Double getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgTemperature(Double avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public Double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public Double getAvgFeelslike() {
		return avgFeelslike;
	}

	public void setAvgFeelslike(Double avgFeelslike) {
		this.avgFeelslike = avgFeelslike;
	}

	public Double getMinFeelslike() {
		return minFeelslike;
	}

	public void setMinFeelslike(Double minFeelslike) {
		this.minFeelslike = minFeelslike;
	}

	public Double getMaxFeelslike() {
		return maxFeelslike;
	}

	public void setMaxFeelslike(Double maxFeelslike) {
		this.maxFeelslike = maxFeelslike;
	}

	public Double getWind() {
		return wind;
	}

	public void setWind(Double wind) {
		this.wind = wind;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(Double dewPoint) {
		this.dewPoint = dewPoint;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getAvgLoadForecastEntsoe() {
		return avgLoadForecastEntsoe;
	}

	public void setAvgLoadForecastEntsoe(Double avgLoadForecastEntsoe) {
		this.avgLoadForecastEntsoe = avgLoadForecastEntsoe;
	}

	public Double getMinLoadForecastEntsoe() {
		return minLoadForecastEntsoe;
	}

	public void setMinLoadForecastEntsoe(Double minLoadForecastEntsoe) {
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
	}

	public Double getMaxLoadForecastEntsoe() {
		return maxLoadForecastEntsoe;
	}

	public void setMaxLoadForecastEntsoe(Double maxLoadForecastEntsoe) {
		this.maxLoadForecastEntsoe = maxLoadForecastEntsoe;
	}

	public Double getAvgLoadRealData() {
		return avgLoadRealData;
	}

	public void setAvgLoadRealData(Double avgLoadRealData) {
		this.avgLoadRealData = avgLoadRealData;
	}		

	public double[] preparedVector() {
		double[] retval = {
			this.tipDana, this.dan, this.mesec, this.godina, 
			this.avgTemperature4, this.minTemperature4, this.maxTemperature4,
			this.avgFeelslike4, this.minFeelslike4, this.maxFeelslike4,
			this.wind4, this.humidity4, this.dewPoint4, this.pressure4,
			this.avgLoadForecastEntsoe4, this.minLoadForecastEntsoe4, this.maxLoadForecastEntsoe4,
			this.avgLoadRealData4, this.minLoadRealData4, this.maxLoadRealData4,
			this.avgTemperature3, this.minTemperature3, this.maxTemperature3,
			this.avgFeelslike3, this.minFeelslike3, this.maxFeelslike3,
			this.wind3, this.humidity3, this.dewPoint3, this.pressure3,
			this.avgLoadForecastEntsoe3, this.minLoadForecastEntsoe3, this.maxLoadForecastEntsoe3,
			this.avgLoadRealData3, this.minLoadRealData3, this.maxLoadRealData3,
			this.avgTemperature2, this.minTemperature2, this.maxTemperature2,
			this.avgFeelslike2, this.minFeelslike2, this.maxFeelslike2,
			this.avgLoadForecastEntsoe2, this.minLoadForecastEntsoe2, this.maxLoadForecastEntsoe2,
			this.avgLoadRealData2, this.minLoadRealData2, this.maxLoadRealData2,				
			this.avgTemperature, this.minTemperature, this.maxTemperature,
			this.avgFeelslike, this.minFeelslike, this.maxFeelslike,
			this.avgLoadForecastEntsoe, this.minLoadForecastEntsoe, this.maxLoadForecastEntsoe};			
		return retval;
	}
}

