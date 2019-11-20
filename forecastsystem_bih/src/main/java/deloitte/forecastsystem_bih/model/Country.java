package deloitte.forecastsystem_bih.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_country")
public class Country {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, updatable = true)
	private Long id;	
	
	@Column(name="Name", nullable=false, unique=true)
	private String name;	
	
	@Column(name="Shortcut", nullable=false, unique=true)
	private String shortcut;	
	
	@Column(name="Weatherlink", nullable=false, unique=true)
	private String weather;	

	@Column(name="City", nullable=false, unique=true)
	private String city;	
	
	@Column(name="Loadlink", nullable=false, unique=true)
	private String load;

	@Column(name="Latitude", nullable=false, unique=false)
	private Double latitude;
	
	@Column(name="Longitude", nullable=false, unique=false)
	private Double longitude;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}		
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " : " + this.name + ", " + this.shortcut + ", " + this.city;
	}
}
