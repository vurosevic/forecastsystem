package deloitte.forecastsystem_bih.model.communication;

public class LoadHoursCommRecords {
	
	int lachour;
	int lacday;
	int lacmonth;
	int lacyear;
	int laccountry;
	double lacForecast;
	double lacRealLoad;
	public int getLachour() {
		return lachour;
	}
	public void setLachour(int lachour) {
		this.lachour = lachour;
	}
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
	public double getLacForecast() {
		return lacForecast;
	}
	public void setLacForecast(double lacForecast) {
		this.lacForecast = lacForecast;
	}
	public double getLacRealLoad() {
		return lacRealLoad;
	}
	public void setLacRealLoad(double lacRealLoad) {
		this.lacRealLoad = lacRealLoad;
	}	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LoadHoursComm record: " +lachour + "h " + lacday + "." + lacmonth + "." + lacyear + " / " + laccountry + ", Forecast: " + getLacForecast() + ", RealLoad: " + lacRealLoad;      
	}	
}
