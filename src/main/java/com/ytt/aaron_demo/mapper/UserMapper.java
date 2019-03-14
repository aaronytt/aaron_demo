package com.ytt.aaron_demo.mapper;

import com.ytt.aaron_demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();

    User selectOne(@Param("username") String username,
                   @Param("password") String password);

}
