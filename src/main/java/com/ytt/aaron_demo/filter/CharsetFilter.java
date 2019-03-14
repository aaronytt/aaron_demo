package com.ytt.aaron_demo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component("charsetFilter")
public class CharsetFilter implements Filter {
    private static final Logger log =  LoggerFactory.getLogger(CharsetFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("过滤器初始化...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        //log.info("执行过滤操作");
        request.setCharacterEncoding("utf-8");

        HttpServletResponse resp = (HttpServletResponse)response;

        resp.setHeader("Access-Control-Max-Age", "172800000");
        resp.setHeader("Access-Control-Allow-Headers", "content-type,AuthToken");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
        //response.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", ":x-requested-with,content-type");
        //((HttpServletResponse)servletResponse).setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }

}
