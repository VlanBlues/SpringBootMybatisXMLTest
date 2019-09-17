package com.lan.spring.service.impl;

import com.lan.spring.mapper.UserMapper;
import com.lan.spring.service.UserService;
import com.lan.spring.bean.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/8/7 20:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Override
    public User getUser(int id) {
        
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> getUsers() {
        
        return userMapper.selectUsers();
    }

    @Override
    public Integer delUserById(Integer id) {
        return userMapper.delUserById(id);
    }
}
