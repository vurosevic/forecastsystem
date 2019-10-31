package com.deloitte.forecastsystem.loadforecast.systemforecast.task;

import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetHoursLoad;

public class TaskEarlyStoppingTraininigHoursLoad implements Runnable {

	MlpNetHoursLoad net;
	
	public TaskEarlyStoppingTraininigHoursLoad(MlpNetHoursLoad n) {
		// TODO Auto-generated constructor stub
		this.net = n;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		net.trainNetworkEarlyStopping();		
	}

}
