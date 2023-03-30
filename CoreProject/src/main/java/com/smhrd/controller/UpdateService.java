package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.command.Command;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class UpdateService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		// 현재 로그인한 사용자의 이메일 -> 세션
		
		HttpSession session = request.getSession();
		
		// 로그인할 때 저장된 현재 이메일, 비번, 전화번호, 집주소
		WebMember vo = (WebMember)session.getAttribute("loginMember");
		String email = vo.getEmail();
		 
		WebMember vo2 = new WebMember(email, pw, tel, address);
		
		WebMemberDAO dao = new WebMemberDAO();
		
		int cnt =dao.update(vo2);
		
		if(cnt>0) {
			System.out.println("정보수정성공!");
			session.setAttribute("loginMember", vo2);
		}else {
			System.out.println("정보수정실패!");
		}
		
		return "main.jsp";
	}

}
