package com.lan.spring.mapper;

import com.lan.spring.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: Vlan
 * Date: 2019/8/7 19:50
 */

public interface UserMapper {
    
    //@Select("select * from user")
    User selectUser(int id);
    
    List<User> selectUsers();
    
    Integer delUserById(Integer id);
}
