package com.smhrd.model;

public class ScheduleVO {

	private String t_conid;
	private String t_message;
	private String t_date;
	private String t_time;
	private String t_onOff;
	
	public ScheduleVO(String t_conid, String t_message, String t_date, String t_time, String t_onOff) {
		super();
		this.t_conid = t_conid;
		this.t_message = t_message;
		this.t_date = t_date;
		this.t_time = t_time;
		this.t_onOff = t_onOff;
	}

	public String getT_conid() {
		return t_conid;
	}

	public void setT_conid(String t_conid) {
		this.t_conid = t_conid;
	}

	public String getT_message() {
		return t_message;
	}

	public void setT_message(String t_message) {
		this.t_message = t_message;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public String getT_time() {
		return t_time;
	}

	public void setT_time(String t_time) {
		this.t_time = t_time;
	}

	public String getT_onOff() {
		return t_onOff;
	}

	public void setT_onOff(String t_onOff) {
		this.t_onOff = t_onOff;
	}
	
	
	
//	public ScheduleVO(String t_conid, String t_message, String t_date, String t_time, String t_onOff) {
//		super();
//		this.t_conid = t_conid;
//		this.t_message = t_message;
//		this.t_date = t_date;
//		this.t_time = t_time;
//		this.t_onOff = t_onOff;
//	}
//	// getter
//	public String getT_scheduleName() {
//		return t_conid;
//	}
//	public String getT_message() {
//		return t_message;
//	}
//	public String getT_date() {
//		return t_date;
//	}
//	public String getT_time() {
//		return t_time;
//	}
//	public String getT_onOff() {
//		return t_onOff;
//	}
//	
//	// setter
//	public void setT_scheduleName(String t_scheduleName) {
//		this.t_conid = t_conid;
//	}
//	public void sett_message(String t_message) {
//		this.t_message = t_message;
//	}
//	public void setT_date(String t_date) {
//		this.t_date = t_date;
//	}
//	public void setT_time(String t_time) {
//		this.t_time = t_time;
//	}
//	public void setT_onOff(String t_onOff) {
//		this.t_onOff = t_onOff;
//	}
//	
//	
}