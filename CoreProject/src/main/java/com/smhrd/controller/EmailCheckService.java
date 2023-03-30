package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class EmailCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String inputE = request.getParameter("inputE");
		
		// System.out.println(inputE);
		
		WebMemberDAO dao = new WebMemberDAO();
		//boolean result = dao.emailCheck(inputE); //-> boolean값 1개만 리턴
		WebMember vo = dao.emailCheck2(inputE);
		// async -> json/xml...
		// jackson (java object <-> json)
		ObjectMapper objectMapper = new ObjectMapper();
		
		//WebMember(Java Object) -> JSON
		String voJsonStr = objectMapper.writeValueAsString(vo);
		
		// 텍스트 출력 스트림(통로)
		PrintWriter out = response.getWriter();
		out.print(voJsonStr);
		
		System.out.println(voJsonStr);
		
	}
}
