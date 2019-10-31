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
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNet;
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetHoursLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.task.TaskEarlyStoppingTraininigHoursLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.task.TaskEarlyStoppingTraininigSumLoad;

@Service("systemForecastHoursLoad")
@Configurable
public class SystemForecastHoursLoad implements SystemForecast {

	String savePath = "c:/data/hours/saves/";
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
		
		nEpoch = 1500;
		nSamples = 100000;
		numInputs = 36;
		numOutputs = 1;
		momentum = 0.9;
		learningRate = 0.002555;
		batchSize = 250; //35 250 
		
		MlpNetHoursLoad mnetAT = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_AT, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetAT.initNetwork();
        mnetAT.loadData();	
        
        MlpNetHoursLoad mnetBIH = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BIH, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBIH.initNetwork();
        mnetBIH.loadData();        
	
        MlpNetHoursLoad mnetBL = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_BL, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetBL.initNetwork();
        mnetBL.loadData();  
        
        MlpNetHoursLoad mnetCR = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_CR, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetCR.initNetwork();
        mnetCR.loadData();         

        MlpNetHoursLoad mnetCZ = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_CZ, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetCZ.initNetwork();
        mnetCZ.loadData();        
        
        MlpNetHoursLoad mnetGR = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_GR, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetGR.initNetwork();
        mnetGR.loadData();       
        
        MlpNetHoursLoad mnetHU = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_HU, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetHU.initNetwork();
        mnetHU.loadData();         

        MlpNetHoursLoad mnetME = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_ME, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetME.initNetwork();
        mnetME.loadData();         

        MlpNetHoursLoad mnetPO = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_PO, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetPO.initNetwork();
        mnetPO.loadData();  
        
        MlpNetHoursLoad mnetRO = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_RO, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetRO.initNetwork();
        mnetRO.loadData();   
        
        MlpNetHoursLoad mnetRS = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_RS, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetRS.initNetwork();
        mnetRS.loadData();  
        
        MlpNetHoursLoad mnetSK = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_SK, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
        mnetSK.initNetwork();
        mnetSK.loadData(); 
        
        MlpNetHoursLoad mnetSL = new MlpNetHoursLoad(nEpoch, nSamples, numInputs, numOutputs, CountriesEnum.CO_SL, momentum, learningRate, batchSize, savePath, modelNamePart, earlyStoppingPart);
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
		
		futureAT = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(0)));
		futureBIH = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(1)));
		futureBL = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(2)));
		futureCR = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(3)));
		futureCZ = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(4)));
		futureGR = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(5)));
		futureHU = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(6)));	
		futureME = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(7)));
		futurePO = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(8)));
		futureRO = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(9)));
		futureRS = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(10)));
		futureSK = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(11)));
        futureSL = (Future<Integer>) executor.submit(new TaskEarlyStoppingTraininigHoursLoad(nets.get(12)));		
		
		while ((!futureAT.isDone())||(!futureBIH.isDone())||(!futureBL.isDone())||(!futureCR.isDone())||
				(!futureCZ.isDone())||(!futureGR.isDone())||(!futureHU.isDone())||(!futureME.isDone())||
				(!futurePO.isDone())||(!futureRO.isDone())||(!futureRS.isDone())||(!futureSK.isDone())||
				(!futureSK.isDone())){
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
