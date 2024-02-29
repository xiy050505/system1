package com.service;

import com.mapper.AflMapper;
import com.pojo.Afl;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AflService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void addAfl(Afl afl) {
        SqlSession sqlSession = factory.openSession();
        AflMapper mapper = sqlSession.getMapper(AflMapper.class);
        mapper.addAfl(afl);
        sqlSession.commit();
        sqlSession.close();

    }

    public List<Afl> selectAllByUsername(String username) {
        SqlSession sqlSession = factory.openSession();
        AflMapper mapper = sqlSession.getMapper(AflMapper.class);
        List<Afl> afls = mapper.selectAllByUsername(username);
        sqlSession.close();

        return afls;
    }
    public List<Afl> selectAll(){
        SqlSession sqlSession = factory.openSession();
        AflMapper mapper = sqlSession.getMapper(AflMapper.class);
        List<Afl> afls = mapper.selectAll();
        sqlSession.close();
        return afls;
    }
    public void updateByUsername(String status,String username,String startTime){
        SqlSession sqlSession = factory.openSession();
        AflMapper mapper = sqlSession.getMapper(AflMapper.class);
        mapper.updateByUsername(status,username,startTime);
        sqlSession.commit();
        sqlSession.close();
    }
}
