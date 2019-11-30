package deloitte.forecastsystem_bih.loadforecast.similarday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.geometry.euclidean.threed.NotARotationMatrixException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.service.CountryService;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

@Service("similarDayService")
@Configurable
public class SimilarDayService {
	
	Long id;
	Country con;
	Double maxTemperature;
	Double maxFeelslike;
	Double maxRealLoad;
	Double minTemperature;
	Double minFeelslike;
	Double minRealLoad;	
	
	List<PreparedDataLoadHoursRecord> data;
	
	List<PreparedDataLoadHoursRecord> dataByHour;
	
	List<PreparedDataLoadHoursRecord> normalizedData;
	List<Double> distance;
	
	@Autowired 
	PreparedDataLoadHoursService preparedDataLoadHoursService;
	
	@Autowired
	CountryService countryService;	
	
	public SimilarDayService() {
		// TODO Auto-generated constructor stub
		normalizedData = new ArrayList<PreparedDataLoadHoursRecord>();		
		distance = new ArrayList<Double>();			
	}
	
	public SimilarDayService(Country con, Long id, Integer loadHour) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.id = id;
		
		this.maxTemperature = preparedDataLoadHoursService.getDataForSimilarDayMaxTemp(con);
		this.minTemperature = preparedDataLoadHoursService.getDataForSimilarDayMinTemp(con);
		this.maxFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMaxFeelslike(con);
		this.minFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMaxFeelslike(con);
		this.maxRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMaxRealData(con);
		this.minRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMinRealData(con);		
		this.data = preparedDataLoadHoursService.getDataForSimilarDay(con, loadHour); 
		
		this.dataByHour = preparedDataLoadHoursService.getDataForSimilarDay(con, id, loadHour);
		
//		normalizedData = new ArrayList<PreparedDataLoadHoursRecord>();		
		distance = new ArrayList<Double>();		
	}
	
	public void set(Country con, Long id, Integer loadHour) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.id = id;
		
		this.maxTemperature = preparedDataLoadHoursService.getDataForSimilarDayMaxTemp(con);
		this.minTemperature = preparedDataLoadHoursService.getDataForSimilarDayMinTemp(con);
		this.maxFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMaxFeelslike(con);
		this.minFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMinFeelslike(con);
		this.maxRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMaxRealData(con);
		this.minRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMinRealData(con);		
		this.data = preparedDataLoadHoursService.getDataForSimilarDay(con, loadHour); 
		
		this.dataByHour = preparedDataLoadHoursService.getDataForSimilarDay(con, id, loadHour);
		
//		normalizedData = new ArrayList<PreparedDataLoadHoursRecord>();	
		distance = new ArrayList<Double>();		
	}
	
	public void set(Country con, Long id) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.id = id;
		
		this.maxTemperature = preparedDataLoadHoursService.getDataForSimilarDayMaxTemp(con);
		this.minTemperature = preparedDataLoadHoursService.getDataForSimilarDayMinTemp(con);
		this.maxFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMaxFeelslike(con);
		this.minFeelslike = preparedDataLoadHoursService.getDataForSimilarDayMinFeelslike(con);
		this.maxRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMaxRealData(con);
		this.minRealLoad = preparedDataLoadHoursService.getDataForSimilarDayMinRealData(con);		
		this.data = preparedDataLoadHoursService.getDataForSimilarDay(con); 		
		this.dataByHour = preparedDataLoadHoursService.getDataForSimilarDay(con);
		
