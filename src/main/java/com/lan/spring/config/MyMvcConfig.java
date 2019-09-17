package com.lan.spring.config;

import com.lan.spring.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: Vlan
 * Date: 2019/8/16 15:47
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/login");
    }
}
