package com.deloitte.forecastsystem.loadforecast.datamanipulation;

import com.deloitte.forecastsystem.loadforecast.config.CountriesEnum;
import com.deloitte.forecastsystem.loadforecast.exportsqltocsv.ExportSqlToCsv;

public class DataManipulationSumLoad implements DataManipulation {

	CountriesEnum country;
	private final String connectionUrl = "jdbc:mysql://localhost/deloitteforecast?user=epss&password=epss.EPSS&useUnicode=yes&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=false";
	private final String startPath = "c:/data/sum/";
	
	public DataManipulationSumLoad() {
		this.country = CountriesEnum.CO_RS;
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
			case CO_HU: res = "data-hu-sum.csv";
						break;
			case CO_RO: res = "data-ro-sum.csv";
						break;
			case CO_CR: res = "data-cr-sum.csv";
						break;						
			case CO_CZ: res = "data-cz-sum.csv";
						break;						
			case CO_SK: res = "data-sk-sum.csv";
						break;
			case CO_SL: res = "data-sl-sum.csv";
						break;						
			case CO_PO: res = "data-po-sum.csv";
						break;
			case CO_BL: res = "data-bl-sum.csv";
						break;					
			case CO_GR: res = "data-gr-sum.csv";
						break;					
			case CO_AT: res = "data-at-sum.csv";
						break;
			case CO_ME: res = "data-me-sum.csv";
						break;						
			default:
					res = "data-rs-sum.csv";
		}
		
		return startPath + res;
	}
	
	public String getQueryString() {
		String res = null;
		switch (this.country) {
		case CO_RS: res = "select * from vw_input_data_rs_sum";
					break;
		case CO_BIH: res = "select * from vw_input_data_bih_sum";
					break;
		case CO_HU: res = "select * from vw_input_data_hu_sum";
					break;
		case CO_RO: res = "select * from vw_input_data_ro_sum";
					break;
		case CO_CR: res = "select * from vw_input_data_cr_sum";
					break;						
		case CO_CZ: res = "select * from vw_input_data_cz_sum";
					break;						
		case CO_SK: res = "select * from vw_input_data_sk_sum";
					break;
		case CO_SL: res = "select * from vw_input_data_sl_sum";
					break;						
		case CO_PO: res = "select * from vw_input_data_po_sum";
					break;
		case CO_BL: res = "select * from vw_input_data_bl_sum";
					break;					
		case CO_GR: res = "select * from vw_input_data_gr_sum";
					break;					
		case CO_AT: res = "select * from vw_input_data_at_sum";
					break;
		case CO_ME: res = "select * from vw_input_data_me_sum";
					break;					
		default:
				res = "select * from vw_input_data_rs_sum";
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
