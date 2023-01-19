package com.calmkin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.User;
import com.calmkin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
   @Autowired
    private UserService userService;

   @Autowired
   private UserMapper userMapper;

    @Test
    public void testSelectUserInfo()
    {
        System.out.println(userService.selectAllById(18));
    }


    @Test
    public void testMapper()
    {
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.eq(User::getId,18);
        User user = userMapper.selectOne(qw);
        System.out.println(user);
    }


}