//		normalizedData = new ArrayList<PreparedDataLoadHoursRecord>();	
		distance = new ArrayList<Double>();		
	}		
	
	public void normalizeData() {
		
		Double normTemperature4;
		Double normFeelslike4;
		Double normRealLoad4;
		Double normTemperature3;
		Double normFeelslike3;
		Double normRealLoad3;
		Double normTemperature2;
		Double normFeelslike2;
		Double normRealLoad2;
		
		Double tempConst = (this.maxTemperature - this.minTemperature);
		Double feelslikeConst = (this.maxFeelslike - this.minFeelslike);
		Double realLoadConst = (this.maxRealLoad - this.minRealLoad);
		
		for (PreparedDataLoadHoursRecord rec : data) {
			
			normTemperature4 = Math.abs(rec.getAvgTemperature4() - this.minTemperature) / tempConst;
			normTemperature3 = Math.abs(rec.getAvgTemperature3() - this.minTemperature) / tempConst;
			normTemperature2 = Math.abs(rec.getAvgTemperature2() - this.minTemperature) / tempConst;
			
			normFeelslike4 = Math.abs(rec.getAvgFeelslike4() - this.minFeelslike) / feelslikeConst;
			normFeelslike3 = Math.abs(rec.getAvgFeelslike3() - this.minFeelslike) / feelslikeConst;
			normFeelslike2 = Math.abs(rec.getAvgFeelslike2() - this.minFeelslike) / feelslikeConst;
			
			normRealLoad4 = Math.abs(rec.getAvgLoadRealData4() - this.minRealLoad) / realLoadConst;
			normRealLoad3 = Math.abs(rec.getAvgLoadRealData3() - this.minRealLoad) / realLoadConst;
			normRealLoad2 = Math.abs(rec.getAvgLoadRealData2() - this.minRealLoad) / realLoadConst;	
			
			normalizedData.add(new PreparedDataLoadHoursRecord(this.id, normTemperature4, normFeelslike4, normRealLoad4, 
																normTemperature3, normFeelslike3, normRealLoad3, 
																normTemperature2, normFeelslike2, normRealLoad2, 
																rec.getAvgLoadRealData()));
			
		}
		
	}
	
	public void calculateDistance(PreparedDataLoadHoursRecord rec) {
		
		Double normTemperature4;
		Double normFeelslike4;
		Double normRealLoad4;
		Double normTemperature3;
		Double normFeelslike3;
		Double normRealLoad3;
		Double normTemperature2;
		Double normFeelslike2;
		Double normRealLoad2;
		
		Double tempConst = (this.maxTemperature - this.minTemperature);
		Double feelslikeConst = (this.maxFeelslike - this.minFeelslike);
		Double realLoadConst = (this.maxRealLoad - this.minRealLoad);
		
		normTemperature4 = Math.abs(rec.getAvgTemperature4() - this.minTemperature) / tempConst;
		normTemperature3 = Math.abs(rec.getAvgTemperature3() - this.minTemperature) / tempConst;
		normTemperature2 = Math.abs(rec.getAvgTemperature2() - this.minTemperature) / tempConst;
		
		normFeelslike4 = Math.abs(rec.getAvgFeelslike4() - this.minFeelslike) / feelslikeConst;
		normFeelslike3 = Math.abs(rec.getAvgFeelslike3() - this.minFeelslike) / feelslikeConst;
		normFeelslike2 = Math.abs(rec.getAvgFeelslike2() - this.minFeelslike) / feelslikeConst;
		
		normRealLoad4 = Math.abs(rec.getAvgLoadRealData4() - this.minRealLoad) / realLoadConst;
		normRealLoad3 = Math.abs(rec.getAvgLoadRealData3() - this.minRealLoad) / realLoadConst;
		normRealLoad2 = Math.abs(rec.getAvgLoadRealData2() - this.minRealLoad) / realLoadConst;	
		
		for (int i=0; i<this.id; i++) {			
			
			Double dist = 0.0;			
			Double sum = 0.0;
			
			sum += Math.pow(normTemperature4 - normalizedData.get(i).getAvgTemperature4(),2) * 1;
			sum += Math.pow(normFeelslike4 - normalizedData.get(i).getAvgFeelslike4(),2) * 1.4;
			sum += Math.pow(normRealLoad4 - normalizedData.get(i).getAvgLoadRealData4(),2) * 2.0;			
			sum += Math.pow(normTemperature3 - normalizedData.get(i).getAvgTemperature3(),2) * 1.2;
			sum += Math.pow(normFeelslike3 - normalizedData.get(i).getAvgFeelslike3(),2) * 1.6;
			sum += Math.pow(normRealLoad3 - normalizedData.get(i).getAvgLoadRealData3(),2) * 2.6;
			sum += Math.pow(normTemperature2 - normalizedData.get(i).getAvgTemperature2(),2) * 1.4;
			sum += Math.pow(normFeelslike2 - normalizedData.get(i).getAvgFeelslike2(),2) * 1.8;
			sum += Math.pow(normRealLoad2 - normalizedData.get(i).getAvgLoadRealData2(),2) * 3.2;			
			
			dist = Math.sqrt(sum);			
			distance.add(dist);
			
		}
		
	}
	
	public int getMinIndex() {
		int minIndex = 0;
		Double minValue = distance.get(0);
		
		for (int i=1; i<distance.size()-1; i++) {
			if (minValue > distance.get(i)) {
				minValue = distance.get(i);
				minIndex = i;
			}
		}
				
		return minIndex;
	}
	
	public Double getForecast() {
		return normalizedData.get(getMinIndex()).getAvgLoadRealData();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCon() {
		return con;
	}

	public void setCon(Country con) {
		this.con = con;
	}

	public Double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public Double getMaxFeelslike() {
		return maxFeelslike;
	}

	public void setMaxFeelslike(Double maxFeelslike) {
		this.maxFeelslike = maxFeelslike;
	}

	public Double getMaxRealLoad() {
		return maxRealLoad;
	}

	public void setMaxRealLoad(Double maxRealLoad) {
		this.maxRealLoad = maxRealLoad;
	}

	public Double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Double getMinFeelslike() {
		return minFeelslike;
	}

	public void setMinFeelslike(Double minFeelslike) {
		this.minFeelslike = minFeelslike;
	}

	public Double getMinRealLoad() {
		return minRealLoad;
	}

	public void setMinRealLoad(Double minRealLoad) {
		this.minRealLoad = minRealLoad;
	}

	public List<PreparedDataLoadHoursRecord> getData() {
		return data;
	}

	public void setData(List<PreparedDataLoadHoursRecord> data) {
		this.data = data;
	}

	public List<PreparedDataLoadHoursRecord> getNormalizedData() {
		return normalizedData;
	}

	public void setNormalizedData(List<PreparedDataLoadHoursRecord> normalizedData) {
		this.normalizedData = normalizedData;
	}

	public List<Double> getDistance() {
		return distance;
	}

	public void setDistance(List<Double> distance) {
		this.distance = distance;
	}
	
	

}




