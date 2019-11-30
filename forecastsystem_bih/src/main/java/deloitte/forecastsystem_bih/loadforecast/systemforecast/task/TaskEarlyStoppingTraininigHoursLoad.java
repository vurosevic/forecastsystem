package deloitte.forecastsystem_bih.loadforecast.systemforecast.task;

import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetHoursLoad;

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
