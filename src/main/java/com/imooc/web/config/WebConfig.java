package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * create by mxy on 2017/12/21
 */
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    TimeInterceptor timeInterceptor;

    //注册一个interceptor
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        // interceptorRegistry.addInterceptor(timeInterceptor);

    }

    //注册送一个filterBean
    //   @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);//哪些路径需要过滤器
        return filterRegistrationBean;

    }
}
