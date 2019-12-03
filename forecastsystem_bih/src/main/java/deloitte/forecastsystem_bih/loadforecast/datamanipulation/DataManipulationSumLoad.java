package deloitte.forecastsystem_bih.loadforecast.datamanipulation;

import deloitte.forecastsystem_bih.loadforecast.config.CountriesEnum;
import deloitte.forecastsystem_bih.loadforecast.exporttocsv.ExportSqlToCsv; 

public class DataManipulationSumLoad implements DataManipulation {

	CountriesEnum country;
	private final String connectionUrl = "jdbc:mysql://localhost/deloitteforecast_bih?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false";
	private final String startPath = "c:/data/bih/sum/";
	
	public DataManipulationSumLoad() {
		this.country = CountriesEnum.CO_BIH;
	}
	
	public DataManipulationSumLoad(CountriesEnum country) {
		this.country = country;		
	}
	
	public String getFileName() {
		String res = null;
		
		switch (this.country) {
			case CO_RS: res = "data-rs-sum.csv";
						break;
			case CO_BIH: res = "data-bih-sum.csv";
						break;					
			default:
					res = "data-bih-sum.csv";
		}
		
		return startPath + res;
	}
	
	public String getQueryString() {
		String res = null;
		switch (this.country) {
		case CO_RS: res = "select * from dual";
					break;
		case CO_BIH: res = "select * from vw_input_data_sum_bih";
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
