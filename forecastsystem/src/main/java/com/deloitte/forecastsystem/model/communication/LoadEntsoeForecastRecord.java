package com.deloitte.forecastsystem.model.communication;

public class LoadEntsoeForecastRecord {
	
	Double avgLoadForecastEntsoe;
	Integer minLoadForecastEntsoe;
	Integer maxLoadForecastentsoe;
	
	public LoadEntsoeForecastRecord(double avgLoadForecastEntsoe, int minLoadForecastEntsoe, int maxLoadForecastentsoe) {
		// TODO Auto-generated constructor stub
		this.avgLoadForecastEntsoe = avgLoadForecastEntsoe;
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
		this.maxLoadForecastentsoe = maxLoadForecastentsoe;
	}

	public Double getAvgLoadForecastEntsoe() {
		return avgLoadForecastEntsoe;
	}

	public void setAvgLoadForecastEntsoe(Double avgLoadForecastEntsoe) {
		this.avgLoadForecastEntsoe = avgLoadForecastEntsoe;
	}

	public Integer getMinLoadForecastEntsoe() {
		return minLoadForecastEntsoe;
	}

	public void setMinLoadForecastEntsoe(Integer minLoadForecastEntsoe) {
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
	}

	public Integer getMaxLoadForecastentsoe() {
		return maxLoadForecastentsoe;
	}

	public void setMaxLoadForecastentsoe(Integer maxLoadForecastentsoe) {
		this.maxLoadForecastentsoe = maxLoadForecastentsoe;
	}


	


}
