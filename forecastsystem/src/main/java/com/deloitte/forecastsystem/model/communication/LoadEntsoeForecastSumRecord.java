package com.deloitte.forecastsystem.model.communication;

public class LoadEntsoeForecastSumRecord {
	
	Long sumLoadForecastEntsoe;
	Integer minLoadForecastEntsoe;
	Integer maxLoadForecastentsoe;
	
	public LoadEntsoeForecastSumRecord(long sumLoadForecastEntsoe, int minLoadForecastEntsoe, int maxLoadForecastentsoe) {
		// TODO Auto-generated constructor stub
		this.sumLoadForecastEntsoe = sumLoadForecastEntsoe;
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
		this.maxLoadForecastentsoe = maxLoadForecastentsoe;
	}

	public Long getSumLoadForecastEntsoe() {
		return sumLoadForecastEntsoe;
	}

	public void setSumLoadForecastEntsoe(Long sumLoadForecastEntsoe) {
		this.sumLoadForecastEntsoe = sumLoadForecastEntsoe;
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
