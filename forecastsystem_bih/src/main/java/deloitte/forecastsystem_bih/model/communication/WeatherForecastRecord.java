package deloitte.forecastsystem_bih.model.communication;

public class WeatherForecastRecord {
	
	Double avgTemperature;
	Double minTemperature;
	Double maxTemperature;
	Double avgFeelslike;
	Double minFeelslike;
	Double maxFeelslike;
	
	public WeatherForecastRecord(Double avgTemperature,	Double minTemperature, Double maxTemperature,
								 Double avgFeelslike, Double minFeelslike, Double maxFeelslike) {
		// TODO Auto-generated constructor stub
		this.avgTemperature = avgTemperature;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.avgFeelslike = avgFeelslike;
		this.minFeelslike = minFeelslike;
		this.maxFeelslike = maxFeelslike;
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


}
