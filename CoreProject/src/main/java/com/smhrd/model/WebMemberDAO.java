package com.smhrd.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class WebMemberDAO {
	
	SqlSessionFactory sessionFactory = SqlSessionManager.getSessionFactory();

	// 회원가입
	public int join(WebMember vo) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.insert("join",vo);
		sqlsession.close();
		return cnt;
	}
	
	// 로그인
	public WebMember login(WebMember vo) {
		WebMember loginMember = null;
		SqlSession sqlSession = sessionFactory.openSession(true);
		loginMember = sqlSession.selectOne("login", vo);
		sqlSession.close();
		return loginMember;
	}
	
	// 회원정보 수정
	public int update(WebMember vo) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.update("update",vo);
		sqlsession.close();
		return cnt;
	}
	
	// 전체회원정보 불러오기
	// 여러개의 객체를 묶어서 반환 -> List<실제 리스트안에 들어가는 객체의 타입>
	public List<WebMember> select(){
		SqlSession sqlsession = sessionFactory.openSession(true);
		List<WebMember> list = sqlsession.selectList("select");
		sqlsession.close();
		return list;
	}
	
	// 삭제기능
	public int delete(String email) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		int cnt = sqlsession.delete("delete",email);
		sqlsession.close();
		return cnt;
	}
	
	// 이메일 중복체크
	public boolean emailCheck(String input) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		boolean result = sqlsession.selectOne("emailCheck", input);
		sqlsession.close();		
		return result; //true(있는값->사용x), false(없는값->사용o)
	}
	
	// 이메일 중복체크(객체가져오기)
	public WebMember emailCheck2(String input) {
		SqlSession sqlsession = sessionFactory.openSession(true);
		WebMember result2 = sqlsession.selectOne("emailCheck2", input);
		sqlsession.close();		
		return result2;
	}
	
}
