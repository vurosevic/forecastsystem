package deloitte.forecastsystem_bih.loadforecast.datamanipulation;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.exporttocsv.ExportSqlToCsv;

public class DataManipulationHoursLoad implements DataManipulation {

	CountriesEnum country;
	private final String connectionUrl = "jdbc:mysql://localhost/deloitteforecast_bih?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false";
	private final String startPath = "c:/data/bih/hours/";
	
	public DataManipulationHoursLoad() {
		this.country = CountriesEnum.CO_BIH;
	}
	
	public DataManipulationHoursLoad(CountriesEnum country) {
		this.country = country;		
	}
	
	public String getFileName() {
		String res = null;
		
		switch (this.country) {
			case CO_RS: res = "data-rs-hours.csv";
						break;
			case CO_BIH: res = "data-bih-hours.csv";
						break;					
			default:
					res = "data-bih-hours.csv";
		}
		
		return startPath + res;
	}
	
	public String getQueryString() {
		String res = null;
		switch (this.country) {
		case CO_RS: res = "select * from dual";
					break;
		case CO_BIH: res = "select * from vw_prepared_data_bih_complete";
					break;					
		default:
				res = "select * from dual";
		}
		return res;		
	}
	
	public boolean prepareDataForTraining() {
		
		try {		
			ExportSqlToCsv stc = new ExportSqlToCsv(this.getFileName(), this.getQueryString(), this.getConnectionUrl(), false);        
			stc.sqlToCSV();
		} catch (Exception ex) {
			return false;
		}
		return true;
		
	}

	public CountriesEnum getCountry() {
		return country;
	}

	public void setCountry(CountriesEnum country) {
		this.country = country;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}
	


}
