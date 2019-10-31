package com.deloitte.forecastsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.datavector.DataVectorAvgLoad;
import com.deloitte.forecastsystem.loadforecast.nnet.MlpNetAvgLoad;
import com.deloitte.forecastsystem.loadforecast.systemforecast.SystemForecastAvgLoad;
import com.deloitte.forecastsystem.service.views.HistoryDataRsService;

@SpringBootApplication(scanBasePackages={"com.*"})
public class ForecastsystemApplication implements CommandLineRunner {
	
	public static void main(String[] args) {

		SpringApplication.run(ForecastsystemApplication.class, args);
		
		//System.out.println(BCrypt.hashpw("vladimir123", BCrypt.gensalt(12)));
		//System.out.println(BCrypt.hashpw("secret", BCrypt.gensalt(12)));
		
//      ExportSqlToCsv stc = new ExportSqlToCsv("proba-rs-new.csv", "select * from vw_input_data_rs_new", "jdbc:mysql://localhost/deloitteforecast?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false", false);      
//      stc.sqlToCSV();
		
		
//      Ucitavanje podataka i priprema CSV fajlova za obuku
		
//		for (CountriesEnum country : CountriesEnum.values()) {
//		      DataManipulation dm = new DataManipulation(country);		      
//		      if (dm.prepareDataForTraining()) {
//		      	System.out.println("Data prepared..." + country);
//		      } else {
//		      	System.out.println("Error..." + country);
//		      }
//			}		
//		System.out.println("End...");

//        SystemForecast sf = new SystemForecast();
//        
//        Date datum1 = new Date();
//        
//        ////sf.trainEarlyStoppingAllNets();
//        
//        sf.trainEarlyStoppingAllNetsByThread();        
//        
//        Date datum2 = new Date();
//        
//        long diffInMillies = Math.abs(datum1.getTime() - datum2.getTime());
//        long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);        
//              
//        sf.saveStateForAllNets();        
//        
//        for (int i=0; i<13; i++) {
//        	System.out.println("Net " + sf.getNet(i).getCountry() + ". MAPE=" + sf.getMapeForNet(i));
//        }
//       
//        System.out.println("Proteklo vreme: " + diff + " minuta");        
//        System.out.println("End.");	
//		
//		
		
	}

	

	@Autowired
	HistoryDataRsService historyDataRsService;
	
	@Autowired
	SystemForecastAvgLoad systemForecast;
	
	@Autowired
	DataVectorAvgLoad dataVectorAvgLoad;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	 	
		MlpNetAvgLoad nn = systemForecast.getNetByCountry(CountriesEnum.CO_RS);
		nn.loadLastStateMlpNet();
		
		System.out.println("Country: " + nn.getCountry());
		
		dataVectorAvgLoad.setCountry(CountriesEnum.CO_RS);
		dataVectorAvgLoad.setDan(1);
		dataVectorAvgLoad.setMesec(11);
		dataVectorAvgLoad.setGodina(2018); 		
		
      double[] x;
      x = new double[]{5,1,11,2018,22.333333333333332,20.0,25.0,22.291666666666668,20.0,25.0,28.0,50.0625,11.3125,1010.7708333333334,4241.1667,3132,5120,4215.2500,3086,5051,19.104166666666668,13.0,22.0,19.104166666666668,13.0,22.0,20.5,65.0625,12.208333333333334,1012.875,4293.1667,3260,5150,4260.1667,3122,5092,15.5,8.0,23.0,15.166666666666666,6.0,22.0,4225.3750,3187,4939,4202.2917,3145,4998,17.893617021276597,10.0,26.0,17.872340425531913,9.0,26.0,4442.0417,3359,5214};       
				
      System.out.println("Prognoza za 01.11.2018. RS je: " + nn.predict(historyDataRsService.findByDate(1, 11, 2018).get(0).preparedVector()));
	  System.out.println("Prognoza za 01.11.2018. RS je: " + nn.predict(x));
	  System.out.println("Prognoza za 01.11.2018. RS je: " + nn.predict(dataVectorAvgLoad.getPreparedData())); 
//		
	  System.out.println("<<<<<<<<<<<PROSLO>>>>>>>>");
	}

}
