package com.ytt.aaron_demo.service;

import com.ytt.aaron_demo.po.User;

public interface LoginService {

    User login(String username, String password);

}
