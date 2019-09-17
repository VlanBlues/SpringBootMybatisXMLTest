package com.lan.spring.controller;

import com.lan.spring.bean.User;
import com.lan.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Vlan
 * Date: 2019/8/7 19:51
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/user")
    public User getUser(){
        //return userMapper.selectUser();
        return userService.getUser(1);
    }

    @ResponseBody
    @RequestMapping("/user/del")
    public Integer delUserById(Integer id){
        return userService.delUserById(id);
    }

    @ResponseBody
    @RequestMapping("/users")
    public Map<String,Object> getUsers(Integer page,Integer limit){
        //return userMapper.selectUser();
        List<User> users = userService.getUsers();
        List<User> users1 = null;
        int page1 = users.size()/limit;
        if(users.size() % limit !=0 && page1+1==page){
            users1 = users.subList(page * limit - limit, users.size());
        }else {
            users1 = users.subList(page * limit - limit, page * limit-1);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",users.size());
        map.put("data",users1);
        
        return map;
    }

    @RequestMapping("/")
    public String login(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }

    @RequestMapping("/admin/")
    public String index(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/admin/login")
    public String AdminLogin(User user, HttpSession session){
        List<User> users = userService.getUsers();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(user.getUsername())&& users.get(i).getPassword().equals(user.getPassword())){
                session.setAttribute("username",user.getUsername());
                return "1";
            }
        }
        return "0";
    }

    @ResponseBody
    @RequestMapping("/admin/admin/login")
    public String Login(User user, HttpSession session){
        List<User> users = userService.getUsers();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(user.getUsername())&& users.get(i).getPassword().equals(user.getPassword())){
                session.setAttribute("username",user.getUsername());
                return "1";
            }
        }
        return "0";
    }

    @RequestMapping("/admin/main")
    public String AdminMain(){
        return "main";
    }

}
