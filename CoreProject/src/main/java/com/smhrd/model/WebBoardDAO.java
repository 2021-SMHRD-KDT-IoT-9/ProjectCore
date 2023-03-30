package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class WebBoardDAO {

	SqlSessionFactory sessionFactory = SqlSessionManager.getSessionFactory();

	// 파일업로드
	public int upload(WebBoard board) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.insert("upload", board);
		sqlsession.close();
		return cnt;
	}
	
	// 게시글 전체 조회
	public List<WebBoard> boardAll() {
		SqlSession sqlsession = sessionFactory.openSession(true);
		List<WebBoard> boardList = sqlsession.selectList("boardAll");
		sqlsession.close();
		return boardList;
	}
	
	// 게시글 세부 내용 조회
	public WebBoard board(int num) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		WebBoard board = sqlsession.selectOne("board",num);
		sqlsession.close();
		return board;
	}
}
