package com.lsb.service;

import com.lsb.mapper.RoomMapper;
import com.lsb.pojo.Room;
import com.lsb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RoomService {
    // 1.调用factory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Room> selectAll(){

        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        List<Room> rooms = mapper.selectAll();

        sqlSession.close();

        return rooms;
    }

    /**
     * 添加
     * @param
     */
    public void add(Room room){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        mapper.add(room);
        // 5.提交事务
        sqlSession.commit();
        // 6.释放资源
        sqlSession.close();
    }


    public void deleteById(int id){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        mapper.deleteById(id);
        // 5.提交事务
        sqlSession.commit();
        // 6.释放资源
        sqlSession.close();
    }
    public List<Room> selectByDate(String borrowDate){
        System.out.println(borrowDate);
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        List<Room> rooms = mapper.selectByDate(borrowDate);

        sqlSession.close();
        System.out.println(rooms);
        return rooms;
    }
    public void updateById(int id,int userid){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        mapper.updateById(id,userid);
        // 5.提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    public List<Room> selectByUser(int userid){

        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取RoomMapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 4.调用方法
        List<Room> rooms = mapper.selectByUser(userid);

        sqlSession.close();
        System.out.println(rooms);
        return rooms;
    }
}
