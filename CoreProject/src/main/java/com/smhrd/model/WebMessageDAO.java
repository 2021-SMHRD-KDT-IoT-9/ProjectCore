package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class WebMessageDAO {

	SqlSessionFactory sessionFactory = SqlSessionManager.getSessionFactory();

	// 메시지 보내기
	public int send(WebMessage sendMessage) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.insert("send", sendMessage);
		sqlsession.close();
		return cnt;
	}

	public List<WebMessage> select(WebMessage reciveEmail) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		List<WebMessage> list = sqlsession.selectList("selectMessage", reciveEmail);
		sqlsession.close();
		return list;
	}

	public int delete(String reciveEmail) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.delete("deleteAll", reciveEmail);
		sqlsession.close();
		return cnt;
	}

	public int delete2(int num) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.delete("deleteMessage", num);
		sqlsession.close();
		return cnt;
	}
	
}
