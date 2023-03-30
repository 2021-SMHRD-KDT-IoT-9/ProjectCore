package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.command.Command;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class JoinService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		WebMember vo = new WebMember(email, pw, tel, address);
		
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.join(vo);
		
		if(cnt>0) {
			// 회원가입 성공
			System.out.println("회원가입 성공!");
//			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
//			request.setAttribute("joinEmail", email);
//			rd.forward(request, response);
//			response.sendRedirect("joinSuccess.jsp?joinEmail="+email);
			return "joinSuccess.jsp?joinEmail="+email;
		}else {
			// 회원가입 실패
			System.out.println("회원가입 실패!");
//			response.sendRedirect("main.jsp");
			return "main.jsp";
		}
		
	}

}
