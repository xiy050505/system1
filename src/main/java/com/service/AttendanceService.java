package com.service;

import com.mapper.AttendanceMapper;
import com.pojo.Attendance;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AttendanceService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public Attendance attendanceSelect(String username,String year,String month){

        SqlSession sqlSession = factory.openSession();
        AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
        Attendance attendance = mapper.attendanceSelect(username, year, month);
        sqlSession.close();

        return attendance;

    }

    public void updateTypeLate(String late,String username,String year,String month){
        SqlSession sqlSession = factory.openSession();
        AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
        mapper.updateTypeLate(late, username, year, month);
        sqlSession.commit();
        sqlSession.close();
    }
    public void updateTypeEarly(String early,String username,String year,String month){
        SqlSession sqlSession = factory.openSession();
        AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
        mapper.updateTypeEarly(early, username, year, month);
        sqlSession.commit();
        sqlSession.close();
    }
    public void updateTypeAbsence(String absence,String username,String year,String month){
        SqlSession sqlSession = factory.openSession();
        AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
        mapper.updateTypeAbsence(absence, username, year, month);
        sqlSession.commit();
        sqlSession.close();
    }
    public void updateTypeAfl(String afl,String username,String year,String month){
        SqlSession sqlSession = factory.openSession();
        AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
        mapper.updateTypeAfl(afl, username, year, month);
        sqlSession.commit();
        sqlSession.close();
    }
}
