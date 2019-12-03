package deloitte.forecastsystem_bih.loadforecast.systemforecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNet;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetSumLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.task.TaskEarlyStoppingTraininigSumLoad;

@Service("systemForecastSumLoad")
@Configurable
public class SystemForecastSumLoad implements SystemForecast {
	
	String savePath = "c:/data/bih/sum/saves/";
	String modelNamePart = "data_";
	String earlyStoppingPart = "mlpModel_";	 
	
	int nEpoch;
	int nSamples;
	int numInputs;
	int numOutputs;
	double momentum;
	double learningRate;
	int batchSize;
	
	List<MlpNetSumLoad> nets;

	public SystemForecastSumLoad() {
		// TODO Auto-generated constructor stub
		
		nets = new ArrayList<MlpNetSumLoad>();
		
		nEpoch = 4000;
		nSamples = 1100;
		numInputs = 70;
		numOutputs = 1;
		momentum = 0.9;
		learningRate = 0.001555;
		batchSize = 35; //35		
        
        MlpNetSumLoad mnetBIH = new MlpNetSumLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BIH, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBIH.initNetwork();
        mnetBIH.loadData();                  
                
        nets.add(mnetBIH);

	}
	

	@Override
	public void trainNet(int no) {
		// TODO Auto-generated method stub
		nets.get(no).trainNetwork();
	}

	@Override
	public void trainAllNets() {
		// TODO Auto-generated method stub
		for (MlpNet nn : nets){
			nn.trainNetwork();
		}
	}
	
	@Override
	public void trainEarlyStoppingAllNetsByThread() {
		
		ExecutorService executor = Executors.newWorkStealingPool(1);
		
		Future<Integer> futureBIH;	
		
		int i=0;
		
		futureBIH = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigSumLoad(nets.get(0)));	
		
		while (!futureBIH.isDone()){
			// 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}						
		
	}
	
	@Override
	public void trainEarlyStoppingAllNets() {	
		
		for (MlpNetSumLoad nn : nets){
			nn.trainNetworkEarlyStopping();
		}
	}

	@Override
	public MlpNetSumLoad getNetByCountry(CountriesEnum co) {
		// TODO Auto-generated method stub
		for (MlpNetSumLoad nn : nets){
			if (nn.getCountry() == co) return nn;
		}
		return null;
	}

	@Override
	public double getMapeForNet(int no) {
		// TODO Auto-generated method stub
		return nets.get(no).getMape();
	}

	@Override
	public double getPredictForNet(int no, double[] input) {
		// TODO Auto-generated method stub
		return nets.get(no).predict(input);
	}

	@Override
	public void saveStateForNet(int no) {
		// TODO Auto-generated method stub
		nets.get(no).saveMlpNet(savePath + modelNamePart + nets.get(no).getCountry()+".mdnet");
	}

	@Override
	public void saveStateForAllNets() {
		// TODO Auto-generated method stub
		for (MlpNetSumLoad nn : nets){
			nn.saveMlpNet(savePath + modelNamePart + nn.getCountry()+".mdnet");
		}		
	}

	@Override
	public void loadStateForNet(int no) throws IOException {
		// TODO Auto-generated method stub
		nets.get(no).loadMlpNet(savePath + modelNamePart + nets.get(no).getCountry()+".mdnet");
		
	}

	@Override
	public void loadStatesForAllNets() throws IOException {
		// TODO Auto-generated method stub
		for (MlpNetSumLoad nn : nets){
			nn.loadMlpNet(savePath + modelNamePart + nn.getCountry()+".mdnet");
		}		
	}

	@Override
	public MlpNetSumLoad getNet(int i) {
		// TODO Auto-generated method stub
		return nets.get(i);
	}

}
