package deloitte.forecastsystem_bih.loadforecast.nnet;

import java.io.IOException;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.nd4j.linalg.dataset.api.DataSet;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;

public interface MlpNet {

	MultiLayerConfiguration getDeepDenseLayerNetworkConfiguration();
	void initNetwork();
	void trainNetwork();
	void trainNetworkEarlyStopping();
	double getMape(DataSet testData);
	void loadData();
	void loadLastStateMlpNet();
	void loadMlpNet(String filename) throws IOException;
	void saveMlpNet(String filename);
	double predict(double[] inputArray);	
	CountriesEnum getCountry();
	void setCountry(CountriesEnum country);
	
}
