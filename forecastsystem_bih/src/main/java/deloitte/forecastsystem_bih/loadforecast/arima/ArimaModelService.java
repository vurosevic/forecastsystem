package deloitte.forecastsystem_bih.loadforecast.arima;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.workday.insights.timeseries.arima.Arima;
import com.workday.insights.timeseries.arima.struct.ArimaParams;
import com.workday.insights.timeseries.arima.struct.ForecastResult;

@Service("arimaModelService")
@Configurable
public class ArimaModelService {
	
	int pp;
	int pd;
	int pq;
	int pP;
	int pD;
	int pQ;
	int pm;
	int pForecastSize;
	double[] dataArrayPart = null;
	double[] dataArray = null;
	ArimaParams apar;
	ForecastResult forecastResult;
	double[] forecastData;

	public ArimaModelService() {
		// TODO Auto-generated constructor stub
		pp = 8;
		pd = 1;
		pq = 4;
		pP = 1;
		pD = 1;
		pQ = 0;
		pm = 0;
		pForecastSize = 5;
		dataArray = null;		
	}	
	
	public ArimaModelService(int p, int d, int q, int P, int D, int Q, int m, int forecastSize, double[] dataArray) {
		// TODO Auto-generated constructor stub
		this.pp = p; //8
		this.pd = d; //1
		this.pq = q; //4
		this.pP = P; //1
		this.pD = D; //1
		this.pQ = Q; //0
 		this.pm = m; //0
		this.pForecastSize = forecastSize; //5
		this.dataArray = dataArray; 		
		apar = new ArimaParams(pp, pd, pq, pP, pD, pQ, pm);
		forecastResult = Arima.forecast_arima(dataArray, pForecastSize, apar);
		forecastData = forecastResult.getForecast();
	}
	
	public void prepareDataArrayPart(int count) {
		dataArrayPart = new double[count];
		for (int i=0; i<count; i++) {
			dataArrayPart[i] = dataArray[i];
		}
	}
	
	public void prepareDataArrayPart(int start, int count) {
		dataArrayPart = new double[count];
		for (int i=0; i<count; i++) {
			dataArrayPart[i] = dataArray[start + i];
		}
	}	
	
	public void trainArima() {
		apar = new ArimaParams(pp, pd, pq, pP, pD, pQ, pm);
		forecastResult = Arima.forecast_arima(dataArrayPart, pForecastSize, apar);
		forecastData = forecastResult.getForecast();		
	}
	
	public Double getMape() {
		
		if (forecastData == null)			
		    return Double.NaN;
		
		if (forecastData.length == 0)			
		    return Double.NaN;		
		
		if (dataArrayPart == null)			
		    return Double.NaN;
		
		if (dataArrayPart.length == 0)			
		    return Double.NaN;		
		
		Double res = 0.0;
		
		for (int i=0; i<forecastData.length; i++) {
			res += Math.abs(dataArray[dataArrayPart.length+i] - forecastData[i])/dataArray[dataArrayPart.length+i];
		}
		
		res = res / forecastData.length * 100;
		
		return res;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getPd() {
		return pd;
	}

	public void setPd(int pd) {
		this.pd = pd;
	}

	public int getPq() {
		return pq;
	}

	public void setPq(int pq) {
		this.pq = pq;
	}

	public int getpP() {
		return pP;
	}

	public void setpP(int pP) {
		this.pP = pP;
	}

	public int getpD() {
		return pD;
	}

	public void setpD(int pD) {
		this.pD = pD;
	}

	public int getpQ() {
		return pQ;
	}

	public void setpQ(int pQ) {
		this.pQ = pQ;
	}

	public int getPm() {
		return pm;
	}

	public void setPm(int pm) {
		this.pm = pm;
	}

	public int getpForecastSize() {
		return pForecastSize;
	}

	public void setpForecastSize(int pForecastSize) {
		this.pForecastSize = pForecastSize;
	}

	public double[] getDataArray() {
		return dataArray;
	}

	public void setDataArray(double[] dataArray) {
		this.dataArray = dataArray;
	}

	public double[] getForecastData() {
		return forecastData;
	}

	
	

}
