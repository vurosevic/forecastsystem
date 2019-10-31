package com.deloitte.forecastsystem.loadforecast.systemforecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.task.TaskEarlyStoppingTraining;

@Service("systemForecastAvgLoad")
@Configurable
public class SystemForecastAvgLoad implements SystemForecast {
	
	String savePath = "c:/data/saves/";
	String modelNamePart = "data_";
	String earlyStoppingPart = "mlpModel_";	 
	
	int nEpoch;
	int nSamples;
	int numInputs;
	int numOutputs;
	double momentum;
	double learningRate;
	int batchSize;
	
	List<MlpNetAvgLoad> nets;
	
	public SystemForecastAvgLoad() {
		// TODO Auto-generated constructor stub
		
		nets = new ArrayList<MlpNetAvgLoad>();
		
		nEpoch = 5000;
		nSamples = 2000;
		numInputs = 57;
		numOutputs = 1;
		momentum = 0.9;
		learningRate = 0.001555;
		batchSize = 35; //35
		
        MlpNetAvgLoad mnetAT = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_AT, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetAT.initNetwork();
        mnetAT.loadData();	
        
        MlpNetAvgLoad mnetBIH = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BIH, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBIH.initNetwork();
        mnetBIH.loadData();        
	
        MlpNetAvgLoad mnetBL = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BL, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBL.initNetwork();
        mnetBL.loadData();  
        
        MlpNetAvgLoad mnetCR = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_CR, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetCR.initNetwork();
        mnetCR.loadData();         

        MlpNetAvgLoad mnetCZ = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_CZ, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetCZ.initNetwork();
        mnetCZ.loadData();        
        
        MlpNetAvgLoad mnetGR = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_GR, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetGR.initNetwork();
        mnetGR.loadData();       
        
        MlpNetAvgLoad mnetHU = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_HU, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetHU.initNetwork();
        mnetHU.loadData();         

        MlpNetAvgLoad mnetME = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_ME, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetME.initNetwork();
        mnetME.loadData();         

        MlpNetAvgLoad mnetPO = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_PO, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetPO.initNetwork();
        mnetPO.loadData();  
        
        MlpNetAvgLoad mnetRO = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_RO, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetRO.initNetwork();
        mnetRO.loadData();   
        
        MlpNetAvgLoad mnetRS = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_RS, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetRS.initNetwork();
        mnetRS.loadData();  
        
        MlpNetAvgLoad mnetSK = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_SK, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetSK.initNetwork();
        mnetSK.loadData(); 
        
        MlpNetAvgLoad mnetSL = new MlpNetAvgLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_SL, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetSL.initNetwork();
        mnetSL.loadData();       
                
        nets.add(mnetRS);
        nets.add(mnetBIH);
        nets.add(mnetHU);    
        nets.add(mnetRO);
        nets.add(mnetCR);
        nets.add(mnetCZ);
        nets.add(mnetSK);
        nets.add(mnetSL);   
        nets.add(mnetPO);        
        nets.add(mnetBL);
        nets.add(mnetGR);
        nets.add(mnetAT);
        nets.add(mnetME);
	}
	
	public void trainNet(int no) {
		nets.get(no).trainNetwork();
	}
	
	public void trainAllNets() {
		for (MlpNetAvgLoad nn : nets){
			nn.trainNetwork();
		}
	}
	
	public void trainEarlyStoppingAllNetsByThread() {
		
		ExecutorService executor = Executors.newWorkStealingPool(13);
		
		Future<Integer> futureAT;
		Future<Integer> futureBIH;
		Future<Integer> futureBL;
		Future<Integer> futureCR;
		Future<Integer> futureCZ;
		Future<Integer> futureGR;
		Future<Integer> futureHU;	
		Future<Integer> futureME;
		Future<Integer> futurePO;
		Future<Integer> futureRO;
		Future<Integer> futureRS;
		Future<Integer> futureSK;
		Future<Integer> futureSL;		
		
		int i=0;
		
		futureAT = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(0)));
		futureBIH = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(1)));
		futureBL = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(2)));
		futureCR = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(3)));
		futureCZ = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(4)));
		futureGR = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(5)));
		futureHU = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(6)));	
		futureME = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(7)));
		futurePO = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(8)));
		futureRO = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(9)));
		futureRS = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(10)));
		futureSK = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(11)));
        futureSL = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraining(nets.get(12)));		
		
		while ((!futureAT.isDone())||(!futureBIH.isDone())||(!futureBL.isDone())||(!futureCR.isDone())||
				(!futureCZ.isDone())||(!futureGR.isDone())||(!futureHU.isDone())||(!futureME.isDone())||
				(!futurePO.isDone())||(!futureRO.isDone())||(!futureRS.isDone())||(!futureSK.isDone())||
				(!futureSK.isDone())){
			// 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}						
		
	}
	
	public void trainEarlyStoppingAllNets() {	
		
		for (MlpNetAvgLoad nn : nets){
			nn.trainNetworkEarlyStopping();
		}
	}
	
	public MlpNetAvgLoad getNetByCountry(CountriesEnum co) {	
		
		for (MlpNetAvgLoad nn : nets){
			if (nn.getCountry() == co) return nn;
		}
		return null;
	}
	
	public double getMapeForNet(int no) {
		return nets.get(no).getMape();
	}
	
	public double getPredictForNet(int no, double[] input) {
		return nets.get(no).predict(input);
	}
	
	public void saveStateForNet(int no) {
		nets.get(no).saveMlpNet(savePath + modelNamePart + nets.get(no).getCountry()+".mdnet");
	}
	
	public void saveStateForAllNets() {
		for (MlpNetAvgLoad nn : nets){
			nn.saveMlpNet(savePath + modelNamePart + nn.getCountry()+".mdnet");
		}		
	}
	
	public void loadStateForNet(int no) throws IOException {
		nets.get(no).loadMlpNet(savePath + modelNamePart + nets.get(no).getCountry()+".mdnet");
	}
	
	public void loadStatesForAllNets() throws IOException {
		for (MlpNetAvgLoad nn : nets){
			nn.loadMlpNet(savePath + modelNamePart + nn.getCountry()+".mdnet");
		}		
	}
	
	public MlpNetAvgLoad getNet(int i) {
		return nets.get(i);
	}

}
