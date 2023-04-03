package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class MemberDAO {

   private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSessionFactory();
   
   // t-join
   public int tjoin(MemberVO vo) {
      SqlSession session = sqlSessionFactory.openSession(true);
      // true는 오토커밋, 기본값은 false임
      int cnt = session.insert("tjoin", vo);
      session.close();
      return cnt;
   }
   
   //t-login
   public MemberVO tlogin(MemberVO vo) { // vo : 사용자가 입력한 id/pw
      SqlSession session = sqlSessionFactory.openSession(true);
      // selectOne : 무조건 행 1개만 가지고 올 수 있음!
      // 조건으로 준 값이 여러개의 행에 존재할 경우에는 오류발생!
      MemberVO vo2 = session.selectOne("tlogin", vo); // 로그인 작업에는 selectOne이 좋음
      session.close();
      return vo2;
   }
   
}
