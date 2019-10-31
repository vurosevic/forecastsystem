package com.deloitte.forecastsystem.loadforecast.datamanipulation;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.exportsqltocsv.ExportSqlToCsv;

public class DataManipulationHoursLoad implements DataManipulation {

	CountriesEnum country;
	private final String connectionUrl = "jdbc:mysql://localhost/deloitteforecast?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false";
	private final String startPath = "c:/data/hours/";
	
	public DataManipulationHoursLoad() {
		this.country = CountriesEnum.CO_RS;
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
			case CO_HU: res = "data-hu-hours.csv";
						break;
			case CO_RO: res = "data-ro-hours.csv";
						break;
			case CO_CR: res = "data-cr-hours.csv";
						break;						
			case CO_CZ: res = "data-cz-hours.csv";
						break;						
			case CO_SK: res = "data-sk-hours.csv";
						break;
			case CO_SL: res = "data-sl-hours.csv";
						break;						
			case CO_PO: res = "data-po-hours.csv";
						break;
			case CO_BL: res = "data-bl-hours.csv";
						break;					
			case CO_GR: res = "data-gr-hours.csv";
						break;					
			case CO_AT: res = "data-at-hours.csv";
						break;
			case CO_ME: res = "data-me-hours.csv";
						break;						
			default:
					res = "data-rs-hours.csv";
		}
		
		return startPath + res;
	}
	
	public String getQueryString() {
		String res = null;
		switch (this.country) {
		case CO_RS: res = "select * from vw_input_data_all_by_hour_rs";
					break;
		case CO_BIH: res = "select * from vw_input_data_all_by_hour_bih";
					break;
		case CO_HU: res = "select * from vw_input_data_all_by_hour_hu";
					break;
		case CO_RO: res = "select * from vw_input_data_all_by_hour_ro";
					break;
		case CO_CR: res = "select * from vw_input_data_all_by_hour_cr";
					break;						
		case CO_CZ: res = "select * from vw_input_data_all_by_hour_cz";
					break;						
		case CO_SK: res = "select * from vw_input_data_all_by_hour_sk";
					break;
		case CO_SL: res = "select * from vw_input_data_all_by_hour_sl";
					break;						
		case CO_PO: res = "select * from vw_input_data_all_by_hour_po";
					break;
		case CO_BL: res = "select * from vw_input_data_all_by_hour_bl";
					break;					
		case CO_GR: res = "select * from vw_input_data_all_by_hour_gr";
					break;					
		case CO_AT: res = "select * from vw_input_data_all_by_hour_at";
					break;
		case CO_ME: res = "select * from vw_input_data_all_by_hour_me";
					break;					
		default:
				res = "select * from vw_input_data_all_by_hour_rs";
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
