package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;

@WebServlet("/tLogin")
public class tLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		

		MemberVO vo = new MemberVO(id, pw);

		MemberDAO dao = new MemberDAO();
		MemberVO vo2 = dao.tlogin(vo);


		if (vo2 == null) { 
			System.out.println("로그인 실패...");
			response.sendRedirect("Login.jsp");
		} else { 
			System.out.println("로그인 성공!");
			response.sendRedirect("Main.jsp");
		}		
	}
}
