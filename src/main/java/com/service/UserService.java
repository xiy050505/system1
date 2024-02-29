package com.service;

import com.mapper.UserMapper;
import com.pojo.EInformation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;

import java.util.List;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User mLogin(User user) {

        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.mselect(user);

        sqlSession.close();

        return user1;
    }

    public User eLogin(User user) {

        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.eselect(user);

        sqlSession.close();

        return user1;
    }

    public EInformation eSelectByUsername(String username) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        EInformation eInformation = mapper.eSelectByUsername(username);

        sqlSession.close();

        return eInformation;
    }

    public void updateByUsername( String status,  String username){
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateByUsername(status,username);

        sqlSession.commit();

        sqlSession.close();
    }

    public void updateInformation(EInformation eI) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateInformation(eI);

        sqlSession.commit();

        sqlSession.close();

    }

    public void register(String username, String password,String status) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.register(username, password,status);

        sqlSession.commit();

        sqlSession.close();
    }

    public User selectByUsername(String username) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUsername(username);

        sqlSession.close();

        return user;
    }

    public List<EInformation> selectAll() {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<EInformation> eInformations = mapper.selectAll();

        sqlSession.close();

        return eInformations;
    }

    public void addInformation(EInformation eI) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addInformation(eI);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteByUsername(String username) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteByUsername(username);

        sqlSession.commit();

        sqlSession.close();
    }

    public List<EInformation> select(EInformation eI){
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<EInformation> eInformations = mapper.select(eI);

        sqlSession.close();

        return eInformations;
    }
}
