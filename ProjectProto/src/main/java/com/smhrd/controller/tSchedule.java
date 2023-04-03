package com.smhrd.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;
import com.smhrd.model.ScheduleDAO;
import com.smhrd.model.ScheduleVO;

import oracle.sql.DATE;

public class tSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 스케줄 이름
		String t_conid = request.getParameter("t_conid");

		// 날짜
		Date t_date = java.sql.Date.valueOf(request.getParameter("t_date"));

		// 설정 시간
		String t_time = request.getParameter("t_time");
		
		// ON/OFF 시간  ---> 데이터타입 고민.......
		String t_onOff = request.getParameter("t_onOff");
		
		String t_message = request.getParameter("t_message");	
		
		
		ScheduleVO vo = new ScheduleVO(t_conid, t_message, t_date, t_time, t_onOff);
		ScheduleDAO dao = new ScheduleDAO();
		int cnt = dao.t_alarm(vo);
		
		if (cnt > 0) {
			System.out.println("스케줄 등록 성공!");
			response.sendRedirect("Main.jsp");
		} else {
			System.out.println("스케줄 등록 실패...");
			response.sendRedirect("Main.jsp");
		}
		
		
	}
}
