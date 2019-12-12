package deloitte.forecastsystem_bih;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

//@SpringBootApplication(scanBasePackages={"deloitte.*"})
public class App implements CommandLineRunner 
{
    public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);

    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("-----------------");
		System.out.println("DELOITTE FORECAST");
		System.out.println("-----------------");
		
	}
}
