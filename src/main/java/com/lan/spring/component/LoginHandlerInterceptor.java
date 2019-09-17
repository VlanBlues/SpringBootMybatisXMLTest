package com.lan.spring.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Vlan
 * Date: 2019/8/16 15:41
 */

@Component
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("username");
        System.out.println("************"+user+"*****");
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        if (user == null) {
            // 获取request返回页面到登录页
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
