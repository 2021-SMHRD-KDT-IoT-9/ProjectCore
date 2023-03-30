package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@RequiredArgsConstructor

public class WebMember {
	
	@NonNull
	private String email;
	@NonNull String pw;
	private String tel;
	private String address;

	@Override
	public String toString() {
		return "WebMember [email=" + email + ", pw=" + pw + ", tel=" + tel + ", address=" + address + "]";
	}
	
//	public WebMember(String email, String pw, String tel, String address) {
//		this.email = email;
//		this.pw = pw;
//		this.tel = tel;
//		this.address = address;
//	}
//	
//	public WebMember(String email, String pw) {
//		this.email = email;
//		this.pw = pw;
//	}
//
//	public WebMember() {
//
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public String getPw() {
//		return pw;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public String getAddress() {
//		return address;
//	}

}
