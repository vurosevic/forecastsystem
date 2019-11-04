package com.deloitte.forecastsystem.model.communication;

public class LoadEntsoeForecastSumRecord {
	
	Double sumLoadForecastEntsoe;
	Double minLoadForecastEntsoe;
	Double maxLoadForecastentsoe;
	
	public LoadEntsoeForecastSumRecord(double sumLoadForecastEntsoe, double minLoadForecastEntsoe, double maxLoadForecastentsoe) {
		// TODO Auto-generated constructor stub
		this.sumLoadForecastEntsoe = sumLoadForecastEntsoe;
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
		this.maxLoadForecastentsoe = maxLoadForecastentsoe;
	}
	
	public LoadEntsoeForecastSumRecord(long sumLoadForecastEntsoe, int minLoadForecastEntsoe, int maxLoadForecastentsoe) {
		// TODO Auto-generated constructor stub
		this.sumLoadForecastEntsoe = new Double(sumLoadForecastEntsoe);
		this.minLoadForecastEntsoe = new Double(minLoadForecastEntsoe);
		this.maxLoadForecastentsoe = new Double(maxLoadForecastentsoe);
	}	

	public Double getSumLoadForecastEntsoe() {
		return sumLoadForecastEntsoe;
	}

	public void setSumLoadForecastEntsoe(Double sumLoadForecastEntsoe) {
		this.sumLoadForecastEntsoe = sumLoadForecastEntsoe;
	}

	public Double getMinLoadForecastEntsoe() {
		return minLoadForecastEntsoe;
	}

	public void setMinLoadForecastEntsoe(Double minLoadForecastEntsoe) {
		this.minLoadForecastEntsoe = minLoadForecastEntsoe;
	}

	public Double getMaxLoadForecastentsoe() {
		return maxLoadForecastentsoe;
	}

	public void setMaxLoadForecastentsoe(Double maxLoadForecastentsoe) {
		this.maxLoadForecastentsoe = maxLoadForecastentsoe;
	}




	
	
}
