package com.service;

import com.mapper.DimissionMapper;
import com.pojo.Dimission;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DimissionService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void addADimission(Dimission Dimission) {
        SqlSession sqlSession = factory.openSession();
        DimissionMapper mapper = sqlSession.getMapper(DimissionMapper.class);
        mapper.addDimission(Dimission);
        sqlSession.commit();
        sqlSession.close();

    }

    public List<Dimission> selectAllByUsername(String username) {
        SqlSession sqlSession = factory.openSession();
        DimissionMapper mapper = sqlSession.getMapper(DimissionMapper.class);
        List<Dimission> Dimissions = mapper.selectAllByUsername(username);
        sqlSession.close();

        return Dimissions;
    }
    public List<Dimission> selectAll(){
        SqlSession sqlSession = factory.openSession();
        DimissionMapper mapper = sqlSession.getMapper(DimissionMapper.class);
        List<Dimission> dimissions = mapper.selectAll();
        sqlSession.close();

        return dimissions;
    }

    public void updateByUsername(String status,String username){
        SqlSession sqlSession = factory.openSession();
        DimissionMapper mapper = sqlSession.getMapper(DimissionMapper.class);
        mapper.updateByUsername(status,username);
        sqlSession.commit();
        sqlSession.close();
    }
}
