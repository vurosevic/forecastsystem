package deloitte.forecastsystem_bih.loadforecast.systemforecast;

import java.io.IOException;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNet;

public interface SystemForecast {
	
	void trainNet(int no);
	void trainAllNets();
	void trainEarlyStoppingAllNets();
	void trainEarlyStoppingAllNetsByThread();
	MlpNet getNetByCountry(CountriesEnum co);
	double getMapeForNet(int no);
	double getPredictForNet(int no, double[] input);
	void saveStateForNet(int no);
	void saveStateForAllNets();
	void loadStateForNet(int no) throws IOException;
	void loadStatesForAllNets() throws IOException;
	MlpNet getNet(int i);

}
