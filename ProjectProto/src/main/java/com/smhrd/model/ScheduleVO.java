package com.smhrd.model;

public class ScheduleVO {

	private String scheduleName;
	private String appliance;
	private String date;
	private String onTime;
	private String offTime;
	
	
	
	public ScheduleVO(String scheduleName, String appliance, String date, String onTime, String offTime) {
		super();
		this.scheduleName = scheduleName;
		this.appliance = appliance;
		this.date = date;
		this.onTime = onTime;
		this.offTime = offTime;
	}
	
	
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public void setAppliance(String appliance) {
		this.appliance = appliance;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}


	public String getScheduleName() {
		return scheduleName;
	}


	public String getAppliance() {
		return appliance;
	}


	public String getDate() {
		return date;
	}


	public String getOnTime() {
		return onTime;
	}


	public String getOffTime() {
		return offTime;
	}
	
	
	
	
}
