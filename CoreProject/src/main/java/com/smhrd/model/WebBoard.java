package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //getter
@AllArgsConstructor //전체생성자
@NoArgsConstructor //기본생성자
public class WebBoard {

	private int num;
	private String title;
	private String filename;
	private String content;
	private String b_date;
	private String writer;
	
	
//	public WebBoard() {
//	}
//	
//	public WebBoard(int num, String title, String filename, String content, String b_date, String writer) {
//		this.num = num;
//		this.title = title;
//		this.writer = writer;
//		this.filename = filename;
//		this.content = content;
//		this.b_date = b_date;
//	}
//	
//	public int getNum() {
//		return num;
//	}
//	
//	public String getTitle() {
//		return title;
//	}
//	
//	public String getWriter() {
//		return writer;
//	}
//	
//	public String getFilename() {
//		return filename;
//	}
//	
//	public String getContent() {
//		return content;
//	}
//	
//	public String getB_date() {
//		return b_date;
//	}
}
