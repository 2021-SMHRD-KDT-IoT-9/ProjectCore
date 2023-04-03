package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.smhrd.db.SqlSessionManager;

public class ScheduleDAO {

	private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSessionFactory();
	
	// t-Schedule 스케줄 등록
	public int tSchedule(ScheduleVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		// true는 오토커밋, 기본값은 false임
		int cnt = session.insert("t_schedule", vo);
		session.close();
		return cnt;
	}

	// tScheduleSelect 스케줄 불러오기(확인) 
	public List<ScheduleVO> tScheduleSelect(){
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ScheduleVO> list = session.selectList("tScheduleSelect");
		session.close();
		return list;
	}
	
}
