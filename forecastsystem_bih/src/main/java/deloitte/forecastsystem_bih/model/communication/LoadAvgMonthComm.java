package deloitte.forecastsystem_bih.model.communication;

public class LoadAvgMonthComm {
	int lacday;
	int lacmonth;
	int lacyear;
	int laccountry;
	double forecastload;
	double realload;
	public int getLacday() {
		return lacday;
	}
	public void setLacday(int lacday) {
		this.lacday = lacday;
	}
	public int getLacmonth() {
		return lacmonth;
	}
	public void setLacmonth(int lacmonth) {
		this.lacmonth = lacmonth;
	}
	public int getLacyear() {
		return lacyear;
	}
	public void setLacyear(int lacyear) {
		this.lacyear = lacyear;
	}
	public int getLaccountry() {
		return laccountry;
	}
	public void setLaccountry(int laccountry) {
		this.laccountry = laccountry;
	}
	public double getForecastload() {
		return forecastload;
	}
	public void setForecastload(double forecastload) {
		this.forecastload = forecastload;
	}
	public double getRealload() {
		return realload;
	}
	public void setRealload(double realload) {
		this.realload = realload;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LoadAvgComm record: " + lacday + "." + lacmonth + "." + lacyear + " / " + laccountry + ", Forecast: " + forecastload + ", Real load: " + realload; 
	}
}
