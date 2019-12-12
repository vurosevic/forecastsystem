package deloitte.forecastsystem_bih;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.datamanipulation.DataManipulation;
import deloitte.forecastsystem_bih.loadforecast.datamanipulation.DataManipulationHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.datamanipulation.DataManipulationSumLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastHoursLoad;
import deloitte.forecastsystem_bih.loadforecast.systemforecast.SystemForecastSumLoad;

public class TrainingNetworks {
	
	public static void main(String[] args) {


//////// SUM ///////////	
		
//		  System.out.println("Preparing started...");
//		  CountriesEnum country  = CountriesEnum.CO_BIH;		
//	      DataManipulation dm = new DataManipulationSumLoad(country);		      
//	      if (dm.prepareDataForTraining()) {
//	      	System.out.println("Data prepared..." + country);
//	      } else {
//	      	System.out.println("Error..." + country);
//	      }
//				
//	      System.out.println("LoadSUM CSV files are prepared...");		
	      
//		  System.out.println("Training started...");	
//	      SystemForecastSumLoad sf = new SystemForecastSumLoad();      
//	      Date datum1 = new Date();      
//	
//	      sf.trainEarlyStoppingAllNetsByThread();
//	      
//	      Date datum2 = new Date();
//	      long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
//	      long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);      
//	                               
//	      sf.saveStateForAllNets();        
//	      
//	      System.out.println("-----------------------");
//	      System.out.println("Net " + sf.getNet(0).getCountry() + ". MAPE=" + sf.getMapeForNet(0));
//		  System.out.println("-----------------------");      
//	      System.out.println("Elapsed time: " + diff + " min.");
//	      System.out.println("-----------------------");
//	      System.out.println("End.");	  	      
	      
		
		
////////  HOURS ///////////	
		
//		  System.out.println("Preparing started...");
//		  CountriesEnum country  = CountriesEnum.CO_BIH;		
//	      DataManipulation dm = new DataManipulationHoursLoad(country);		      
//	      if (dm.prepareDataForTraining()) {
//	      	System.out.println("Data prepared..." + country);
//	      } else {
//	      	System.out.println("Error..." + country);
//	      }
//				
//	      System.out.println("LoadHOURS CSV files are prepared...");
		

	  System.out.println("Training started...");	
      SystemForecastHoursLoad sf = new SystemForecastHoursLoad();      
      Date datum1 = new Date();      

      sf.trainEarlyStoppingAllNetsByThread();
      
      Date datum2 = new Date();
      long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
      long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);      
                               
      sf.saveStateForAllNets();        
      
      System.out.println("-----------------------");
      System.out.println("Net " + sf.getNet(0).getCountry() + ". MAPE=" + sf.getMapeForNet(0));
	  System.out.println("-----------------------");      
      System.out.println("Elapsed time: " + diff + " min.");
      System.out.println("-----------------------");
      System.out.println("End.");	      
		
		

	}

}
