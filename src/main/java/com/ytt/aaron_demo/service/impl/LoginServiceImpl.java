package com.ytt.aaron_demo.service.impl;

import com.ytt.aaron_demo.config.StringUtil;
import com.ytt.aaron_demo.po.User;
import com.ytt.aaron_demo.service.LoginService;
import com.ytt.aaron_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private final static Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public User login(String username, String password){
        User user = userService.getUser(username,password);
        if(user != null){
            LOG.info(StringUtil.combine(">>>> * ", username ," * >>>>pass ytt"));
        }else {
            LOG.info(StringUtil.combine(">>>> * ", username ," * >>>>password error"));
        }
        return user;
    }

}
