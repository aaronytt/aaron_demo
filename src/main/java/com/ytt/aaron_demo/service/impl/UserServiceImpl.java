package com.ytt.aaron_demo.service.impl;

import com.ytt.aaron_demo.mapper.UserMapper;
import com.ytt.aaron_demo.po.User;
import com.ytt.aaron_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username, String password) {

        User user = userMapper.selectOne(username,password);

        return user;
    }

    @Override
    public int updateUesr() {

        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");

        return  0;

    }


}
