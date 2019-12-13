package deloitte.forecastsystem_bih.loadforecast.systemforecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNet;
import deloitte.forecastsystem_bih.loadforecast.nnet.MlpNetHoursLoad; 
import deloitte.forecastsystem_bih.loadforecast.systemforecast.task.TaskEarlyStoppingTraininigHoursLoad;


@Service("systemForecastHoursLoad")
@Configurable
public class SystemForecastHoursLoad implements SystemForecast {

	String savePath = "c:/data/bih/hours/saves/";
	String modelNamePart = "data_";
	String earlyStoppingPart = "mlpModel_";	 
	
	int nEpoch;
	int nSamples;
	int numInputs;
	int numOutputs;
	double momentum;
	double learningRate;
	int batchSize;
	
	List<MlpNetHoursLoad> nets;

	public SystemForecastHoursLoad() {
		// TODO Auto-generated constructor stub
		
		nets = new ArrayList<MlpNetHoursLoad>();
		
		nEpoch = 8000;
		nSamples = 26000; // 26000 33000
		numInputs = 41; // 41 37
		numOutputs = 1;
		momentum = 0.9;
		learningRate = 0.002555; // 0.001555
		batchSize = 80; //35 250 75
		        
        MlpNetHoursLoad mnetBIH = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BIH, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBIH.initNetwork();
        mnetBIH.loadData();        	               
        
//        MlpNetHoursLoad mnetRS = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_RS, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
//        mnetRS.initNetwork();
//        mnetRS.loadData();                 
                
        // nets.add(mnetRS);
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
//		Future<Integer> futureRS;		
		
		int i=0;
		
		futureBIH = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(0)));
//		futureRS = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(0)));		
		
		while (!futureBIH.isDone()){
			// 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}						
		
	}
	
	@Override
	public void trainEarlyStoppingAllNets() {	
		
		for (MlpNetHoursLoad nn : nets){
			nn.trainNetworkEarlyStopping();
		}
	}

	@Override
	public MlpNetHoursLoad getNetByCountry(CountriesEnum co) {
		// TODO Auto-generated method stub
		for (MlpNetHoursLoad nn : nets){
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
		for (MlpNetHoursLoad nn : nets){
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
		for (MlpNetHoursLoad nn : nets){
			nn.loadMlpNet(savePath + modelNamePart + nn.getCountry()+".mdnet");
		}		
	}

	@Override
	public MlpNetHoursLoad getNet(int i) {
		// TODO Auto-generated method stub
		return nets.get(i);
	}


}
