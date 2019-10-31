package com.deloitte.forecastsystem.loadforecast.systemforecast.task;

import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetAvgLoad;

public class TaskEarlyStoppingTraining implements Runnable {

	MlpNetAvgLoad net;
	
	public TaskEarlyStoppingTraining(MlpNetAvgLoad n) {
		// TODO Auto-generated constructor stub
		this.net = n;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		net.trainNetworkEarlyStopping();		
	}

}
