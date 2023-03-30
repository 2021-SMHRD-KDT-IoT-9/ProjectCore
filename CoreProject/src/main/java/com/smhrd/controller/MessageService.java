package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.command.Command;
import com.smhrd.model.WebMessage;
import com.smhrd.model.WebMessageDAO;

public class MessageService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String sendName = request.getParameter("name");
		String receiveEmail = request.getParameter("email");
		String message = request.getParameter("message");
		
		System.out.println(sendName);
		System.out.println(receiveEmail);
		System.out.println(message);
		
		WebMessage sendMessage = new WebMessage(0, sendName, receiveEmail, message, null);
		
		WebMessageDAO dao = new WebMessageDAO();
		int cnt = dao.send(sendMessage);
		
		if(cnt>0) {
			System.out.println("메시지 전송 성공");

		}else {
			System.out.println("메시지 전송실패");
		}
		
		return "main.jsp";
	}

}
