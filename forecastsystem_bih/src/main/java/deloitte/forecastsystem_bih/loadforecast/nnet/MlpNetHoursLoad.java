package deloitte.forecastsystem_bih.loadforecast.nnet;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.impl.ListDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerMinMaxScaler;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.datamanipulation.DataManipulation;
import deloitte.forecastsystem_bih.loadforecast.datamanipulation.DataManipulationHoursLoad;

public class MlpNetHoursLoad implements MlpNet {

	String savePath = "c:/data/bih/hours/saves/";
	String modelNamePart = "data_";
	String earlyStoppingPart = "mlpModel_";
	
    //Random number generator seed, for reproducability
    int seed=123;
    //Number of epochs (full passes of the data)
    int nEpochs;
    //Number of data points
    int nSamples;
    //Batch size: i.e., each epoch has nSamples/batchSize parameter updates
    int batchSize;
    //Network learning rate
    double learningRate;
    //Momentum coefficient   
    double momentum; 
    Random rng;
    int numInputs;
    int numOutputs;	
    DataManipulation data; 
    CountriesEnum country;
    
    INDArray features;
    INDArray lables;            
    INDArray predicted;    
    
    DataSetIterator iterator;
    DataSet allData;
    SplitTestAndTrain testAndTrain;

    DataSet trainingData;
    DataSet testData;
    DataNormalization normalizer;  
    MultiLayerNetwork net;
        
    public MlpNetHoursLoad(int nEpochs, int nSamples, int numInputs, int numOutputs, CountriesEnum country, double momentum, double learningRate, int batchSize,
    		String savePath, String modelNamePart, String earlyStoppingPart) {
    	seed = 123;
    	rng = new Random(seed);
    	data = new DataManipulationHoursLoad(country);
    	normalizer = new NormalizerMinMaxScaler(0,1);
    	this.nEpochs = nEpochs;
    	this.nSamples = nSamples;
    	this.numInputs = numInputs;
    	this.numOutputs = numOutputs;
    	this.country = country;
    	this.momentum = momentum;
    	this.learningRate = learningRate;
    	this.batchSize = batchSize;
    	this.savePath = savePath;
    	this.modelNamePart = modelNamePart;
    	this.earlyStoppingPart = earlyStoppingPart;
    }
    
