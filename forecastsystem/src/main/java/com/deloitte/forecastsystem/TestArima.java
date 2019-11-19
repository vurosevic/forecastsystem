package com.deloitte.forecastsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deloitte.forecastsystem.loadforecast.arima.ArimaModelService;
import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.PreparedDataLoadAvgService;
import com.deloitte.forecastsystem.service.PreparedDataLoadHoursService;
import com.deloitte.forecastsystem.service.PreparedDataLoadSumService;
import com.deloitte.forecastsystem.service.impl.PreparedDataLoadSumServiceImpl;


@SpringBootApplication(scanBasePackages={"com.*"})
public class TestArima  implements CommandLineRunner  {
	
	@Autowired
	PreparedDataLoadSumService preparedDataLoadSumService;
	
	@Autowired
	PreparedDataLoadAvgService preparedDataLoadAvgService; 	
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
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
		
		Country con = countryService.findById(2L);
		
		double[] res = preparedDataLoadSumService.getAllRealDataLoadSumByCountry(con);
		//double[] res = preparedDataLoadAvgService.getAllRealDataLoadAvgByCountry(con);
		//double[] res = preparedDataLoadHoursService.getAllRealDataLoadHoursByCountry(con);
		
		
//		for (int i=0; i<res.length; i++) {
//			  System.out.print(res[i] + " ");	
//		}
//		
//		System.out.println("");
		
		arimaModelService.setDataArray(res);
		arimaModelService.setpForecastSize(1);		

					arimaModelService.setPp(13); //4
					arimaModelService.setPd(1); //1
					arimaModelService.setPq(8); //9
		
	//					arimaModelService.setPp(7);
	//					arimaModelService.setPd(1);
	//					arimaModelService.setPq(2);		
					
					
					
					File file = new File("arima_loadsum_bih2.csv");
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);				
					
    				for (int i=365; i<res.length-1; i++) {
								arimaModelService.prepareDataArrayPart(i);
								arimaModelService.trainArima();		
								
								System.out.println(i + ".  "+arimaModelService.getDataArray()[i] + "," + arimaModelService.getForecastData()[0]);
								
								bw.write(arimaModelService.getDataArray()[i] + "," + arimaModelService.getForecastData()[0] + "\n");									
								
								//System.out.println(i + " , MAPE : " + arimaModelService.getMape());
    				}
					
					bw.close(); 
					
		
//		arimaModelService.setDataArray(res);
//		arimaModelService.setpForecastSize(5);
//								
//		
//		for (int p=1; p<25; p++)
//			for (int d=1; d<25; d++)
//				for (int q=1; q<25; q++) {
//
//					arimaModelService.setPp(p);
//					arimaModelService.setPd(d);
//					arimaModelService.setPq(q);
//										
//					arimaModelService.prepareDataArrayPart(365); //8760
//					arimaModelService.trainArima();	
//					
//					if ((arimaModelService.getMape() < 5)&&(arimaModelService.getMape() >= 0))
//						System.out.println(p + " - " + d + " - " + q + " - " + " , MAPE : " + arimaModelService.getMape());					
//					
//				}		
		
		
		
		System.out.println("END...");
		
		
		
		
	}
	

}
