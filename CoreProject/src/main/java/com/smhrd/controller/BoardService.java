package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.command.Command;
import com.smhrd.model.WebBoard;
import com.smhrd.model.WebBoardDAO;

public class BoardService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String savaPath = request.getServletContext().getRealPath("file");
		System.out.println("저장경로 : "+savaPath);
		int maxSize = 10*1024*1024;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
		
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savaPath, maxSize ,encoding ,rename);
			String title =  multi.getParameter("title");
			String writer =  multi.getParameter("writer");
			String filename =  multi.getFilesystemName("filename");		
			String content = multi.getParameter("content");
			
			System.out.println("title : "+ title);
			System.out.println("writer : "+ writer);
			System.out.println("filename : "+ filename);
			System.out.println("content : "+ content);
			
			WebBoard board = new WebBoard(0, title, filename, content, null, writer);
			
			WebBoardDAO dao = new WebBoardDAO();
			int cnt = dao.upload(board);
			
			if(cnt>0) {
				System.out.println("업로드 성공");
			} else {
				System.out.println("업로드 실패");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "BoardWrite.jsp";
	}

}
