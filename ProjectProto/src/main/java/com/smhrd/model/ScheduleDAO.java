package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class ScheduleDAO {

   private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSessionFactory();
   
   // t-alarm 스케줄 등록
   public int t_alarm(ScheduleVO vo) {
      SqlSession session = sqlSessionFactory.openSession(true);
      // true는 오토커밋, 기본값은 false임
      int cnt = session.insert("t_alarm", vo);
      session.close();
      return cnt;
   }

   // t_alarm 스케줄 불러오기(확인)
   public List<ScheduleVO> t_alarmAll(){
      SqlSession session = sqlSessionFactory.openSession(true);
      List<ScheduleVO> alarmList = session.selectList("t_alarmAll");
      session.close();
      return alarmList;
   }
   
}