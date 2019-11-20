package deloitte.forecastsystem_bih.loadforecast.config;

public enum CountriesEnum {
	CO_RS, CO_BIH;
    
	public final int value;
	
	private CountriesEnum() {
		// TODO Auto-generated constructor stub
		value = 0;
	}
	
	CountriesEnum(final int value) {
	     this.value = value;
	  }
 }
