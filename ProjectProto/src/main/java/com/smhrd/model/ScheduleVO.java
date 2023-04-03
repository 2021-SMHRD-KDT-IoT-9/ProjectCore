package com.smhrd.model;

public class ScheduleVO {

	private String t_concentName;
	private String t_appliance;
	private String t_date;
	private String t_time;
	private String t_onOff;
	
	public ScheduleVO(String t_concentName, String t_appliance, String t_date, String t_time, String t_onOff) {
		super();
		this.t_concentName = t_concentName;
		this.t_appliance = t_appliance;
		this.t_date = t_date;
		this.t_time = t_time;
		this.t_onOff = t_onOff;
	}
	// getter
	public String getT_scheduleName() {
		return t_concentName;
	}
	public String getT_appliance() {
		return t_appliance;
	}
	public String getT_date() {
		return t_date;
	}
	public String getT_time() {
		return t_time;
	}
	public String getT_onOff() {
		return t_onOff;
	}
	
	// setter
	public void setT_scheduleName(String t_scheduleName) {
		this.t_concentName = t_scheduleName;
	}
	public void setT_appliance(String t_appliance) {
		this.t_appliance = t_appliance;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public void setT_time(String t_time) {
		this.t_time = t_time;
	}
	public void setT_onOff(String t_onOff) {
		this.t_onOff = t_onOff;
	}
	
	
}