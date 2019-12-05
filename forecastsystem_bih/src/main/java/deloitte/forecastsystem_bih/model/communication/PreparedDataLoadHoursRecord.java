package deloitte.forecastsystem_bih.model.communication;
public class PreparedDataLoadHoursRecord {
	
	Long id;
	Double avgTemperature4;
	Double avgFeelslike4;
	Double avgLoadRealData4;
	Double avgTemperature3;
	Double avgFeelslike3;
	Double avgLoadRealData3;
	Double avgTemperature2;
	Double avgFeelslike2;
	Double avgLoadRealData2;
	Double avgLoadRealData;
	
	public PreparedDataLoadHoursRecord() {
		// TODO Auto-generated constructor stub
		this.id = 0L;
	}
	
	public PreparedDataLoadHoursRecord( Long id, 
										Double avgTemperature4, Double avgFeelslike4,   Double avgLoadRealData4,
										Double avgTemperature3, Double avgFeelslike3, 	Double avgLoadRealData3, 
										Double avgTemperature2, Double avgFeelslike2, 	Double avgLoadRealData2,
										Double avgLoadRealData) {
		this.id = id;
		this.avgTemperature4 = avgTemperature4;
		this.avgFeelslike4 = avgFeelslike4;
		this.avgLoadRealData4 = avgLoadRealData4;		
		this.avgTemperature3 = avgTemperature3;
		this.avgFeelslike3 = avgFeelslike3;
		this.avgLoadRealData3 = avgLoadRealData3;		
		this.avgTemperature2 = avgTemperature2;
		this.avgFeelslike2 = avgFeelslike2;
		this.avgLoadRealData2 = avgLoadRealData2;		
		this.avgLoadRealData = avgLoadRealData;				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAvgTemperature4() {
		return avgTemperature4;
	}

	public void setAvgTemperature4(Double avgTemperature4) {
		this.avgTemperature4 = avgTemperature4;
	}

	public Double getAvgFeelslike4() {
		return avgFeelslike4;
	}

	public void setAvgFeelslike4(Double avgFeelslike4) {
		this.avgFeelslike4 = avgFeelslike4;
	}

	public Double getAvgLoadRealData4() {
		return avgLoadRealData4;
	}

	public void setAvgLoadRealData4(Double avgLoadRealData4) {
		this.avgLoadRealData4 = avgLoadRealData4;
	}

	public Double getAvgTemperature3() {
		return avgTemperature3;
	}

	public void setAvgTemperature3(Double avgTemperature3) {
		this.avgTemperature3 = avgTemperature3;
	}

	public Double getAvgFeelslike3() {
		return avgFeelslike3;
	}

	public void setAvgFeelslike3(Double avgFeelslike3) {
		this.avgFeelslike3 = avgFeelslike3;
	}

	public Double getAvgLoadRealData3() {
		return avgLoadRealData3;
	}

	public void setAvgLoadRealData3(Double avgLoadRealData3) {
		this.avgLoadRealData3 = avgLoadRealData3;
	}

	public Double getAvgTemperature2() {
		return avgTemperature2;
	}

	public void setAvgTemperature2(Double avgTemperature2) {
		this.avgTemperature2 = avgTemperature2;
	}

	public Double getAvgFeelslike2() {
		return avgFeelslike2;
	}

	public void setAvgFeelslike2(Double avgFeelslike2) {
		this.avgFeelslike2 = avgFeelslike2;
	}

	public Double getAvgLoadRealData2() {
		return avgLoadRealData2;
	}

	public void setAvgLoadRealData2(Double avgLoadRealData2) {
		this.avgLoadRealData2 = avgLoadRealData2;
	}

	public Double getAvgLoadRealData() {
		return avgLoadRealData;
	}

	public void setAvgLoadRealData(Double avgLoadRealData) {
		this.avgLoadRealData = avgLoadRealData;
	}
	
}
