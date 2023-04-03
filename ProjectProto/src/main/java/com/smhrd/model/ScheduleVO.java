package com.smhrd.model;

public class ScheduleVO {

	private String t_scheduleName;
	private String t_appliance;
	private String t_date;
	private String t_onTime;
	private String t_offTime;	
	
	public ScheduleVO(String t_scheduleName, String t_appliance, String t_date, String t_onTime, String t_offTime) {
		super();
		this.t_scheduleName = t_scheduleName;
		this.t_appliance = t_appliance;
		this.t_date = t_date;
		this.t_onTime = t_onTime;
		this.t_offTime = t_offTime;
	}
	// getter
	public String getT_scheduleName() {
		return t_scheduleName;
	}
	public String getT_appliance() {
		return t_appliance;
	}
	public String getT_date() {
		return t_date;
	}
	public String getT_onTime() {
		return t_onTime;
	}
	public String getT_offTime() {
		return t_offTime;
	}
	
	
	
	// setter
	public void setT_scheduleName(String t_scheduleName) {
		this.t_scheduleName = t_scheduleName;
	}
	public void setT_appliance(String t_appliance) {
		this.t_appliance = t_appliance;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public void setT_onTime(String t_onTime) {
		this.t_onTime = t_onTime;
	}
	public void setT_offTime(String t_offTime) {
		this.t_offTime = t_offTime;
	}
	
	
	
	
}
