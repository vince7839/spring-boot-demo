package com.example.service;

import com.example.mapper.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService{


    @Autowired
    UserMapper userMapper;

    @CacheEvict(value = "realTimeCache", allEntries = true)
    public void addUser(User user) {
        System.out.println("add  user");
        userMapper.addUser(user);
    }

    @Cacheable(value = "realTimeCache", key = "#uid")
    public User findUserById(Integer uid) {
        System.out.println("selectById");
        User user = userMapper.selectById(uid);
        return user;
    }
}
