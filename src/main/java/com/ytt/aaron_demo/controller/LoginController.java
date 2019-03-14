package com.ytt.aaron_demo.controller;

import com.ytt.aaron_demo.config.StringUtil;
import com.ytt.aaron_demo.po.User;
import com.ytt.aaron_demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final static Logger LOG= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/to")
    public String login(HttpServletRequest request, HttpServletResponse response){

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        LOG.info(StringUtil.combine("在", remoteAddr, "访问登陆主页"));
        return "/views/login";
    }

    @ResponseBody
    @RequestMapping(value = "/into",method = RequestMethod.POST)
    public User loginInto(@RequestParam("userid") String username,
                            @RequestParam("psw") String password){

        User user = loginService.login(username,password);

        return user;

    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String[] login(String username, String password){
//        loginService.login(username,password);
//        ((UserService)loginService).updateUesr();
//        return new String[]{"welcome","come"};
//    }

}
