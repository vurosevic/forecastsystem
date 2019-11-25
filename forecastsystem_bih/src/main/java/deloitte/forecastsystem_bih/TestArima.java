package deloitte.forecastsystem_bih;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.loadforecast.arima.ArimaModelService;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;


//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class TestArima  implements CommandLineRunner  {
	
//	@Autowired
//	PreparedDataLoadSumService preparedDataLoadSumService;
//	
//	@Autowired
//	PreparedDataLoadAvgService preparedDataLoadAvgService; 	
	
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
		
//		double[] res = preparedDataLoadSumService.getAllRealDataLoadSumByCountry(con);
		//double[] res = preparedDataLoadAvgService.getAllRealDataLoadAvgByCountry(con);
		double[] res = preparedDataLoadHoursService.getAllRealDataLoadHoursByCountry(con);
		
		
//		for (int i=0; i<res.length; i++) {
//			  System.out.print(res[i] + " ");	
//		}
//		
//		System.out.println("");
		
		arimaModelService.setDataArray(res);
		arimaModelService.setpForecastSize(1);		

//		arimaModelService.setPm(6);
//		arimaModelService.setpP(4);
//		arimaModelService.setpD(1);
//		arimaModelService.setpQ(5);
//		arimaModelService.setPp(1); 
//		arimaModelService.setPd(0); 
//		arimaModelService.setPq(0); 					
		
					arimaModelService.setPp(24); 
					arimaModelService.setPd(1); 
					arimaModelService.setPq(1); 
		
	//					arimaModelService.setPp(7);
	//					arimaModelService.setPd(1);
	//					arimaModelService.setPq(2);		
					
					
					
					File file = new File("arima_loadsum_bih_4.csv");
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);				
					
    				for (int i=8760; i<res.length-1; i++) {
								arimaModelService.prepareDataArrayPart(i);
								//arimaModelService.prepareDataArrayPart(i, 17520);
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
//					arimaModelService.prepareDataArrayPart(10000); //8760
//					arimaModelService.trainArima();	
//					
//					if ((arimaModelService.getMape() < 5)&&(arimaModelService.getMape() >= 0))
//						System.out.println(p + " - " + d + " - " + q + " - " + " , MAPE : " + arimaModelService.getMape());					
//					
//				}		

		
//		arimaModelService.setDataArray(res);
//		arimaModelService.setpForecastSize(5);
//								
//		
//	for (int m=1; m<10; m++) 
//	{
//		System.out.println(m + ". ----------M---------------------------");
//		for (int p=1; p<10; p++) {
//			for (int d=1; d<10; d++)
//				for (int q=1; q<10; q++) {
//
//					arimaModelService.setPm(m);
//					arimaModelService.setpP(p);
//					arimaModelService.setpD(d);
//					arimaModelService.setpQ(q);
//					arimaModelService.setPp(1); 
//					arimaModelService.setPd(0); 
//					arimaModelService.setPq(0); 					
//										
//					arimaModelService.prepareDataArrayPart(8760); 
//					arimaModelService.trainArima();	
//					
//					if ((arimaModelService.getMape() < 3)&&(arimaModelService.getMape() >= 0))
//						System.out.println(p + " - " + d + " - " + q + " - " + " , MAPE : " + arimaModelService.getMape());					
//					
//				}
//		}
//	}
		
		
		System.out.println("END...");
		
		
		
		
	}
	

}
