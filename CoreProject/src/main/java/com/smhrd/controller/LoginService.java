package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.command.Command;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class LoginService implements Command{

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		WebMember vo = new WebMember(email, pw);

		WebMemberDAO dao = new WebMemberDAO();
		WebMember loginMember = dao.login(vo);

		if (loginMember != null) {
			// 로그인 성공
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
		} else {
			// 로그인 실패
			System.out.println("로그인 실패");
		}
		
		return "main.jsp";
	}

}
