package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.command.Command;
import com.smhrd.model.WebMessageDAO;

public class DeleteAll implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");

		WebMessageDAO dao = new WebMessageDAO();
		int cnt = dao.delete(email);
		
		if(cnt>0) {
			System.out.println("메시지삭제성공");
		}else {
			System.out.println("메시지삭제실패");
		}
		
		return "main.jsp";
	}

}
