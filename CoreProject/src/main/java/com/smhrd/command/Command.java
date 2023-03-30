package com.smhrd.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	// interface : 틀(ex, 이력서)
	// 추상 메소드: 값은 없지만, 메소드의 기본값을 설정해주는 역할
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
}
