package com.service;

import com.mapper.SalaryMapper;
import com.pojo.Salary;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SalaryService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Salary selectCurrentSalary(String username, String month) {

        SqlSession sqlSession = factory.openSession();
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);
        Salary salary = mapper.selectCurrentSalary(username, month);
        sqlSession.close();

        return salary;
    }

    public List<Salary> selectAllByUsername(String username){
        SqlSession sqlSession = factory.openSession();
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);
        List<Salary> salarys = mapper.selectAllByUsername(username);
        sqlSession.close();

        return salarys;

    }
}
