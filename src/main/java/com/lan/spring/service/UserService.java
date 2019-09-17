package com.lan.spring.service;

import com.lan.spring.bean.User;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/8/7 19:59
 */

public interface UserService {
    
    User getUser(int id);

    List<User> getUsers();
    
    Integer delUserById(Integer id);
}
