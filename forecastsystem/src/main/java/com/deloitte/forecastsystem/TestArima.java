package com.deloitte.forecastsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.service.CountryService;
import com.deloitte.forecastsystem.service.PreparedDataLoadSumService;
import com.deloitte.forecastsystem.service.impl.PreparedDataLoadSumServiceImpl;

//@SpringBootApplication(scanBasePackages={"com.*"})
public class TestArima  implements CommandLineRunner  {
	
	@Autowired
	PreparedDataLoadSumService preparedDataLoadSumService; 
	
	@Autowired
	CountryService countryService; 
	
	public static void main(String[] args){

		SpringApplication.run(TestArima.class, args);		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("TEST ARIMA: ");
		
		Country con = countryService.findById(1L);
		
		double[] res = preparedDataLoadSumService.getAllRealDataLoadSumByCountry(con);
		
		for (int i=0; i<res.length; i++) {
			  System.out.print(res[i] + " ");	
		}
		
		System.out.println("");
		
		
		
		System.out.println("END...");
		
		
		
		
	}
	

}
