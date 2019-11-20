/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "df_load")
public class Load implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7491931014998259104L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Basic(optional = false)              
    private Long id;  

    @ManyToOne
    @JoinColumn(name = "Country_fk")
    private Country country;
    
    @Column(name = "Load_date")
    private Date loadDate;    
    
    @Column(name = "Load_hour")
    private Integer loadHour;        

    @Column(name = "Load_minute")
    private Integer loadMinute;
    
    @Column(name = "Load_forecast_entsoe")
    private Integer loadForecatEntsoe; 
    
    @Column(name = "Load_real_data")
    private Integer loadRealData;     

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the loadDate
     */
    public Date getLoadDate() {
        return loadDate;
    }

    /**
     * @param loadDate the loadDate to set
     */
    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    /**
     * @return the loadHour
     */
    public Integer getLoadHour() {
        return loadHour;
    }

    /**
     * @param loadHour the loadHour to set
     */
    public void setLoadHour(Integer loadHour) {
        this.loadHour = loadHour;
    }

    /**
     * @return the loadMinute
     */
    public Integer getLoadMinute() {
        return loadMinute;
    }

    /**
     * @param loadMinute the loadMinute to set
     */
    public void setLoadMinute(Integer loadMinute) {
        this.loadMinute = loadMinute;
    }

    /**
     * @return the loadForecatEntsoe
     */
    public Integer getLoadForecatEntsoe() {
        return loadForecatEntsoe;
    }

    /**
     * @param loadForecatEntsoe the loadForecatEntsoe to set
     */
    public void setLoadForecatEntsoe(Integer loadForecatEntsoe) {
        this.loadForecatEntsoe = loadForecatEntsoe;
    }

    /**
     * @return the loadRealData
     */
    public Integer getLoadRealData() {
        return loadRealData;
    }

    /**
     * @param loadRealData the loadRealData to set
     */
    public void setLoadRealData(Integer loadRealData) {
        this.loadRealData = loadRealData;
    }

    @Override
    public String toString() {
        return "Load: " + this.getCountry().getName() + ",  " + this.getLoadDate() + ", " + this.getLoadHour() + ":" + this.getLoadMinute() + ", " + this.loadForecatEntsoe + ", " + this.getLoadRealData();
    }
    
    
}
