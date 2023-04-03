package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;
import com.smhrd.model.ScheduleDAO;
import com.smhrd.model.ScheduleVO;

public class tSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 스케줄 이름
		String scheduleName = request.getParameter("scheduleName");
		// 설정할 기기이름
		String appliance = request.getParameter("appliance");
		
		// 날짜
		String date = request.getParameter("date");
		
		// ON 시간 ---> 데이터타입 고민.......
		String onTime = request.getParameter("onTime");
		
		// OFF 시간  ---> 데이터타입 고민.......
		String offTime = request.getParameter("offTime");
		
		System.out.println("오류확인");
		System.out.println(scheduleName);
		System.out.println(appliance);
		System.out.println(date);
		System.out.println(onTime);
		System.out.println(offTime);
		
		
		ScheduleVO vo = new ScheduleVO(scheduleName, appliance, date, onTime, offTime);
		ScheduleDAO dao = new ScheduleDAO();
		int cnt = dao.tSchedule(vo);
		
		if (cnt > 0) {
			System.out.println("스케줄 등록 성공!");
			response.sendRedirect("Main.jsp");
		} else {
			System.out.println("스케줄 등록 실패...");
			response.sendRedirect("Main.jsp");
		}
		
	}
}
