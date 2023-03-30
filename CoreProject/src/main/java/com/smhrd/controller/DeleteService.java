package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.command.Command;
import com.smhrd.model.WebMemberDAO;

public class DeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.delete(email);
		
		if(cnt>0) {
			System.out.println("회원삭제성공");
		}else {
			System.out.println("회원삭제실패");
		}
		
		return "select.jsp";
	}

}
