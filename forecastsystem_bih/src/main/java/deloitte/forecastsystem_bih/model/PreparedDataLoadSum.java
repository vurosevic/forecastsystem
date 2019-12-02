package deloitte.forecastsystem_bih.model;

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
@Table(name="df_prepared_data_loadsum")
public class PreparedDataLoadSum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4026880487010757436L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;	
	
	@Column(name="Tip_dana", nullable=false)
	private Integer tipDana;
	
	@Column(name="Dan", nullable=false)
	private Integer dan;
	
	@Column(name="Mesec", nullable=false)
	private Integer mesec;	

	@Column(name="Godina", nullable=false)
	private Integer godina;	
	
	@Column(name="Holiday")
	private Integer holiday;		

	// day-4
	
	@Column(name="AVG_Temperature4", nullable=false)
	private Double avgTemperature4;
	
	@Column(name="MIN_Temperature4", nullable=false)
	private Double minTemperature4;
	
	@Column(name="MAX_Temperature4", nullable=false)
	private Double maxTemperature4;	

	@Column(name="AVG_Feelslike4", nullable=false)
	private Double avgFeelslike4;
	
	@Column(name="MIN_Feelslike4", nullable=false)
	private Double minFeelslike4;
	
	@Column(name="MAX_Feelslike4", nullable=false)
	private Double maxFeelslike4;

	@Column(name="Wind4", nullable=false)
	private Double wind4;
	
	@Column(name="Humidity4", nullable=false)
	private Double humidity4;	
	
	@Column(name="Dew_point4", nullable=false)
	private Double dewPoint4;
	
	@Column(name="Pressure4", nullable=false)
	private Double pressure4;
	
	@Column(name="SUM_Load_forecast_arima4", nullable=false)
	private Double sumLoadForecastArima4;
	
	@Column(name="MIN_Load_forecast_arima4", nullable=false)
	private Double minLoadForecastArima4;	
	
	@Column(name="MAX_Load_forecast_arima4", nullable=false)
	private Double maxLoadForecastArima4;
	
	@Column(name="SUM_Load_forecast_similarday4", nullable=false)
	private Double sumLoadForecastSimilarDay4;
	
	@Column(name="MIN_Load_forecast_similarday4", nullable=false)
	private Double minLoadForecastSimilarDay4;	
	
	@Column(name="MAX_Load_forecast_similarday4", nullable=false)
	private Double maxLoadForecastSimilarDay4;	
	
	@Column(name="SUM_Load_real_data4", nullable=false)
	private Double sumLoadRealData4;
	
	@Column(name="MIN_Load_real_data4", nullable=false)
	private Double minLoadRealData4;	
	
	@Column(name="MAX_Load_real_data4", nullable=false)
	private Double maxLoadRealData4;	

	// day-3
	
	@Column(name="AVG_Temperature3", nullable=false)
	private Double avgTemperature3;
	
	@Column(name="MIN_Temperature3", nullable=false)
	private Double minTemperature3;
	
	@Column(name="MAX_Temperature3", nullable=false)
	private Double maxTemperature3;	

	@Column(name="AVG_Feelslike3", nullable=false)
	private Double avgFeelslike3;
	
	@Column(name="MIN_Feelslike3", nullable=false)
	private Double minFeelslike3;
	
	@Column(name="MAX_Feelslike3", nullable=false)
	private Double maxFeelslike3;

	@Column(name="Wind3", nullable=false)
	private Double wind3;
	
	@Column(name="Humidity3", nullable=false)
	private Double humidity3;	
	
	@Column(name="Dew_point3", nullable=false)
	private Double dewPoint3;
	
	@Column(name="Pressure3", nullable=false)
	private Double pressure3;
	
	@Column(name="SUM_Load_forecast_arima3", nullable=false)
	private Double sumLoadForecastArima3;
	
	@Column(name="MIN_Load_forecast_arima3", nullable=false)
	private Double minLoadForecastArima3;	
	
	@Column(name="MAX_Load_forecast_arima3", nullable=false)
	private Double maxLoadForecastArima3;
	
	@Column(name="SUM_Load_forecast_similarday3", nullable=false)
	private Double sumLoadForecastSimilarDay3;
	
	@Column(name="MIN_Load_forecast_similarday3", nullable=false)
	private Double minLoadForecastSimilarDay3;	
	
	@Column(name="MAX_Load_forecast_similarday3", nullable=false)
	private Double maxLoadForecastSimilarDay3;	
	
	@Column(name="SUM_Load_real_data3", nullable=false)
	private Double sumLoadRealData3;
	
	@Column(name="MIN_Load_real_data3", nullable=false)
	private Double minLoadRealData3;	
	
	@Column(name="MAX_Load_real_data3", nullable=false)
	private Double maxLoadRealData3;	
	
	// day-2
	
	@Column(name="AVG_Temperature2", nullable=false)
	private Double avgTemperature2;
	
	@Column(name="MIN_Temperature2", nullable=false)
	private Double minTemperature2;
	
	@Column(name="MAX_Temperature2", nullable=false)
	private Double maxTemperature2;	

	@Column(name="AVG_Feelslike2", nullable=false)
	private Double avgFeelslike2;
	
	@Column(name="MIN_Feelslike2", nullable=false)
	private Double minFeelslike2;
	
	@Column(name="MAX_Feelslike2", nullable=false)
	private Double maxFeelslike2;

	@Column(name="Wind2", nullable=false)
	private Double wind2;
	
	@Column(name="Humidity2", nullable=false)
	private Double humidity2;	
	
	@Column(name="Dew_point2", nullable=false)
	private Double dewPoint2;
	
	@Column(name="Pressure2", nullable=false)
	private Double pressure2;
	
	@Column(name="SUM_Load_forecast_arima2", nullable=false)
	private Double sumLoadForecastArima2;
	
	@Column(name="MIN_Load_forecast_arima2", nullable=false)
	private Double minLoadForecastArima2;	
	
	@Column(name="MAX_Load_forecast_arima2", nullable=false)
	private Double maxLoadForecastArima2;
	
	@Column(name="SUM_Load_forecast_similarday2", nullable=false)
	private Double sumLoadForecastSimilarDay2;
	
	@Column(name="MIN_Load_forecast_similarday2", nullable=false)
	private Double minLoadForecastSimilarDay2;	
	
	@Column(name="MAX_Load_forecast_similarday2", nullable=false)
	private Double maxLoadForecastSimilarDay2;	
	
	@Column(name="SUM_Load_real_data2", nullable=false)
	private Double sumLoadRealData2;
	
	@Column(name="MIN_Load_real_data2", nullable=false)
	private Double minLoadRealData2;	
	
	@Column(name="MAX_Load_real_data2", nullable=false)
	private Double maxLoadRealData2;		
	
	// day-1
	
	@Column(name="AVG_Temperature", nullable=false)
	private Double avgTemperature;
	
	@Column(name="MIN_Temperature", nullable=false)
	private Double minTemperature;
	
	@Column(name="MAX_Temperature", nullable=false)
	private Double maxTemperature;	

	@Column(name="AVG_Feelslike", nullable=false)
	private Double avgFeelslike;
	
	@Column(name="MIN_Feelslike", nullable=false)
	private Double minFeelslike;
	
	@Column(name="MAX_Feelslike", nullable=false)
	private Double maxFeelslike;

	@Column(name="Wind", nullable=false)
	private Double wind;
	
	@Column(name="Humidity", nullable=false)
	private Double humidity;	
	
	@Column(name="Dew_point", nullable=false)
	private Double dewPoint;
	
	@Column(name="Pressure", nullable=false)
	private Double pressure;
	
	@Column(name="SUM_Load_forecast_arima", nullable=false)
	private Double sumLoadForecastArima;
	
	@Column(name="MIN_Load_forecast_arima", nullable=false)
	private Double minLoadForecastArima;	
	
	@Column(name="MAX_Load_forecast_arima", nullable=false)
	private Double maxLoadForecastArima;
	
	@Column(name="SUM_Load_forecast_similarday", nullable=false)
	private Double sumLoadForecastSimilarDay;
	
	@Column(name="MIN_Load_forecast_similarday", nullable=false)
	private Double minLoadForecastSimilarDay;	
	
	@Column(name="MAX_Load_forecast_similarday", nullable=false)
	private Double maxLoadForecastSimilarDay;	
	
	@Column(name="SUM_Load_real_data", nullable=false)
	private Double sumLoadRealData;

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;

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

	public Integer getHoliday() {
		return holiday;
	}

	public void setHoliday(Integer holiday) {
		this.holiday = holiday;
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

	public Double getSumLoadForecastArima4() {
		return sumLoadForecastArima4;
	}

	public void setSumLoadForecastArima4(Double sumLoadForecastArima4) {
		this.sumLoadForecastArima4 = sumLoadForecastArima4;
	}

	public Double getMinLoadForecastArima4() {
		return minLoadForecastArima4;
	}

	public void setMinLoadForecastArima4(Double minLoadForecastArima4) {
		this.minLoadForecastArima4 = minLoadForecastArima4;
	}

	public Double getMaxLoadForecastArima4() {
		return maxLoadForecastArima4;
	}

	public void setMaxLoadForecastArima4(Double maxLoadForecastArima4) {
		this.maxLoadForecastArima4 = maxLoadForecastArima4;
	}

	public Double getSumLoadForecastSimilarDay4() {
		return sumLoadForecastSimilarDay4;
	}

	public void setSumLoadForecastSimilarDay4(Double sumLoadForecastSimilarDay4) {
		this.sumLoadForecastSimilarDay4 = sumLoadForecastSimilarDay4;
	}

	public Double getMinLoadForecastSimilarDay4() {
		return minLoadForecastSimilarDay4;
	}

	public void setMinLoadForecastSimilarDay4(Double minLoadForecastSimilarDay4) {
		this.minLoadForecastSimilarDay4 = minLoadForecastSimilarDay4;
	}

	public Double getMaxLoadForecastSimilarDay4() {
		return maxLoadForecastSimilarDay4;
	}

	public void setMaxLoadForecastSimilarDay4(Double maxLoadForecastSimilarDay4) {
		this.maxLoadForecastSimilarDay4 = maxLoadForecastSimilarDay4;
	}

	public Double getSumLoadRealData4() {
		return sumLoadRealData4;
	}

	public void setSumLoadRealData4(Double sumLoadRealData4) {
		this.sumLoadRealData4 = sumLoadRealData4;
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

	public Double getSumLoadForecastArima3() {
		return sumLoadForecastArima3;
	}

	public void setSumLoadForecastArima3(Double sumLoadForecastArima3) {
		this.sumLoadForecastArima3 = sumLoadForecastArima3;
	}

	public Double getMinLoadForecastArima3() {
		return minLoadForecastArima3;
	}

	public void setMinLoadForecastArima3(Double minLoadForecastArima3) {
		this.minLoadForecastArima3 = minLoadForecastArima3;
	}

	public Double getMaxLoadForecastArima3() {
		return maxLoadForecastArima3;
	}

	public void setMaxLoadForecastArima3(Double maxLoadForecastArima3) {
		this.maxLoadForecastArima3 = maxLoadForecastArima3;
	}

	public Double getSumLoadForecastSimilarDay3() {
		return sumLoadForecastSimilarDay3;
	}

	public void setSumLoadForecastSimilarDay3(Double sumLoadForecastSimilarDay3) {
		this.sumLoadForecastSimilarDay3 = sumLoadForecastSimilarDay3;
	}

	public Double getMinLoadForecastSimilarDay3() {
		return minLoadForecastSimilarDay3;
	}

	public void setMinLoadForecastSimilarDay3(Double minLoadForecastSimilarDay3) {
		this.minLoadForecastSimilarDay3 = minLoadForecastSimilarDay3;
	}

	public Double getMaxLoadForecastSimilarDay3() {
		return maxLoadForecastSimilarDay3;
	}

	public void setMaxLoadForecastSimilarDay3(Double maxLoadForecastSimilarDay3) {
		this.maxLoadForecastSimilarDay3 = maxLoadForecastSimilarDay3;
	}

	public Double getSumLoadRealData3() {
		return sumLoadRealData3;
	}

	public void setSumLoadRealData3(Double sumLoadRealData3) {
		this.sumLoadRealData3 = sumLoadRealData3;
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

	public Double getSumLoadForecastArima2() {
		return sumLoadForecastArima2;
	}

	public void setSumLoadForecastArima2(Double sumLoadForecastArima2) {
		this.sumLoadForecastArima2 = sumLoadForecastArima2;
	}

	public Double getMinLoadForecastArima2() {
		return minLoadForecastArima2;
	}

	public void setMinLoadForecastArima2(Double minLoadForecastArima2) {
		this.minLoadForecastArima2 = minLoadForecastArima2;
	}

	public Double getMaxLoadForecastArima2() {
		return maxLoadForecastArima2;
	}

	public void setMaxLoadForecastArima2(Double maxLoadForecastArima2) {
		this.maxLoadForecastArima2 = maxLoadForecastArima2;
	}

	public Double getSumLoadForecastSimilarDay2() {
		return sumLoadForecastSimilarDay2;
	}

	public void setSumLoadForecastSimilarDay2(Double sumLoadForecastSimilarDay2) {
		this.sumLoadForecastSimilarDay2 = sumLoadForecastSimilarDay2;
	}

	public Double getMinLoadForecastSimilarDay2() {
		return minLoadForecastSimilarDay2;
	}

	public void setMinLoadForecastSimilarDay2(Double minLoadForecastSimilarDay2) {
		this.minLoadForecastSimilarDay2 = minLoadForecastSimilarDay2;
	}

	public Double getMaxLoadForecastSimilarDay2() {
		return maxLoadForecastSimilarDay2;
	}

	public void setMaxLoadForecastSimilarDay2(Double maxLoadForecastSimilarDay2) {
		this.maxLoadForecastSimilarDay2 = maxLoadForecastSimilarDay2;
	}

	public Double getSumLoadRealData2() {
		return sumLoadRealData2;
	}

	public void setSumLoadRealData2(Double sumLoadRealData2) {
		this.sumLoadRealData2 = sumLoadRealData2;
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

	public Double getSumLoadForecastArima() {
		return sumLoadForecastArima;
	}

	public void setSumLoadForecastArima(Double sumLoadForecastArima) {
		this.sumLoadForecastArima = sumLoadForecastArima;
	}

	public Double getMinLoadForecastArima() {
		return minLoadForecastArima;
	}

	public void setMinLoadForecastArima(Double minLoadForecastArima) {
		this.minLoadForecastArima = minLoadForecastArima;
	}

	public Double getMaxLoadForecastArima() {
		return maxLoadForecastArima;
	}

	public void setMaxLoadForecastArima(Double maxLoadForecastArima) {
		this.maxLoadForecastArima = maxLoadForecastArima;
	}

	public Double getSumLoadForecastSimilarDay() {
		return sumLoadForecastSimilarDay;
	}

	public void setSumLoadForecastSimilarDay(Double sumLoadForecastSimilarDay) {
		this.sumLoadForecastSimilarDay = sumLoadForecastSimilarDay;
	}

	public Double getMinLoadForecastSimilarDay() {
		return minLoadForecastSimilarDay;
	}

	public void setMinLoadForecastSimilarDay(Double minLoadForecastSimilarDay) {
		this.minLoadForecastSimilarDay = minLoadForecastSimilarDay;
	}

	public Double getMaxLoadForecastSimilarDay() {
		return maxLoadForecastSimilarDay;
	}

	public void setMaxLoadForecastSimilarDay(Double maxLoadForecastSimilarDay) {
		this.maxLoadForecastSimilarDay = maxLoadForecastSimilarDay;
	}

	public Double getSumLoadRealData() {
		return sumLoadRealData;
	}

	public void setSumLoadRealData(Double sumLoadRealData) {
		this.sumLoadRealData = sumLoadRealData;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public double[] preparedVector() {
		double[] retval = {
			this.tipDana, this.dan, this.mesec, this.godina, this.holiday,
			this.avgTemperature4, this.minTemperature4, this.maxTemperature4,
			this.avgFeelslike4, this.minFeelslike4, this.maxFeelslike4,
			this.wind4, this.humidity4, this.dewPoint4, this.pressure4,
			this.sumLoadForecastArima4, this.minLoadForecastArima4, this.maxLoadForecastArima4,
			this.sumLoadForecastSimilarDay4, this.minLoadForecastSimilarDay4, this.maxLoadForecastSimilarDay4,
			this.sumLoadRealData4, this.minLoadRealData4, this.maxLoadRealData4,
			this.avgTemperature3, this.minTemperature3, this.maxTemperature3,
			this.avgFeelslike3, this.minFeelslike3, this.maxFeelslike3,
			this.wind3, this.humidity3, this.dewPoint3, this.pressure3,
			this.sumLoadForecastArima3, this.minLoadForecastArima3, this.maxLoadForecastArima3,
			this.sumLoadForecastSimilarDay3, this.minLoadForecastSimilarDay3, this.maxLoadForecastSimilarDay3,
			this.sumLoadRealData3, this.minLoadRealData3, this.maxLoadRealData3,
			this.avgTemperature2, this.minTemperature2, this.maxTemperature2,
			this.avgFeelslike2, this.minFeelslike2, this.maxFeelslike2,
			this.sumLoadForecastArima2, this.minLoadForecastArima2, this.maxLoadForecastArima2,
			this.sumLoadForecastSimilarDay2, this.minLoadForecastSimilarDay2, this.maxLoadForecastSimilarDay2,
			this.sumLoadRealData2, this.minLoadRealData2, this.maxLoadRealData2,				
			this.avgTemperature, this.minTemperature, this.maxTemperature,
			this.avgFeelslike, this.minFeelslike, this.maxFeelslike,
			this.sumLoadForecastArima, this.minLoadForecastArima, this.maxLoadForecastArima,
			this.sumLoadForecastSimilarDay, this.minLoadForecastSimilarDay, this.maxLoadForecastSimilarDay
			};			
		return retval;
	}
	
	public double[] preparedVectorToday() {
		
		// doraditi
		// nedostaje holiday i prilagoditi broj nula na kraju.
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Belgrade"));		
		cal.set(this.godina, this.mesec-1, this.dan+1);	
		
		double[] retval = {
			cal.get(Calendar.DAY_OF_WEEK), cal.get(Calendar.DAY_OF_MONTH), (cal.get(Calendar.MONTH)+1), cal.get(Calendar.YEAR), 			
			this.avgTemperature3, this.minTemperature3, this.maxTemperature3,
			this.avgFeelslike3, this.minFeelslike3, this.maxFeelslike3,
			this.wind3, this.humidity3, this.dewPoint3, this.pressure3,
			this.sumLoadForecastArima3, this.minLoadForecastArima3, this.maxLoadForecastArima3,
			this.sumLoadForecastSimilarDay3, this.minLoadForecastSimilarDay3, this.maxLoadForecastSimilarDay3,
			this.sumLoadRealData3, this.minLoadRealData3, this.maxLoadRealData3,			
			this.avgTemperature2, this.minTemperature2, this.maxTemperature2,
			this.avgFeelslike2, this.minFeelslike2, this.maxFeelslike2,
			this.wind2, this.humidity2, this.dewPoint2, this.pressure2,
			this.sumLoadForecastArima2, this.minLoadForecastArima2, this.maxLoadForecastArima2,
			this.sumLoadForecastSimilarDay2, this.minLoadForecastSimilarDay2, this.maxLoadForecastSimilarDay2,
			this.sumLoadRealData2, this.minLoadRealData2, this.maxLoadRealData2,			
			this.avgTemperature, this.minTemperature, this.maxTemperature,
			this.avgFeelslike, this.minFeelslike, this.maxFeelslike,
			this.sumLoadForecastArima, this.minLoadForecastArima, this.maxLoadForecastArima,
			this.sumLoadForecastSimilarDay, this.minLoadForecastSimilarDay, this.maxLoadForecastSimilarDay,
			this.sumLoadRealData, 0, 0,			
			0, 0, 0,
			0, 0, 0,
			0, 0, 0};	
		
		return retval;
	}		
}
