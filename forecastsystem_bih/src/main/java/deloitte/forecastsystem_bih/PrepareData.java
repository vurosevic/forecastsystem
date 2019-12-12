package deloitte.forecastsystem_bih;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.forecastsystem_bih.commandcenter.CommandCenter;
import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.service.CountryService;

@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class PrepareData implements CommandLineRunner {
	
	@Autowired
	CountryService countryService; 	

	@Autowired
	CommandCenter commandCenter; 		
	
	public static void main(String[] args) {
		SpringApplication.run(PrepareData.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("PREPARE DATA SERVICE: ");
		
		Country con = countryService.findById(2L);		
		
		commandCenter.runPreparePartialInputDataHourlyStart();
		commandCenter.runPartialArimaService();
		commandCenter.runPartialSimilarDayService();
		commandCenter.runPreparePartialInputDataHourlyComplete();
		
		System.out.println("END. ");
	}

}
