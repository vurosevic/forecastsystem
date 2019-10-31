package com.deloitte.forecastsystem;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.datamanipulation.DataManipulation;
import com.deloitte.forecastsystem.loadforecast.datamanipulation.DataManipulationAvgLoad;
import com.deloitte.forecastsystem.loadforecast.datamanipulation.DataManipulationHoursLoad;
import com.deloitte.forecastsystem.loadforecast.datamanipulation.DataManipulationSumLoad;
import com.deloitte.forecastsystem.loadforecast.datavector.DataVectorAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastHoursLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastSumLoad;

public class TrainingNetworks {

	public static void main(String[] args) {

//		for (CountriesEnum country : CountriesEnum.values()) {
//		
//		//CountriesEnum country = CountriesEnum.CO_RS;
//	      DataManipulation dm = new DataManipulationHoursLoad(country);		      
//	      if (dm.prepareDataForTraining()) {
//	      	System.out.println("Data prepared..." + country);
//	      } else {
//	      	System.out.println("Error..." + country);
//	      }
//		}		
//	   System.out.println("LoadHOURS CSV files are prepared...");		
		
//		for (CountriesEnum country : CountriesEnum.values()) {
//	      DataManipulation dm = new DataManipulationSumLoad(country);		      
//	      if (dm.prepareDataForTraining()) {
//	      	System.out.println("Data prepared..." + country);
//	      } else {
//	      	System.out.println("Error..." + country);
//	      }
//		}		
//	   System.out.println("LoadSUM CSV files are prepared...");			
		
		
//		for (CountriesEnum country : CountriesEnum.values()) {
//	      DataManipulation dm = new DataManipulation(country);		      
//	      if (dm.prepareDataForTraining()) {
//	      	System.out.println("Data prepared..." + country);
//	      } else {
//	      	System.out.println("Error..." + country);
//	      }
//		}		
//	   System.out.println("CSV files are prepared...");		
		
//      SystemForecastAvgLoad sf = new SystemForecastAvgLoad();      
//      Date datum1 = new Date();
//      Date datum2 = new Date();
//
//      long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
//      long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);      
//      
//      sf.trainEarlyStoppingAllNetsByThread();                    
//      sf.saveStateForAllNets();        
//      
//      for (int i=0; i<13; i++) {
//      	System.out.println("Net " + sf.getNet(i).getCountry() + ". MAPE=" + sf.getMapeForNet(i));
//      }
//     
//      System.out.println("Elapsed time: " + diff + " min.");        
//      System.out.println("End.");
		
		
//      SystemForecastSumLoad sf = new SystemForecastSumLoad();      
//      Date datum1 = new Date();
//      Date datum2 = new Date();
//
//      long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
//      long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);      
//      
//      sf.trainEarlyStoppingAllNetsByThread();                    
//      sf.saveStateForAllNets();        
//      
//      for (int i=0; i<13; i++) {
//      	System.out.println("Net " + sf.getNet(i).getCountry() + ". MAPE=" + sf.getMapeForNet(i));
//      }
//     
//      System.out.println("Elapsed time: " + diff + " min.");        
//      System.out.println("End.");

//	  System.out.println("Training started...");	
//      SystemForecastHoursLoad sf = new SystemForecastHoursLoad();      
//      Date datum1 = new Date();      
//
//      sf.trainEarlyStoppingAllNetsByThread();
//      
//      Date datum2 = new Date();
//      long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
//      long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);      
//                               
//      sf.saveStateForAllNets();        
//      
//      for (int i=0; i<13; i++) {
//      	System.out.println("Net " + sf.getNet(i).getCountry() + ". MAPE=" + sf.getMapeForNet(i));
//      }

		
		SystemForecastHoursLoad sf = new SystemForecastHoursLoad();
		try {
			sf.loadStatesForAllNets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sf.trainNet(1);
		//sf.saveStateForNet(1);

      for (int i=0; i<13; i++) {
    	  System.out.println("Net " + sf.getNet(i).getCountry() + ". MAPE=" + sf.getMapeForNet(i));
      }		
     
//      System.out.println("Elapsed time: " + diff + " min.");        
      System.out.println("End.");			
		    
      
	}
	
}
