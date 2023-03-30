package com.smhrd.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.command.Command;
import com.smhrd.controller.BoardService;
import com.smhrd.controller.DeleteAll;
import com.smhrd.controller.DeleteMessage;
import com.smhrd.controller.DeleteService;
import com.smhrd.controller.JoinService;
import com.smhrd.controller.LoginService;
import com.smhrd.controller.MessageService;
import com.smhrd.controller.UpdateService;
import com.smhrd.controller.logoutService;
import com.smhrd.model.WebBoard;
import com.smhrd.model.WebBoardDAO;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;
import com.smhrd.model.WebMessage;
import com.smhrd.model.WebMessageDAO;

public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// url mapping값 변경 -> WEB_INF > web.xml에서 url매핑 확인
		// *.do -> 앞에 어떤 요청이 붙든 .do라는 확장자를 가지고 있으면
		// 전부 FrontController로 올 수 있도록 만든것!

		// 어떤 요청이 들어왔는지 확인
		String reqURI = request.getRequestURI();
		System.out.println(reqURI);

		// 프로젝트 이름 확인
		String conPath = request.getContextPath();
		System.out.println(conPath);

		// substring함수 사용해서 요청 값만 확인
		// substring(start) : start위치부터 끝까지 문자열 잘라내기
		// substring(start, end) : start위치부터 end전까지 문자열 잘라내기
		String result = reqURI.substring(conPath.length() + 1);
		System.out.println(result);

		request.setCharacterEncoding("UTF-8");

		Command con = null;

		if (result.equals("LoginService.do")) {
			con = new LoginService();
			// 업캐스팅

		} else if (result.equals("JoinService.do")) {
			con = new JoinService();

		} else if (result.equals("BoardService.do")) {
			con = new BoardService();

		} else if (result.equals("DeleteAll.do")) {
			con = new DeleteAll();

		} else if (result.equals("DeleteMessage.do")) {
			con = new DeleteMessage();

		} else if (result.equals("DeleteService.do")) {
			con = new DeleteService();

		} else if (result.equals("logoutService.do")) {
			con = new logoutService();

		} else if (result.equals("MessageService.do")) {
			con = new MessageService();

		} else if (result.equals("UpdateService.do")) {
			con = new UpdateService();
		}

		String moveURL = con.execute(request, response);
		response.sendRedirect(moveURL);
	}
}
