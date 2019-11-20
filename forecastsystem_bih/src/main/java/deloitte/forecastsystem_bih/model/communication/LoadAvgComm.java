package deloitte.forecastsystem_bih.model.communication;

import java.util.Calendar;
import java.util.Date;

public class LoadAvgComm {
	int lacday;
	int lacmonth;
	int lacyear;
	int laccountry;
	
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

	public Date getDate() {
		Calendar date = Calendar.getInstance();
		date.set(this.lacyear, this.lacmonth, this.lacday);
		return date.getTime();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LoadAvgComm record: " + lacday + "." + lacmonth + "." + lacyear + " / " + laccountry;
	}
}
