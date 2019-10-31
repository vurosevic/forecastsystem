package com.deloitte.forecastsystem.loadforecast.systemforecast.task;

import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetSumLoad;

public class TaskEarlyStoppingTraininigSumLoad implements Runnable {

	MlpNetSumLoad net;
	
	public TaskEarlyStoppingTraininigSumLoad(MlpNetSumLoad n) {
		// TODO Auto-generated constructor stub
		this.net = n;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		net.trainNetworkEarlyStopping();		
	}	
	
}