    public MultiLayerConfiguration getDeepDenseLayerNetworkConfiguration() {
        return (new NeuralNetConfiguration.Builder()
                .seed(seed)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Nesterovs(learningRate, momentum))
                .miniBatch(true)
                .weightInit(WeightInit.XAVIER)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(numInputs).nOut(200)
                        .activation(Activation.TANH).build())
                .layer(1, new DenseLayer.Builder().nIn(200).nOut(200)
                        .activation(Activation.TANH).build())
                .layer(2, new DenseLayer.Builder().nIn(200).nOut(200)
                        .activation(Activation.TANH).build())                
                .layer(3, new OutputLayer.Builder(LossFunctions.LossFunction.SQUARED_LOSS)
                        .activation(Activation.TANH)
                        .nIn(200).nOut(numOutputs).build()))
        		.build(); //.pretrain(false).backprop(true)
    }    
    
    public void initNetwork() {
        net = new MultiLayerNetwork(getDeepDenseLayerNetworkConfiguration()); 
        net.init();    	
    }
    
    public void trainNetwork() {

		RecordReader crr = new CSVRecordReader();
		try {		
			crr.initialize(new FileSplit(new File(data.getFileName())));			
			
			iterator = new RecordReaderDataSetIterator(crr,nSamples, numInputs, numInputs, true);
	        allData = iterator.next();
	        allData.shuffle();  // vladimir 
	        testAndTrain = allData.splitTestAndTrain(0.7);  //Use 70% of data for training

	        trainingData = testAndTrain.getTrain();
	        testData = testAndTrain.getTest();

	        //We need to normalize our data. We'll use NormalizeStandardize (which gives us mean 0, unit variance):
	        normalizer = new NormalizerMinMaxScaler(0,1);
	        normalizer.fitLabel(true);
	        normalizer.fit(trainingData);           //Collect the statistics (mean/stdev) from the training data. This does not modify the input data
	        normalizer.transform(trainingData);     //Apply normalization to the training data
	        normalizer.transform(testData);         //Apply normalization to the test data. This is using statistics calculated from the *training* set
        	        
	        features = testData.getFeatures();
	        lables = testData.getLabels();
	        
	        DataSetIterator iter = new ListDataSetIterator(trainingData.asList(), batchSize);
	        	        
	        for( int i=0; i<nEpochs; i++ ){
	        	iter.reset();
	            net.fit(iter);	        		            
	            predicted = net.output(features, false);
	            
	            System.out.println(i + ". " + country + " MAPE: " + getMape(testData));
	        }		        
	                                       
	        System.out.println( country + " MAPE: " + getMape(testData));
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    }
    
    public void trainNetworkEarlyStopping() {
    	
		try {			        
	        features = testData.getFeatures();
	        lables = testData.getLabels();
	        predicted = net.output(features, false);
	        
	        double currentMape = getMape(testData);
	        
	        DataSetIterator iter = new ListDataSetIterator(trainingData.asList(), batchSize);	        
	        
	        for( int i=0; i<nEpochs; i++ ){
	        	
	        	if ((i % 20) == 0) 
	        		System.out.println( country + " Iteration: " + i);
	        	
	        	iter.reset();
	            net.fit(iter);	        	
	            
	            predicted = net.output(features, false);
	            
	            if (currentMape*0.99 > getMape(testData)) {
	            	currentMape = getMape(testData);
	            	System.out.println( country + " Current MAPE: " + currentMape); 
	            	ModelSerializer.writeModel(net, new File(savePath + earlyStoppingPart + country + ".mdnet"), true);	            	
	            }
	        }		        
	        
	        loadMlpNet(savePath + earlyStoppingPart + country + ".mdnet");
	        System.out.println( country + " MAPE: " + getMape(testData));
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	       		
    }
    
    public double getMape(DataSet testData) {   	
        double res = 0.0;
        
        DataSet copy = testData.copy();
        
        INDArray features = copy.getFeatures();
        INDArray lables = copy.getLabels();
        INDArray predicted = net.output(features, false);
        
        normalizer.revertLabels(lables);        
        normalizer.revertLabels(predicted);
        
    	for (int i=0; i<lables.rows(); i++) {
    		res += Math.abs((lables.getDouble(i)-predicted.getDouble(i))/lables.getDouble(i));
    	}
        
        res = res/lables.rows()*100; 
    	return res;
    } 
    
    public void loadData() {
		RecordReader crr = new CSVRecordReader();
		try {
			crr.initialize(new FileSplit(new File(data.getFileName())));
		
			iterator = new RecordReaderDataSetIterator(crr,nSamples, numInputs, numInputs, true);
	        allData = iterator.next();
	        //allData.shuffle();
	        testAndTrain = allData.splitTestAndTrain(0.7);  //Use 70% of data for training

	        trainingData = testAndTrain.getTrain();
	        testData = testAndTrain.getTest();

	        //We need to normalize our data. We'll use NormalizeStandardize (which gives us mean 0, unit variance):
	        normalizer = new NormalizerMinMaxScaler(0,1);
	        normalizer.fitLabel(true);
	        normalizer.fit(trainingData);           //Collect the statistics (mean/stdev) from the training data. This does not modify the input data
	        normalizer.transform(trainingData);     //Apply normalization to the training data
	        normalizer.transform(testData);         //Apply normalization to the test data. This is using statistics calculated from the *training* set
		 
		} catch (Exception e) {
			// TODO: handle exception
		}   	
    }
    
    public void loadLastStateMlpNet() {
    	String filePath = savePath + modelNamePart + this.country + ".mdnet";
    	
    	//System.out.println("FilePath : " + filePath);
    	try {
			loadMlpNet(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void loadMlpNet(String filename) throws IOException{
    	
		try {		
	        net = ModelSerializer.restoreMultiLayerNetwork(new File(filename));	        
		} catch (Exception e) {
			// TODO: handle exception
		}    	
    	
    }    
    
    public void saveMlpNet(String filename) {
    	try {
    		ModelSerializer.writeModel(net, new File(filename), true);
    	} catch (Exception e) {
    		// TODO: 
    	}
    }
    
    public double predict(double[] inputArray) {    	
    	INDArray input = Nd4j.create(inputArray, new int[]{1, numInputs});
    	normalizer.transform(input);
    	INDArray out = net.output(input, true);
    	normalizer.revertLabels(out);
    	return out.getDouble(0);
    }
    
    public MultiLayerNetwork getNet() {
		return net;
	}

	public void setNet(MultiLayerNetwork net) {
		this.net = net;
	}

	public double getMape() {
	        return getMape(testData);    	
    }
    
	public int getSeed() {
		return seed;
	}
	public void setSeed(int seed) {
		this.seed = seed;
	}
	public int getnEpochs() {
		return nEpochs;
	}
	public void setnEpochs(int nEpochs) {
		this.nEpochs = nEpochs;
	}
	public int getnSamples() {
		return nSamples;
	}
	public void setnSamples(int nSamples) {
		this.nSamples = nSamples;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public double getLearningRate() {
		return learningRate;
	}
	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}
	public double getMomentum() {
		return momentum;
	}
	public void setMomentum(double momentum) {
		this.momentum = momentum;
	}
	public int getNumInputs() {
		return numInputs;
	}
	public void setNumInputs(int numInputs) {
		this.numInputs = numInputs;
	}
	public int getNumOutputs() {
		return numOutputs;
	}
	public void setNumOutputs(int numOutputs) {
		this.numOutputs = numOutputs;
	}
	public CountriesEnum getCountry() {
		return country;
	}
	public void setCountry(CountriesEnum country) {
		this.country = country;
	}
    
  

}
