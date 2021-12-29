package com.lsb.mapper;

import com.lsb.pojo.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoomMapper {
    /**
     * 查询所有工作
     * @return Room的集合
     */
    @Select("select * from tb_room")
    @ResultMap("roomResultMap")
    List<Room> selectAll();

    @Insert("insert into tb_room values (null,#{roomName},#{companyName},#{ordered},#{description},#{status})")
    void add(Room room);

    @Select("UPDATE tb_room SET room_name = #{roomName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id};")
    @ResultMap("roomResultMap")
    void update(Room room);

    @Select("UPDATE tb_room SET status = 0 WHERE id = #{id}")
    void deleteById(int id);

    @Select("select * from tb_room where borrow_date = #{borrowDate}")
    @ResultMap("roomResultMap")
    List<Room> selectByDate(String borrowDate);

    @Select("UPDATE tb_room SET status = #{userid} WHERE id = #{id}")
    void updateById(@Param("id") int id, @Param("userid") int userid);

    @Select("select * from tb_room where status = #{userid}")
    @ResultMap("roomResultMap")
    List<Room> selectByUser(int userid);
}
