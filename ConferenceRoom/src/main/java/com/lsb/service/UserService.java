package com.lsb.service;

import com.lsb.mapper.UserMapper;
import com.lsb.pojo.User;
import com.lsb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    // 1.获取factory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User selectUser(String username, String password){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用mapper方法
        User user = mapper.selectUser(username, password);

        sqlSession.close();

        return user;
    }
    public User selectByUsername(String username){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用mapper方法
        User user = mapper.selectByUsername(username);

        sqlSession.close();

        return user;
    }
    public void addUser(User user){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用mapper方法
        mapper.addUser(user);
        //5.提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
