package com.deloitte.forecastsystem.loadforecast.datamanipulation;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.exportsqltocsv.ExportSqlToCsv;

public class DataManipulationAvgLoad implements DataManipulation {
	
	CountriesEnum country;
	private final String connectionUrl = "jdbc:mysql://localhost/deloitteforecast?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false";
	private final String startPath = "c:/data/";
	
	public DataManipulationAvgLoad() {
		this.country = CountriesEnum.CO_RS;
	}
	
	public DataManipulationAvgLoad(CountriesEnum country) {
		this.country = country;		
	}
	
	public String getFileName() {
		String res = null;
		
		switch (this.country) {
			case CO_RS: res = "data-rs-new.csv";
						break;
			case CO_BIH: res = "data-bih-new.csv";
						break;
			case CO_HU: res = "data-hu-new.csv";
						break;
			case CO_RO: res = "data-ro-new.csv";
						break;
			case CO_CR: res = "data-cr-new.csv";
						break;						
			case CO_CZ: res = "data-cz-new.csv";
						break;						
			case CO_SK: res = "data-sk-new.csv";
						break;
			case CO_SL: res = "data-sl-new.csv";
						break;						
			case CO_PO: res = "data-po-new.csv";
						break;
			case CO_BL: res = "data-bl-new.csv";
						break;					
			case CO_GR: res = "data-gr-new.csv";
						break;					
			case CO_AT: res = "data-at-new.csv";
						break;
			case CO_ME: res = "data-me-new.csv";
						break;						
			default:
					res = "data-rs-new.csv";
		}
		
		return startPath + res;
	}
	
	public String getQueryString() {
		String res = null;
		switch (this.country) {
		case CO_RS: res = "select * from vw_input_data_rs_new";
					break;
		case CO_BIH: res = "select * from vw_input_data_bih_new";
					break;
		case CO_HU: res = "select * from vw_input_data_hu_new";
					break;
		case CO_RO: res = "select * from vw_input_data_ro_new";
					break;
		case CO_CR: res = "select * from vw_input_data_cr_new";
					break;						
		case CO_CZ: res = "select * from vw_input_data_cz_new";
					break;						
		case CO_SK: res = "select * from vw_input_data_sk_new";
					break;
		case CO_SL: res = "select * from vw_input_data_sl_new";
					break;						
		case CO_PO: res = "select * from vw_input_data_po_new";
					break;
		case CO_BL: res = "select * from vw_input_data_bl_new";
					break;					
		case CO_GR: res = "select * from vw_input_data_gr_new";
					break;					
		case CO_AT: res = "select * from vw_input_data_at_new";
					break;
		case CO_ME: res = "select * from vw_input_data_me_new";
					break;					
		default:
				res = "select * from vw_input_data_rs_new";
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
