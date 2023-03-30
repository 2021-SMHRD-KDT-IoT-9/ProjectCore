package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.command.Command;
import com.smhrd.model.WebMessageDAO;

public class DeleteMessage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));

		WebMessageDAO dao = new WebMessageDAO();
		int cnt = dao.delete2(num);
		
		if(cnt>0) {
			System.out.println("메시지삭제성공");
		}else {
			System.out.println("메시지삭제실패");
		}
		
		return "main.jsp";
	}

}
