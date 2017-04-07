package com.whitehorse.qingzhi.dao;


import java.util.List;

import com.whitehorse.qingzhi.entity.User;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
public interface UserDao {

    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
