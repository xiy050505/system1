package com.service;

import com.mapper.AvatarMapper;
import com.pojo.Avatar;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AvatarService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public Avatar selectByUsername(String username){
        SqlSession sqlSession = factory.openSession();
        AvatarMapper mapper = sqlSession.getMapper(AvatarMapper.class);
        Avatar avatar = mapper.selectByUsername(username);
        sqlSession.close();
        return avatar;
    }
}
