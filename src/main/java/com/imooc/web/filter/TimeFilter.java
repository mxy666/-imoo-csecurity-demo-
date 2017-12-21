package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * create by mxy on 2017/12/21
 */

//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("do timeFilter");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("filter need time :" + ((new Date().getTime()) - start));

        System.out.println("finish timeFilter");

    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destory");

    }
}
