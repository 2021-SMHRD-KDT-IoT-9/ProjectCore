package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor

public class WebMessage {
	
	@Getter
	private int num;
	@Getter
	private String sendName;
	@Getter
	private String receiveEmail;
	@Getter
	private String message;
	@Getter
	private String m_date;
	
	public WebMessage(String reciveEmail) {
		this.receiveEmail = reciveEmail;
	}

}
