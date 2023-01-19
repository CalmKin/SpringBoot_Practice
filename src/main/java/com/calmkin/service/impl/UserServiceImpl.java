package com.calmkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.User;
import com.calmkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectAllById(int id) {
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.eq(User::getId,id);
        User user = userMapper.selectOne(qw);
        return user; 
    }



}
