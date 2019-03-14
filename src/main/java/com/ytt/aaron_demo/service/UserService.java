package com.ytt.aaron_demo.service;

import com.ytt.aaron_demo.po.User;

public interface UserService {

    User getUser(String username, String password);

    int updateUesr();

}
