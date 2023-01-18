package com.calmkin;

import com.calmkin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
   @Autowired
    private UserService userService;

    @Test
    public void testSelectUserInfo()
    {
        System.out.println(userService.selectAllById(18));
    }

}
