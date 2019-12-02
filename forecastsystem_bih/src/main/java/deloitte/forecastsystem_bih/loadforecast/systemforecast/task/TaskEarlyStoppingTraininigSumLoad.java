package deloitte.forecastsystem_bih.loadforecast.systemforecast.task;

import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetSumLoad;

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
