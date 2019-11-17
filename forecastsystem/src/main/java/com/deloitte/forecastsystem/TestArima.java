package com.deloitte.forecastsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deloitte.forecastsystem.loadforecast.arima.ArimaModelService;
import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.PreparedDataLoadAvgService;
import com.deloitte.forecastsystem.service.PreparedDataLoadSumService;
import com.deloitte.forecastsystem.service.impl.PreparedDataLoadSumServiceImpl;


@SpringBootApplication(scanBasePackages={"com.*"})
public class TestArima  implements CommandLineRunner  {
	
	@Autowired
	PreparedDataLoadSumService preparedDataLoadSumService;
	
	@Autowired
	PreparedDataLoadAvgService preparedDataLoadAvgService; 	
	
	@Autowired
	CountryService countryService; 
	
	@Autowired
	ArimaModelService arimaModelService;
	
	public static void main(String[] args){

		SpringApplication.run(TestArima.class, args);		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("TEST ARIMA: ");
		
		Country con = countryService.findById(1L);
		
		//double[] res = preparedDataLoadSumService.getAllRealDataLoadSumByCountry(con);
		double[] res = preparedDataLoadAvgService.getAllRealDataLoadAvgByCountry(con);
		
//		for (int i=0; i<res.length; i++) {
//			  System.out.print(res[i] + " ");	
//		}
//		
//		System.out.println("");
		
		arimaModelService.setDataArray(res);
		arimaModelService.setpForecastSize(1);		

					arimaModelService.setPp(4);
					arimaModelService.setPd(1);
					arimaModelService.setPq(9);
					
					
    				for (int i=350; i<res.length; i++) {
								arimaModelService.prepareDataArrayPart(i);
								arimaModelService.trainArima();		
								
								System.out.println(arimaModelService.getDataArray()[i] + "," + arimaModelService.getForecastData()[0]);
								
								//System.out.println(i + " , MAPE : " + arimaModelService.getMape());
    				}
					
					
					
				
		
		

		
//		arimaModelService.setDataArray(res);
//		arimaModelService.setpForecastSize(5);
								
		
//		for (int p=1; p<10; p++)
//			for (int d=1; d<10; d++)
//				for (int q=1; q<10; q++) {
//
//					arimaModelService.setPp(p);
//					arimaModelService.setPd(d);
//					arimaModelService.setPq(q);
//										
//					arimaModelService.prepareDataArrayPart(365);
//					arimaModelService.trainArima();		
//					System.out.println(p + " - " + d + " - " + q + " - " + " , MAPE : " + arimaModelService.getMape());					
//					
//				}		
		
		
		
		System.out.println("END...");
		
		
		
		
	}
	

}
